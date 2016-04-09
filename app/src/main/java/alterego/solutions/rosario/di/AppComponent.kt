package alterego.solutions.rosario.di

import alterego.solutions.rosario.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, ManagersModule::class))
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}
