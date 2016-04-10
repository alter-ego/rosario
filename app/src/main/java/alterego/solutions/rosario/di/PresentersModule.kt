package alterego.solutions.rosario.di

import alterego.solutions.rosario.input_button.InputButtonManager
import alterego.solutions.rosario.screens.main.PresenterMain
import alterego.solutions.rosario.screens.scan.ScanPresenter
import alterego.solutions.rosario.storage.IStorageManager
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

    @Provides
    @Singleton
    fun provideMainPresenter(inputButton: InputButtonManager, storageManager: IStorageManager): PresenterMain {
        return PresenterMain(inputButton, storageManager)
    }
}
