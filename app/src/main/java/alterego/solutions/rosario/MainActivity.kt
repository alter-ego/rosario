package alterego.solutions.rosario

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.SeekBar
import android.widget.TextView
import com.triggertrap.seekarc.SeekArc
import org.udoo.udooblulib.manager.UdooBluManager
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var udooBluManager: UdooBluManager
    lateinit var mSeekark: SeekArc
    lateinit var mSeekarcprogress: TextView
    lateinit var mSeekark1: SeekArc
    lateinit var mSeekarcprogress1: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App[this].component().inject(this);
        setContentView(R.layout.activity_main)

        mSeekarcprogress = findViewById(R.id.seekArcProgress) as TextView
        mSeekarcprogress1 = findViewById(R.id.seekArcProgress1) as TextView

        Handler().postDelayed(
            {
                udooBluManager.scanLeDevice(true)
                    .distinctUntilChanged()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        {
                            scanResult ->
                            val device = scanResult.device;
                            Timber.d(device.toString())
                        },
                        { error -> Timber.e(error.message) })
            }, 2000)

        mSeekark = findViewById(R.id.seekArc) as SeekArc
        mSeekark1 = findViewById(R.id.seekArc1) as SeekArc

        mSeekark.setOnSeekArcChangeListener(object : SeekArc.OnSeekArcChangeListener{

            override fun onProgressChanged(p0: SeekArc?, p1: Int, p2: Boolean) {
                mSeekarcprogress.setText(p1.toString())
                mSeekark1.progress = p1
            }

            override fun onStartTrackingTouch(p0: SeekArc?) {
                //mSeekarcprogress.setText(p0.toString())
            }

            override fun onStopTrackingTouch(p0: SeekArc?) {
                //mSeekarcprogress.setText(p0.toString())
            }

        })


    }
}
