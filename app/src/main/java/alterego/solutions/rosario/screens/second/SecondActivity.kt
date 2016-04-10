package alterego.solutions.rosario.screens.second

import alterego.solutions.rosario.App
import alterego.solutions.rosario.R
import alterego.solutions.rosario.ScanActivity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.triggertrap.seekarc.SeekArc

class SecondActivity : AppCompatActivity() {

    lateinit var mSeekark: SeekArc
    lateinit var mSeekarcprogress: TextView
    lateinit var mSeekark1: SeekArc
    lateinit var mSeekarcprogress1: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        App[this].component().inject(this);

        mSeekarcprogress = findViewById(R.id.seekArcProgress) as TextView
        mSeekarcprogress1 = findViewById(R.id.seekArcProgress1) as TextView

        mSeekark = findViewById(R.id.seekArc) as SeekArc
        mSeekark1 = findViewById(R.id.seekArc1) as SeekArc

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
