package alterego.solutions.rosario.input_button

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
class InputButtonManager @Inject constructor(val udooBluManager: UdooBluManager) : IInputButtonManager {

    val address = "B0:B4:48:C3:B1:81"

    var readSubscription: Subscription? = null

    var button: BehaviorSubject<Int> = BehaviorSubject.create()

    override fun setup(): Observable<Boolean> {
        return Observable.timer(2, TimeUnit.SECONDS).concatMap { connect() }
    }

    override fun connect(): Observable<Boolean> {
        return Observable.create {
            val subscriber = it
            udooBluManager.connect(address, object : IBleDeviceListener {
                override fun onDeviceConnected() {
                    udooBluManager.discoveryServices(address)
                }

                override fun onDeviceDisconnect() {
                    subscriber.onNext(false)
                }

                override fun onServicesDiscoveryCompleted() {
                    val address = address
                    udooBluManager.enableSensor(address, UDOOBLESensor.IOPIN, true)
                    udooBluManager.setIoPinMode(address, Constant.IOPIN.D6, Constant.IOPIN_TYPE.DIGITAL, Constant.IOPIN_MODE.INPUT)
                    subscriber.onNext(true)
                }
            })
        }
    }

    override fun read(): Observable<Int> {
        readSubscription = Observable.interval(500, TimeUnit.MILLISECONDS)
            .subscribe({
                udooBluManager.digitalRead(address, object : OnCharacteristicsListener {
                    override fun onCharacteristicChanged(uuidStr: String?, rawValue: ByteArray?) {
                        Timber.d("onCharacteristicChanged $uuidStr")
                    }

                    override fun onCharacteristicsRead(uuidStr: String?, value: ByteArray, status: Int) {
                        if (value[0].toInt() == 64) {
                            button.onNext(1)
                        } else {
                            button.onNext(0)
                        }
                    }
                })
            })
        return button
    }

    fun dispose() {
        readSubscription?.unsubscribe()
    }
}
