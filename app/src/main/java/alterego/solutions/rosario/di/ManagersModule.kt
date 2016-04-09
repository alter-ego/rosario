package alterego.solutions.rosario.di

import android.content.Context
import dagger.Module
import dagger.Provides
import org.udoo.udooblulib.manager.UdooBluManager
import javax.inject.Singleton

@Module
class ManagersModule() {

    @Provides
    @Singleton
    fun provideUDOObm(context: Context): UdooBluManager {
        return UdooBluManager(context)
    }
}
