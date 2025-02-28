package na.family.prayer.textwithimage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import na.family.prayer.library.TextWithImage
import na.family.prayer.textwithimage.ui.theme.TextWithImageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TextWithImageTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting( modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        TextWithImage(
            text = "텍스트 뒤에붙습니다. ",
        ){ fontSize ->
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "icon",
                modifier = Modifier.size(fontSize.value.dp).background(MaterialTheme.colorScheme.primary)
            )
        }

        TextWithImage(
            text = "이미지를 붙이기 위해 만들었지만 그 외에 다른 컴포저블도 사용 가능합니다. ",
        ){
            Text(
                "subText",
                modifier = Modifier,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TextWithImageTheme {
        Greeting()
    }
}