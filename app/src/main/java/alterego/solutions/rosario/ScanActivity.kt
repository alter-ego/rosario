package alterego.solutions.rosario

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import org.udoo.udooblulib.manager.UdooBluManager
import org.udoo.udooblulib.sensor.Constant
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class ScanActivity : AppCompatActivity() {

    @Inject
    lateinit var udooBluManager: UdooBluManager

    lateinit var scanSubscription: Subscription

    lateinit var address: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App[this].component().inject(this);
        setContentView(R.layout.activity_scan)

        Handler().postDelayed(
            {
                udooBluManager.scanLeDevice(true)
                    .filter({ result -> result.toString().contains("B0:B4:48:") })
                    .distinctUntilChanged({ it.device })
                    .doOnNext { address = it.device.address }
                    .concatMap { udooBluManager.connect(it.device.address) }
                    .filter({ true })
                    .map { udooBluManager.discoveryServices(address); }
                    .filter({ true })
                    .map { udooBluManager.setIoPinMode(address, Constant.IOPIN.D6, Constant.IOPIN_TYPE.DIGITAL, Constant.IOPIN_MODE.INPUT) }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        {
                            Timber.d(udooBluManager.digitalRead(address, Constant.IOPIN.D6)[0].toInt().toString())
                        },
                        { error -> Timber.e(error.message) })
            }, 4000)
    }
}
