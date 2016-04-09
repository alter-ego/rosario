package alterego.solutions.rosario.third

import alterego.solutions.rosario.interfaces.IPresenter

class PresenterThird(val positionEnunciazione : Int, val positionDecine: Int): IPresenter {

    override fun moveEnunciazioneTo(): Int {
        return positionEnunciazione
    }

    override fun moveDecineTo(): Int {
        return positionDecine
    }
}