package eam.xagh.unilocal

import android.app.Application
import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eam.xagh.unilocal.presentation.shared.components.illustration.IllustrationViewModel
import eam.xagh.unilocal.shared.infrastructure.providers.PreferencesProvider
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UnilocalModule {
    @Provides
    @Singleton
    fun providePreferenceProvider(application: Application): PreferencesProvider {
        return PreferencesProvider(application)
    }

    @Provides
    @Singleton
    fun provideThemeViewModel(preferencesProvider: PreferencesProvider): ThemeViewModel {
        return ThemeViewModel(preferencesProvider)
    }

    @Provides
    @Singleton
    fun provideIllustrationViewModel(themeViewModel: ThemeViewModel, application: Application): IllustrationViewModel {
        return IllustrationViewModel(themeViewModel, application)
    }
}