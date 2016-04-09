package alterego.solutions.rosario

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.triggertrap.seekarc.SeekArc

class MainActivity : AppCompatActivity() {

    lateinit var mSeekark: SeekArc
    lateinit var mSeekarcprogress: TextView
    lateinit var mSeekark1: SeekArc
    lateinit var mSeekarcprogress1: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App[this].component().inject(this);
        setContentView(R.layout.activity_main)

        mSeekarcprogress = findViewById(R.id.seekArcProgress) as TextView
        mSeekarcprogress1 = findViewById(R.id.seekArcProgress1) as TextView

        mSeekark = findViewById(R.id.seekArc) as SeekArc
        mSeekark1 = findViewById(R.id.seekArc1) as SeekArc

        mSeekark.setOnSeekArcChangeListener(object : SeekArc.OnSeekArcChangeListener {

            override fun onProgressChanged(p0: SeekArc?, p1: Int, p2: Boolean) {
                mSeekarcprogress.setText(p1.toString())
                mSeekark1.progress = p1
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
