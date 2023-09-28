package eam.xagh.unilocal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import dagger.hilt.android.AndroidEntryPoint
import eam.xagh.unilocal.presentation.shared.components.input.Input
import eam.xagh.unilocal.presentation.shared.components.input.InputTypes
import eam.xagh.unilocal.presentation.shared.viewmodels.theme.ThemeViewModel
import eam.xagh.unilocal.presentation.theme.AppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val themeViewModel: ThemeViewModel by viewModels()
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme(themeViewModel.state.isDarkMode) {
                Input(
                    type = InputTypes.TEXT,
                    label = "Nombre",
                    placeholder = "Jhon Doe",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Check,
                            "",
                            tint = MaterialTheme.colorScheme.tertiary
                        )
                    }
                ) {}
            }
        }
    }
}