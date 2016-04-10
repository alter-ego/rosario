package alterego.solutions.rosario.screens.main

import alterego.solutions.rosario.interfaces.IPresenter


class PresenterMain(val positionEnunciazione : Int, val positionDecine: Int) : IPresenter {

    override fun moveEnunciazioneTo(): Int {
        return positionEnunciazione
    }

    override fun moveDecineTo(): Int {
        return positionDecine
    }
}
