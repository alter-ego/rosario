package alterego.solutions.rosario

import android.bluetooth.le.ScanResult
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import org.udoo.udooblulib.interfaces.IBleDeviceListener
import org.udoo.udooblulib.manager.UdooBluManager
import org.udoo.udooblulib.scan.BluScanCallBack
import org.udoo.udooblulib.sensor.Constant
import org.udoo.udooblulib.sensor.UDOOBLESensor
import rx.Subscription
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

        Handler().postDelayed({
            udooBluManager.scanLeDevice(true, object : BluScanCallBack() {
                override fun onBatchScanResults(results: MutableList<ScanResult>?) {
                    super.onBatchScanResults(results)
                }

                override fun onScanFailed(errorCode: Int) {
                    super.onScanFailed(errorCode)
                }

                override fun onScanResult(callbackType: Int, result: ScanResult?) {
                    super.onScanResult(callbackType, result)
                    val device = result?.device
                    if (device?.address!!.startsWith("B0:B4:48")) {
                        udooBluManager.connect(device?.address, object : IBleDeviceListener {
                            override fun onDeviceConnected() {
                                udooBluManager.discoveryServices(device?.address)
                            }

                            override fun onDeviceDisconnect() {
                            }

                            override fun onServicesDiscoveryCompleted() {
                                udooBluManager.enableSensor(device?.address, UDOOBLESensor.IOPIN, true)
                                udooBluManager.setIoPinMode(device?.address, Constant.IOPIN.D6, Constant.IOPIN_TYPE.DIGITAL, Constant.IOPIN_MODE.INPUT)
                                while (true) {
                                    udooBluManager.digitalRead(device?.address, Constant.IOPIN.D6)
                                    Thread.sleep(200)
                                }
                            }
                        })
                    }

                }
            });

        }, 100);
    }

    override fun onDestroy() {
        super.onDestroy()
        scanSubscription.unsubscribe()
    }
}
