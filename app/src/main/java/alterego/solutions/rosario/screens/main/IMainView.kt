package alterego.solutions.rosario.screens.main

interface IMainView {

    fun setIntroduzionePosition(position: Int)

    fun setDecine(position: Int)

    fun setIntroduzioneText(introduzione: String)

    fun setMisteri(misteri: String)

    fun showProgressBar()

    fun hideProgressBar()
}
