package per.prac.androidprac.ui.composes

import android.util.Log
import android.widget.Toast
import android.widget.Toast.Callback
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import per.prac.androidprac.DelegatedPropTest
import per.prac.androidprac.R
import kotlin.random.Random

@Preview(showBackground = true)
@Composable
fun RadioButton() {
    Row {
        RadioButton(selected = true, onClick = { /*TODO*/ })
        Text(text = "Agree")
    }
}

@Preview(showBackground = true)
@Composable
fun CheckBox() {
//    var isChecked by remember { mutableStateOf(false) }
    var isChecked by remember { mutableStateOf(false) }

    val jay = Student("JayChoi", 100, "M")
    val (name, score, gender) = jay
    Row(modifier = Modifier
        .pointerInput(Unit) {
            detectTapGestures {
                isChecked = !isChecked
            }
        }
    ) {
        Checkbox(checked = isChecked, onCheckedChange = {
            println("Name : $name")
            println(gender)
        })
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "Check me",
            modifier = Modifier.align(CenterVertically),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}

data class Student(val name: String, val score: Int, val gender: String)

@Composable
@Preview(showBackground = true)
fun Test() {
    BoxWithConstraints {
        Text("My minHeight is $minHeight while my max Width is $maxWidth")
    }
}

@Composable
@ExperimentalMaterial3Api
@Preview(showBackground = true)
fun Btn() {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember {
        SnackbarHostState()
    }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {
            Button(onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar("Snacks")
                }
            }) {
                Text(text = "Click!")
            }
        }
    }
}

fun TestFromBTN() {

}

@Composable
@Preview(showBackground = true)
fun Btn2() {
    val context = LocalContext.current
    val t = Toast.makeText(context, "Toast", Toast.LENGTH_SHORT)
    val isShow = remember { mutableStateOf(true) }
    Button(
        onClick = {
            if (isShow.value) {
                t.addCallback(object : Callback() {
                    override fun onToastShown() {
                        super.onToastShown()
                    }

                    override fun onToastHidden() {
                        super.onToastHidden()
                        isShow.value = true
                    }
                })
                t.show()
                isShow.value = false
            }
        }) {
        Text(text = "Click!!")
    }

}

@Composable
@Preview(showBackground = true)
fun Btn3() {
    val d = DelegatedPropTest()
    Row(content = {
        Button(
            onClick = buttonFunction(1)
        ) {
        }
        Button(
            onClick = {
                println(d.uid)
            }
        ) {
            Text(text = "Get UID")
        }
        Button(
            onClick = {
                var newUid = "UID${Random(10).nextInt()}"
                println("In Button ${newUid}")
                d.uid = newUid
            }
        ) {
            Text(text = "Set UID")
        }
    })
}

fun buttonFunction(num: Int): () -> Unit {
    return { Log.d("TAG", "High-order Func $num") }
}

@Composable
@Preview(showBackground = true)
fun CreateButton() {
    Box {
//        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "Android Image")
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "Android Image")
        Icon(Icons.Filled.Check, contentDescription = "Check mark", modifier = Modifier.align(Center))
    }
}