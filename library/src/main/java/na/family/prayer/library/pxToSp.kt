package na.family.prayer.library

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

fun Number.pxToSp(context:Context): TextUnit {
    val density = context.resources.displayMetrics.density
    return (this.toFloat() / density).sp
}