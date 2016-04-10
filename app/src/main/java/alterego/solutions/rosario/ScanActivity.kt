package alterego.solutions.rosario

import alterego.solutions.rosario.screens.scan.IScanView
import alterego.solutions.rosario.screens.scan.ScanPresenter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View.GONE
import android.view.View.VISIBLE
import kotlinx.android.synthetic.main.activity_scan.deviceAddess
import kotlinx.android.synthetic.main.activity_scan.scanButton
import kotlinx.android.synthetic.main.activity_scan.scanProgressbar
import javax.inject.Inject

class ScanActivity : AppCompatActivity(), IScanView {

    @Inject
    lateinit var presenter: ScanPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App[this].component().inject(this);
        setContentView(R.layout.activity_scan)

        presenter.view = this

        scanButton.setOnClickListener({
            presenter.startScan();
        })
    }

    override fun startProgress() {
        scanProgressbar.visibility = VISIBLE
    }

    override fun stopProgress() {
        scanProgressbar.visibility = GONE
    }

    override fun showScanButton() {
        scanButton.visibility = VISIBLE
    }

    override fun hideScanButton() {
        scanButton.visibility = GONE
    }

    override fun setAddress(address: String) {
        deviceAddess.text = address
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dispose()
    }
}
