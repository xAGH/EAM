package eam.xagh.unilocal.domain.services

interface PreferenceService {
    fun getIsDarkMode(): Boolean
    fun setTheme(toDarkTheme: Boolean)
}