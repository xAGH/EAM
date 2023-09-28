package eam.xagh.unilocal.ioc
import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eam.xagh.unilocal.infrastructure.providers.PreferencesProvider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProvidersModule {
    @Provides
    @Singleton
    fun providePreferenceProvider(application: Application): PreferencesProvider {
        return PreferencesProvider(application)
    }
}