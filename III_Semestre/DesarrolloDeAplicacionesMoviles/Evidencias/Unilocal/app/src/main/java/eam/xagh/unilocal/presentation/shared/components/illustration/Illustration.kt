package eam.xagh.unilocal.presentation.shared.components.illustration

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun Illustration(
    illustrationName: String,
) {
    val viewModel: IllustrationViewModel = hiltViewModel();
    val id = viewModel.getIllustrationIdWithTheme(illustrationName)
    Image(
        painter = painterResource(id = id),
        contentDescription = null,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    )
}