package m.tech.basemvi.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import m.tech.basemvi.BaseActivity
import m.tech.basemvi.di.main.MainComponent
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        SubComponentsModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

    fun inject(baseActivity: BaseActivity)

    fun mainComponent(): MainComponent.Factory
}