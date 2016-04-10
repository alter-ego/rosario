package alterego.solutions.rosario.di

import alterego.solutions.rosario.screens.scan.ScanPresenter
import dagger.Module
import dagger.Provides
import org.udoo.udooblulib.manager.UdooBluManager
import javax.inject.Singleton

@Module
class PresentersModule {

    @Provides
    @Singleton
    fun provideScanPresenter(udooBluManager: UdooBluManager): ScanPresenter {
        return ScanPresenter(udooBluManager)
    }
}
