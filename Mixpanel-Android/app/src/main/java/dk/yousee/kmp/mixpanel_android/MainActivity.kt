package dk.yousee.kmp.mixpanel_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dk.yousee.kmp.BuildProperties
import dk.yousee.kmp.di.KoinHelper
import dk.yousee.kmp.mixpanel.MixpanelDelegate
import dk.yousee.kmp.mixpanel.di.MIXPANEL_DELEGATE
import dk.yousee.kmp.mixpanel.di.MixpanelModule
import dk.yousee.kmp.mixpanel.event.LoginEvent
import dk.yousee.kmp.mixpanel_android.ui.theme.MixpanelAndroidTheme
import org.koin.android.ext.koin.androidContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        KoinHelper.start {
            androidContext(application)
        }

        val mixpanel: MixpanelDelegate = MIXPANEL_DELEGATE.resolve()
        mixpanel.init(BuildProperties.MIXPANEL_API_TOKEN_TEST)

        println("XXXXXXXXXXXXXXXXXXX  Lib Version: ${BuildProperties.VERSION}")

        enableEdgeToEdge()
        setContent {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                        mixpanel.track(
                            LoginEvent(
                                LoginEvent.AuthProvider.Ping,
                                "FROM ANDROID!"
                            )
                        )
                    },
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White,
                        text = "Event",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}
