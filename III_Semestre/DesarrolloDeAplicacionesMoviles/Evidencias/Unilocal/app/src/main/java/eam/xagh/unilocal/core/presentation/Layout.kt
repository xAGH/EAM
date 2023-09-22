import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import eam.xagh.unilocal.R

@Composable
private fun LayoutHeader(
    // properties: LayoutHeaderProperties
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
        ) {
       //     Ilustration(ilustration = ilustration)
        }
    }

}

@Composable
fun a() {
    val s = ImageVector.vectorResource(id = R.drawable.register_ilustration_dark)
    //LayoutHeader(height = 0.3f, hasReturnButton = true ,ilustration = s)
}

@Composable
fun IlustrationLayout() {

}