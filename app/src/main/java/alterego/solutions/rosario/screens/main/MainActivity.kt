package alterego.solutions.rosario.screens.main

import alterego.solutions.rosario.App
import alterego.solutions.rosario.R
import alterego.solutions.rosario.ScanActivity
import alterego.solutions.rosario.input_button.IInputButtonManager
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.triggertrap.seekarc.SeekArc
import kotlinx.android.synthetic.main.activity_main.decineMainSeek
import kotlinx.android.synthetic.main.activity_main.decineMainText
import kotlinx.android.synthetic.main.activity_main.enunciazioneMain
import kotlinx.android.synthetic.main.activity_main.enunciazioneMainSeek
import kotlinx.android.synthetic.main.activity_main.enunciazioneMainText
import kotlinx.android.synthetic.main.activity_main.introduzioneMain
import kotlinx.android.synthetic.main.activity_main.progressBarMain
import javax.inject.Inject

class MainActivity : AppCompatActivity(), IMainView {

    @Inject
    lateinit var inputButton: IInputButtonManager

    @Inject
    lateinit var mainPresenter: PresenterMain

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App[this].component().inject(this);
        setContentView(R.layout.activity_main)

        mainPresenter.view = this
        mainPresenter.setup()

        enunciazioneMainSeek.setOnSeekArcChangeListener(object : SeekArc.OnSeekArcChangeListener {

            override fun onProgressChanged(p0: SeekArc?, p1: Int, p2: Boolean) {
                //TODO add some reaction in case of modify from android app
            }

            override fun onStartTrackingTouch(p0: SeekArc?) {

            }

            override fun onStopTrackingTouch(p0: SeekArc?) {
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater;
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings ->
                startActivity(Intent(this, ScanActivity::class.java))
        }
        return true;
    }

    override fun setDecine(position: Int) {
        decineMainText.text = position.toString()
        decineMainSeek.progress = position
    }

    override fun setIntroduzionePosition(position: Int) {
        enunciazioneMainText.text = position.toString()
        enunciazioneMainSeek.progress = position
    }

    override fun setIntroduzioneText(introduzione: String) {
        introduzioneMain.text = introduzione
    }

    override fun setMisteri(misteri: String) {
        enunciazioneMain.text = misteri
    }
    override fun hideProgressBar() {
        progressBarMain.visibility = View.GONE
    }

    override fun showProgressBar() {
        progressBarMain.visibility = View.VISIBLE
    }
}
