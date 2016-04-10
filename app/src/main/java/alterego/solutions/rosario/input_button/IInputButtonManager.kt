package alterego.solutions.rosario.input_button

import rx.Observable

interface IInputButtonManager {
    fun connect(): Observable<Boolean>
    fun read(): Observable<Int>
    open fun setup(): Observable<Boolean>
}
