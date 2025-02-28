package na.family.prayer.library
import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize

/**
 * Text 뒤에 아이콘을 붙이는 컴포저블
 * */
@Composable
fun TextWithImage(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = TextStyle.Default.copy(fontSize = 16.sp),
    content: @Composable (TextUnit) -> Unit,
) {
    val context = LocalContext.current
    val fontSize = style.fontSize

    SubcomposeLayout(modifier = modifier) { constraints ->
        //콘텐츠를 측정
        val contentPlaceable = subcompose("content") {
            content(fontSize)
        }.first().measure(constraints)

        // 콘텐츠 크기를 SP 단위로 변환
        val contentWidthSp = contentPlaceable.width.pxToSp(context)
        val contentHeightSp = contentPlaceable.height.pxToSp(context)

        // 텍스트와 인라인 콘텐츠를 측정
        val textPlaceable = subcompose("text") {
            BasicText(
                text = buildAnnotatedString {
                    append(text)
                    appendInlineContent("infoView", "[icon]")
                },
                style = style,
                inlineContent = mapOf(
                    "infoView" to InlineTextContent(
                        Placeholder(
                            width = contentWidthSp,
                            height = contentHeightSp,
                            placeholderVerticalAlign = PlaceholderVerticalAlign.Center
                        )
                    ) {
                        Box(
                            contentAlignment = Alignment.CenterStart,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            content(fontSize)
                        }
                    }
                )
            )
        }.first().measure(constraints)

        // 레이아웃 배치
        layout(textPlaceable.width, textPlaceable.height) {
            textPlaceable.place(0, 0)
        }
    }
}