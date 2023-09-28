package eam.xagh.unilocal.shared.domain.services

interface PreferenceService {
    fun getIsDarkMode(): Boolean
    fun setTheme(toDarkTheme: Boolean): Unit
}