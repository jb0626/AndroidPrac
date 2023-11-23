package per.prac.androidprac

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import per.prac.androidprac.ui.composes.Test
import per.prac.androidprac.ui.theme.AndroidPracTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidPracTheme {
                // A surface container using the 'background' color from the theme
                Surface(
//                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
//                    BackgroundButton("HI")
//                    BackgroundButton("HI 2")
//                    Buttons().ElevatedButton()
//                    Column {
//                        OutsideRadioButton()
//                        OutsideCheckBox()
//                    }
                    Test()
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

//@Preview(showSystemUi = true, widthDp = 100, heightDp = 100, device = Devices.WEAR_OS_LARGE_ROUND)
@Composable
fun A() {
    Button(
        onClick = {
            Log.d("TAG", "Coroutine test click")
            CoroutineScope(Dispatchers.IO).launch {
                Thread.sleep(1000 * 2)
                Log.d("TAG", "Coroutine test")
            }
        }
    ) {
        Text(text = "HI")
    }
}

@Composable
fun BackgroundButton(str: String) {
    Button(
        onClick = {
            Log.d("TAG", "Coroutine test click")
            CoroutineScope(Dispatchers.IO).launch {
                Thread.sleep(1000 * 2)
                Log.d("TAG", "Coroutine test")
            }
        }
    ) {
        Text(text = str)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidPracTheme {
        Greeting("Android")
    }
}