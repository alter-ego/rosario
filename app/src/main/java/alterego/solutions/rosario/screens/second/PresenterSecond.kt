package alterego.solutions.rosario.screens.second

import alterego.solutions.rosario.interfaces.IPresenter


class PresenterSecond(val positionEnunciazione : Int, val positionDecine: Int) : IPresenter {

    override fun moveEnunciazioneTo(): Int {
        return positionEnunciazione
    }

    override fun moveDecineTo(): Int {
        return positionDecine
    }
}
