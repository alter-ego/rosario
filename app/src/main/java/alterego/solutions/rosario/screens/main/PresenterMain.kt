package alterego.solutions.rosario.screens.main

import alterego.solutions.rosario.input_button.InputButtonManager
import alterego.solutions.rosario.interfaces.IPresenter
import alterego.solutions.rosario.utils.bioparco
import timber.log.Timber

class PresenterMain(val inputButton: InputButtonManager) : IPresenter {

    lateinit var view: IMainView

    var enuPosition = 0

    override fun setup() {
        inputButton
            .setup()
            .concatMap { inputButton.read() }
            .distinctUntilChanged()
            .filter { it -> it == 1 }
            .subscribe(
                {
                    Timber.d(it.toString())
                    view.setEnunciazione(++enuPosition)
                },
                { error -> bioparco(error.message) })
    }
}
