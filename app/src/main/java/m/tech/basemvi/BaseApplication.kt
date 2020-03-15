package m.tech.basemvi

import android.app.Application
import android.util.Log
import m.tech.basemvi.di.AppComponent
import m.tech.basemvi.di.DaggerAppComponent
import m.tech.basemvi.di.main.MainComponent


class BaseApplication : Application() {

    private lateinit var appComponent: AppComponent

    private var mainComponent: MainComponent? = null

    override fun onCreate() {
        super.onCreate()
        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    fun mainComponent(): MainComponent {
        if (mainComponent == null) {
            mainComponent = appComponent.mainComponent().create()
        }
        return mainComponent as MainComponent
    }

    fun releaseMainComponent() {
        mainComponent = null
    }

}