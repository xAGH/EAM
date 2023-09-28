package eam.xagh.unilocal.presentation.shared.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eam.xagh.unilocal.presentation.shared.components.illustration.Illustration
import eam.xagh.unilocal.presentation.theme.Shape

@Composable
fun IllustrationLayout(
    illustrationName: String,
    hasReturnButton: Boolean = true,
    content: @Composable () -> Unit
) {
    Column(
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
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "Return button",
                    modifier = Modifier
                        .size(54.dp),
                    tint = MaterialTheme.colorScheme.primary
                    )
            }
            Illustration(illustrationName)
        }
        Column(modifier = Modifier
            .fillMaxSize()
            .clip(Shape.RoundedLargeTop)
            .background(MaterialTheme.colorScheme.secondary)
        ) {
            content()
        }
    }
}