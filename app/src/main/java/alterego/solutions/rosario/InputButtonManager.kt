package alterego.solutions.rosario

import org.udoo.udooblulib.interfaces.IBleDeviceListener
import org.udoo.udooblulib.interfaces.OnCharacteristicsListener
import org.udoo.udooblulib.manager.UdooBluManager
import org.udoo.udooblulib.sensor.Constant
import org.udoo.udooblulib.sensor.UDOOBLESensor
import rx.Observable
import rx.Subscription
import rx.subjects.BehaviorSubject
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InputButtonManager @Inject constructor(val udooBluManager: UdooBluManager) {

    val address = "B0:B4:48:C3:B1:81"

    var readSubscription: Subscription? = null

    var button: BehaviorSubject<Int> = BehaviorSubject.create()

    fun connect() {
        udooBluManager.connect(address, object : IBleDeviceListener {
            override fun onDeviceConnected() {
                udooBluManager.discoveryServices(address)
            }

            override fun onDeviceDisconnect() {
            }

            override fun onServicesDiscoveryCompleted() {
                val address = address
                Timber.d("Address $address")

                udooBluManager.enableSensor(address, UDOOBLESensor.IOPIN, true)
                udooBluManager.setIoPinMode(address, Constant.IOPIN.D6, Constant.IOPIN_TYPE.DIGITAL, Constant.IOPIN_MODE.INPUT)
            }
        })
    }

    fun read() {
        readSubscription = Observable.interval(300, TimeUnit.MILLISECONDS)
            .subscribe({
                udooBluManager.digitalRead(address, object : OnCharacteristicsListener {
                    override fun onCharacteristicChanged(uuidStr: String?, rawValue: ByteArray?) {
                        Timber.d("onCharacteristicChanged $uuidStr")
                    }

                    override fun onCharacteristicsRead(uuidStr: String?, value: ByteArray?, status: Int) {
                        Timber.d("onCharacteristicsRead $uuidStr $value $status")
                        button.onNext(status)
                    }
                })
            })
    }

    fun dispose() {
        readSubscription?.unsubscribe()
    }
}
