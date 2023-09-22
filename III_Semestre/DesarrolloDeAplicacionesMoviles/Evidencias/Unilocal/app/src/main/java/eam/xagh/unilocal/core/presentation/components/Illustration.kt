package eam.xagh.unilocal.core.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@SuppressLint("DiscouragedApi")
@Composable
fun Illustration(
    illustrationName: String,
) {
    val name = if (isSystemInDarkTheme()) "_dark" else "_light"
    val context = LocalContext.current
    val id by remember(name) {
        derivedStateOf {
            context.resources.getIdentifier(name, "drawable", context.packageName)
        }
    }
    return id;
    val illustrationId =
    Image(
        painter = painterResource(id = illustrationId),
        contentDescription = null,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    )
}

@Composable
@Preview
fun preview() {
    var name = "register_ilustration"
    name += if (isSystemInDarkTheme()) "_dark" else "_light"
    val context = LocalContext.current
    val d by remember(name) {
        derivedStateOf {
            context.resources.getIdentifier(name, "drawable", context.packageName)
        }
    }
    Illustration(name)
}