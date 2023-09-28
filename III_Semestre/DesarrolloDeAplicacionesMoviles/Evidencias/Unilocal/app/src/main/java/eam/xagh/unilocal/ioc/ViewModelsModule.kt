package eam.xagh.unilocal.ioc

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eam.xagh.unilocal.presentation.shared.components.illustration.IllustrationViewModel
import eam.xagh.unilocal.presentation.shared.viewmodels.theme.ThemeViewModel
import eam.xagh.unilocal.infrastructure.providers.PreferencesProvider
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ViewModelsModule {
    @Provides
    @Singleton
    fun provideThemeViewModel(preferencesProvider: PreferencesProvider): ThemeViewModel {
        return ThemeViewModel(preferencesProvider)
    }

    @Provides
    @Singleton
    fun provideIllustrationViewModel(
        themeViewModel: ThemeViewModel,
        application: Application
    ): IllustrationViewModel {
        return IllustrationViewModel(themeViewModel, application)
    }
}