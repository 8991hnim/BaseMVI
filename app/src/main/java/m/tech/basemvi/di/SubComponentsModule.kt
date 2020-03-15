package m.tech.basemvi.di

import dagger.Module
import m.tech.basemvi.di.main.MainComponent

@Module(
    subcomponents = [
        MainComponent::class
    ]
)
class SubComponentsModule