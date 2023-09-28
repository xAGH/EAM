package eam.xagh.unilocal.presentation.shared.viewmodels.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import eam.xagh.unilocal.infrastructure.providers.PreferencesProvider
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val preferencesProvider: PreferencesProvider
): ViewModel() {

    var state by mutableStateOf(ThemeState(preferencesProvider.getIsDarkMode()))
        private set

    fun changeTheme() {
        val newTheme = !state.isDarkMode
        preferencesProvider.setTheme(newTheme);
        state = state.copy(
            isDarkMode = newTheme
        )
    }
}