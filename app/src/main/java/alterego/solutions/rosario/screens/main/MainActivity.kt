package alterego.solutions.rosario.screens.main

import alterego.solutions.rosario.App
import alterego.solutions.rosario.R
import alterego.solutions.rosario.ScanActivity
import alterego.solutions.rosario.input_button.IInputButtonManager
import alterego.solutions.rosario.utils.bioparco
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.triggertrap.seekarc.SeekArc
import kotlinx.android.synthetic.main.activity_main.seekArc
import kotlinx.android.synthetic.main.activity_main.seekArc1
import kotlinx.android.synthetic.main.activity_main.seekArcProgress
import kotlinx.android.synthetic.main.activity_main.seekArcProgress1
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var inputButton: IInputButtonManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App[this].component().inject(this);
        setContentView(R.layout.activity_main)

        inputButton
            .setup()
            .concatMap { inputButton.read() }
            .distinctUntilChanged()
            .subscribe(
                {
                    Timber.d(it.toString())
                },
                { error -> bioparco(error.message) })

        //TODO Check if presenter value Enunciazione value is <=5
        val mainPresenter = PresenterMain(1, 1)

        seekArcProgress.text = mainPresenter.positionEnunciazione.toString()
        seekArc.progress = mainPresenter.positionEnunciazione

        seekArcProgress1.text = mainPresenter.positionDecine.toString()
        seekArc1.progress = mainPresenter.positionDecine

        seekArc.setOnSeekArcChangeListener(object : SeekArc.OnSeekArcChangeListener {

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
}
