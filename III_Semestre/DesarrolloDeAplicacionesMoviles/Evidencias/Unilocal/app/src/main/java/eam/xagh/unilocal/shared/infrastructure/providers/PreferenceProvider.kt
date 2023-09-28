package eam.xagh.unilocal.shared.infrastructure.providers

import android.content.Context
import android.content.SharedPreferences
import eam.xagh.unilocal.shared.domain.services.PreferenceService
import javax.inject.Inject

class PreferencesProvider constructor (private val context: Context) : PreferenceService {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("ApplicationPreferernces", Context.MODE_PRIVATE)

    private val darkThemeKey = "IS_DARK_THEME"

    override fun setTheme(toDarkTheme: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean("IS_DARK_THEME", toDarkTheme)
        editor.apply()
    }

    override fun getIsDarkMode(): Boolean {
        return sharedPreferences.getBoolean(darkThemeKey, false)
    }
}