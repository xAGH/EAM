package eam.xagh.unilocal.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

class Shape {
    companion object {
        val RoundedSmall = RoundedCornerShape(8.dp)
        val RoundedSmallTop = RoundedCornerShape(8.dp, 8.dp)
        val RoundedSmallBottom = RoundedCornerShape(0.dp, 0.dp, 8.dp, 8.dp)
        val RoundedSmallLeft = RoundedCornerShape(8.dp, 0.dp, 0.dp, 8.dp)
        val RoundedSmallRight = RoundedCornerShape(0.dp, 8.dp, 8.dp, 0.dp)

        val Rounded = RoundedCornerShape(16.dp)
        val RoundedTop = RoundedCornerShape(16.dp, 16.dp)
        val RoundedBottom = RoundedCornerShape(0.dp, 0.dp, 16.dp, 16.dp)
        val RoundedLeft = RoundedCornerShape(16.dp, 0.dp, 0.dp, 16.dp)
        val RoundedRight = RoundedCornerShape(0.dp, 16.dp, 16.dp, 0.dp)

        val RoundedLarge = RoundedCornerShape(24.dp)
        val RoundedLargeTop = RoundedCornerShape(24.dp, 24.dp)
        val RoundedLargeBottom = RoundedCornerShape(0.dp, 0.dp, 24.dp, 24.dp)
        val RoundedLargeLeft = RoundedCornerShape(24.dp, 0.dp, 0.dp, 24.dp)
        val RoundedLargeRight = RoundedCornerShape(0.dp, 24.dp, 24.dp, 0.dp)
    }
}