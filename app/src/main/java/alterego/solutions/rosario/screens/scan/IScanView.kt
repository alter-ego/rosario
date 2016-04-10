package alterego.solutions.rosario.screens.scan

interface IScanView {

    fun startProgress()
    fun stopProgress()
    fun showScanButton()
    fun hideScanButton()
    fun setAddress(address: String)
}
