package m.tech.basemvi.di.main

import dagger.Subcomponent
import m.tech.basemvi.MainActivity
import m.tech.basemvi.TestFragment

@MainScope
@Subcomponent(
    modules = [
        MainModule::class,
        MainViewModelModule::class
    ]
)
interface MainComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

    fun inject(mainActivity: MainActivity)

    fun inject(testFragment: TestFragment)
}