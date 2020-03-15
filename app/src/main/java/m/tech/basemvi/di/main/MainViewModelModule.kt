package m.tech.basemvi.di.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import m.tech.basemvi.viewmodels.MainViewModel
import m.tech.basemvi.viewmodels.MainViewModelProviderFactory

@Module
abstract class MainViewModelModule {

    @MainScope
    @Binds
    abstract fun provideViewModelFactory(factory: MainViewModelProviderFactory): ViewModelProvider.Factory

    @MainScope
    @Binds
    @IntoMap
    @MainViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

}