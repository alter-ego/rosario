package alterego.solutions.rosario.screens.main

import alterego.solutions.rosario.input_button.InputButtonManager
import alterego.solutions.rosario.interfaces.IPresenter
import alterego.solutions.rosario.storage.IStorageManager
import alterego.solutions.rosario.storage.WeekDay
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import timber.log.Timber
import java.util.Date
import java.util.concurrent.TimeUnit

class PresenterMain(val inputButton: InputButtonManager, val storageManager: IStorageManager) : IPresenter {

    lateinit var view: IMainView

    var enuPosition = 0

    var introduzionePosition: Int = 0

    lateinit var weekday: WeekDay

    override fun setup() {
        //        inputButton
        //            .setup()
        //            .concatMap { inputButton.read() }
        //            .distinctUntilChanged()
        //            .filter { it -> it == 1 }
        //            .subscribe(
        //                {
        //                    Timber.d(it.toString())
        //                    view.setIntroduzionePosition(++enuPosition)
        //                },
        //                {
        //                    bioparco(it.message)
        //                })

        val day = android.text.format.DateFormat.format("EEEE", Date());
        getDayData(day as String)

        Observable.interval(10, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ goNext() })
    }


    private fun getDayData(day: String) {
        view.showProgressBar()
        storageManager.getDay(day)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.d(it.toString())
                    weekday = it
                    view.hideProgressBar()
                    view.setIntroduzionePosition(1)
                    introduzionePosition = 1
                    view.setMisteri(weekday.introduzione.steps[0])
                    view.setDecine(1)
                },
                { Timber.e(it.message) })
    }

    fun goNext() {
        if (introduzionePosition < 5) {
            view.setIntroduzionePosition(introduzionePosition)
            view.setMisteri(weekday.introduzione.steps[introduzionePosition])
        }
        introduzionePosition++
    }
}
