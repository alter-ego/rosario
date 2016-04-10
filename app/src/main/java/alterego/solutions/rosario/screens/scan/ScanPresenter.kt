package alterego.solutions.rosario.screens.scan

import alterego.solutions.rosario.utils.bioparco
import android.bluetooth.le.ScanResult
import android.os.Handler
import org.udoo.udooblulib.interfaces.IBleDeviceListener
import org.udoo.udooblulib.interfaces.OnCharacteristicsListener
import org.udoo.udooblulib.manager.UdooBluManager
import org.udoo.udooblulib.scan.BluScanCallBack
import org.udoo.udooblulib.sensor.Constant
import org.udoo.udooblulib.sensor.UDOOBLESensor
import rx.Observable
import rx.Subscription
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ScanPresenter @Inject constructor(val udooBluManager: UdooBluManager) {

    lateinit var view: IScanView

    var readSbscription: Subscription? = null

    fun startScan() {
        view.hideScanButton()
        view.startProgress()
        Handler().postDelayed({
            udooBluManager.scanLeDevice(true, object : BluScanCallBack() {
                override fun onBatchScanResults(results: MutableList<ScanResult>?) {
                    super.onBatchScanResults(results)
                }

                override fun onScanFailed(errorCode: Int) {
                    super.onScanFailed(errorCode)
                    bioparco("Scan error: $errorCode")
                    view.showScanButton()
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
                                val address = device?.address ?: ""
                                Timber.d("Address $device")
                                view.stopProgress()
                                view.setAddress(device?.address!!)
                                view.showScanButton()

                                udooBluManager.enableSensor(device?.address, UDOOBLESensor.IOPIN, true)
                                udooBluManager.setIoPinMode(device?.address, Constant.IOPIN.D6, Constant.IOPIN_TYPE.DIGITAL, Constant.IOPIN_MODE.INPUT)

                                read(address)
                            }
                        })
                    }

                }
            });

        }, 100);
    }

    fun read(address: String) {
        readSbscription = Observable.interval(300, TimeUnit.MILLISECONDS)
            .subscribe({
                udooBluManager.digitalRead(address, object : OnCharacteristicsListener {
                    override fun onCharacteristicChanged(uuidStr: String?, rawValue: ByteArray?) {
                        Timber.d("onCharacteristicChanged $uuidStr")
                    }

                    override fun onCharacteristicsRead(uuidStr: String?, value: ByteArray?, status: Int) {
                        Timber.d("onCharacteristicsRead $uuidStr $value $status")
                    }
                })
            })
    }

    fun dispose() {
        readSbscription?.unsubscribe()
    }
}
