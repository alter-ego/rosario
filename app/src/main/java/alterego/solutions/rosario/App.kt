package alterego.solutions.rosario

import alterego.solutions.rosario.di.AppComponent
import alterego.solutions.rosario.di.AppModule
import alterego.solutions.rosario.di.DaggerAppComponent
import alterego.solutions.rosario.di.ManagersModule
import android.app.Application
import android.content.Context
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import org.udoo.udooblulib.manager.UdooBluManager
import timber.log.Timber

class App : Application() {

    lateinit var udooBluManager: UdooBluManager
    var appComponent: AppComponent? = null

    lateinit var refWatcher: RefWatcher

    override fun onCreate() {
        super.onCreate()
        refWatcher = LeakCanary.install(this)

        Timber.plant(object : Timber.DebugTree() {
            override fun createStackElementTag(element: StackTraceElement): String {
                return super.createStackElementTag(element) + ":" + element.lineNumber;
            }
        })
        Timber.tag("ROSARIO");

        udooBluManager = UdooBluManager(this);


    }

    fun component(): AppComponent {
        if (appComponent == null) {
            synchronized (App::class.java) {
                if (appComponent == null) {
                    appComponent = createAppComponent()
                }
            }
        }
        return appComponent as AppComponent;
    }

    private fun createAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .managersModule(ManagersModule())
            .build()
    }

    fun refWatcher(): RefWatcher {
        return refWatcher
    }

    companion object {

        operator fun get(context: Context): App {
            return context.applicationContext as App
        }
    }
}
