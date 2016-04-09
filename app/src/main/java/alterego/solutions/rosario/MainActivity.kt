package alterego.solutions.rosario

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import org.udoo.udooblulib.manager.UdooBluManager
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var udooBluManager: UdooBluManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App[this].component().inject(this);
        setContentView(R.layout.activity_main)

        Handler().postDelayed(
            {
                udooBluManager.scanLeDevice(true)
                    .filter({ result -> result.st("B0:B4:48:") })
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
    }
}
