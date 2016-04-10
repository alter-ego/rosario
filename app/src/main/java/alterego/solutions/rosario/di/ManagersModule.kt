package alterego.solutions.rosario.di

import alterego.solutions.rosario.input_button.IInputButtonManager
import alterego.solutions.rosario.storage.IStorageManager
import alterego.solutions.rosario.storage.StorageManager
import android.content.Context
import com.firebase.client.Firebase
import dagger.Module
import dagger.Provides
import org.udoo.udooblulib.manager.UdooBluManager
import rx.Observable
import javax.inject.Singleton

@Module
class ManagersModule() {

    @Provides
    @Singleton
    fun provideUDOObm(context: Context): UdooBluManager {
        return UdooBluManager(context)
    }

    @Provides
    @Singleton
    fun provideFirebase(): Firebase {
        return Firebase("https://rosario.firebaseio.com/WeekDays")
    }

    @Provides
    @Singleton
    fun provideStorageManager(firebase: Firebase): IStorageManager {
        return StorageManager(firebase)
    }

    @Provides
    @Singleton
    fun providesInputButtonManager(udooBluManager: UdooBluManager): IInputButtonManager {
        return object : IInputButtonManager {
            override fun connect(): Observable<Boolean> {
                return Observable.fromCallable { true }
            }

            override fun read(): Observable<Int> {
                
            }
        }
    }
}
