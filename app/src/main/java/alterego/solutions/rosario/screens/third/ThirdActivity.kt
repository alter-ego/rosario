package alterego.solutions.rosario.screens.third

import alterego.solutions.rosario.App
import alterego.solutions.rosario.R
import alterego.solutions.rosario.ScanActivity
import alterego.solutions.rosario.screens.main.PresenterMain
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import com.triggertrap.seekarc.SeekArc

class ThirdActivity : AppCompatActivity() {

    lateinit var mSeekark: SeekArc
    lateinit var mSeekarcprogress: TextView
    lateinit var mSeekark1: SeekArc
    lateinit var mSeekarcprogress1: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        App[this].component().inject(this);

        mSeekarcprogress = findViewById(R.id.seekArcProgress) as TextView
        mSeekarcprogress1 = findViewById(R.id.seekArcProgress1) as TextView

        mSeekark = findViewById(R.id.seekArc) as SeekArc
        mSeekark1 = findViewById(R.id.seekArc1) as SeekArc

        //TODO Check if presenter value Enunciazione value is <=1
        val thirdPresenter = PresenterThird(3, 3)

        mSeekarcprogress.setText(thirdPresenter.positionEnunciazione.toString())
        mSeekark.progress = thirdPresenter.positionEnunciazione


        mSeekarcprogress1.setText(thirdPresenter.positionDecine.toString())
        mSeekark1.progress = thirdPresenter.positionDecine

        mSeekark.setOnSeekArcChangeListener(object : SeekArc.OnSeekArcChangeListener {

            override fun onProgressChanged(p0: SeekArc?, p1: Int, p2: Boolean) {
                //TODO add some reaction in case of modify from android app
            }

            override fun onStartTrackingTouch(p0: SeekArc?) {
                //mSeekarcprogress.setText(p0.toString())
            }

            override fun onStopTrackingTouch(p0: SeekArc?) {
                //mSeekarcprogress.setText(p0.toString())
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
