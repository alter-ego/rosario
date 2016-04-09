package alterego.solutions.rosario.storage

import rx.Observable

interface IStorageManager {

    fun getDay(day: String): Observable<WeekDay>
}
