package alterego.solutions.rosario.di

import alterego.solutions.rosario.screens.main.MainActivity
import alterego.solutions.rosario.ScanActivity
import alterego.solutions.rosario.screens.second.SecondActivity
import alterego.solutions.rosario.screens.third.ThirdActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, ManagersModule::class))
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(scanActivity: ScanActivity)

    fun inject(secondActivity: SecondActivity)

    fun inject(thirdActivity: ThirdActivity)
}
