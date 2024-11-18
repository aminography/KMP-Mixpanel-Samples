package dk.yousee.kmp.mixpanel_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dk.yousee.kmp.di.KoinHelper
import dk.yousee.kmp.mixpanel.MixpanelDelegate
import dk.yousee.kmp.mixpanel.di.MIXPANEL_DELEGATE
import dk.yousee.kmp.mixpanel.di.MixpanelModule
import dk.yousee.kmp.mixpanel_android.ui.theme.MixpanelAndroidTheme
import org.koin.android.ext.koin.androidContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        KoinHelper.start {
            androidContext(application)
        }

        MixpanelModule.load()
        val mixpanel: MixpanelDelegate = MIXPANEL_DELEGATE.resolve()

        mixpanel.track("Test event!")

        enableEdgeToEdge()
        setContent {
            MixpanelAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MixpanelAndroidTheme {
        Greeting("Android")
    }
}