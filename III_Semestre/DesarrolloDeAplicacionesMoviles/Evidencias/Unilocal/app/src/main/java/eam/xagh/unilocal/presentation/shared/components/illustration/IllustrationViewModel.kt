package eam.xagh.unilocal.presentation.shared.components.illustration

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import eam.xagh.unilocal.ThemeViewModel
import javax.inject.Inject

@HiltViewModel
class IllustrationViewModel @Inject constructor(
    private val themeViewModel: ThemeViewModel,
    private val application: Application
) : ViewModel() {

    var state by mutableStateOf(IllustrationState())
        private set

    @SuppressLint("DiscouragedApi")
    fun getIllustrationIdWithTheme(illustrationName: String): Int {
        val name = illustrationName + (if(themeViewModel.state.isDarkMode) "_dark" else "_light")
        val illustrationId = application.resources.getIdentifier(name, "drawable", application.packageName)
        Log.w("Obteniendo imagen", name)
        state = state.copy(illustrationId = illustrationId)
        return illustrationId
    }
}