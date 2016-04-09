package alterego.solutions.rosario.main

import alterego.solutions.rosario.interfaces.IPresenter


class PresenterMain(val positionEnunciazione : Int, val positionDecine: Int) : IPresenter {

    override fun moveEnunciazioneTo(): Int {
        return positionEnunciazione
    }

    override fun moveDecineTo(): Int {
        return positionDecine
    }
}