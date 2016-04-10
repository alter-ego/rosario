package alterego.solutions.rosario.storage

import com.firebase.client.DataSnapshot
import com.firebase.client.Firebase
import com.firebase.client.FirebaseError
import com.firebase.client.ValueEventListener
import rx.Observable
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StorageManager @Inject constructor(val firebase: Firebase) : IStorageManager {

    override fun getDay(day: String): Observable<WeekDay> {
        return Observable.create {
            firebase.child(day).addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(p0: FirebaseError?) {
                    it.onError(Throwable(p0?.message))
                }

                override fun onDataChange(snapshot: DataSnapshot) {
                    Timber.d(snapshot.value.toString())
                    it.onNext(snapshot.getValue(WeekDay::class.java))
                    it.onCompleted()
                }
            })
        }
    }
}
