package eam.xagh.unilocal.presentation.shared.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import eam.xagh.unilocal.presentation.shared.components.illustration.Illustration

@Composable
private fun IllustrationLayout(
    illustrationName: String,
    hasReturnButton: Boolean = true
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
        ) {
            if (hasReturnButton) {
                Icon(Icons.Filled.KeyboardArrowLeft, "Return button")
            }
            Illustration(illustrationName)
        }

    }
}

@Composable
@Preview
fun Preview() {
    IllustrationLayout(illustrationName = "register_ilustration")
}