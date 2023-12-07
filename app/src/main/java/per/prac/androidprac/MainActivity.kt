package per.prac.androidprac

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import createButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import per.prac.androidprac.db.StudentDatabase
import per.prac.androidprac.db.vo.Student
import per.prac.androidprac.models.network.res.Repository
import per.prac.androidprac.network.ANetworkListener
import per.prac.androidprac.network.NetworkInterface
import per.prac.androidprac.network.NetworkManager
import per.prac.androidprac.ui.theme.AndroidPracTheme
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.random.Random
import kotlin.reflect.KProperty

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

//    val retrofit = Retrofit.Builder()
//        .baseUrl("https://date.nager.at")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build().apply {
//            create(NetworkInterface::class.java)
//        }

//    val service = retrofit.create(NetworkInterface::class.java)

    val client = OkHttpClient.Builder()
        .connectTimeout(5, TimeUnit.SECONDS)
        .readTimeout(5, TimeUnit.SECONDS)
        .writeTimeout(5, TimeUnit.SECONDS)
        .build()

    val service = Retrofit.Builder()
        .client(client)
        .baseUrl("https://date.nager.at")
        .addConverterFactory(GsonConverterFactory.create())
        .build().let {
            it.create(NetworkInterface::class.java)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var list = mutableListOf<String>()
        for (i in 1..100) {
            list.add("NO.$i")
        }

        val db = StudentDatabase.getInstance(applicationContext)

        val manager = NetworkManager()

        setContent {
            Column {
                createButton("Load") {
                    CoroutineScope(Dispatchers.IO).launch {
                        manager.getRepository(
                            owner = "jb0626",
                            repo = "AndroidPrac",
                            callback = object : ANetworkListener<Repository>() {
                                override fun onResponse(res: Repository) {
                                    if (!res.isSuccess) {
                                        return
                                    }

                                    Log.d(
                                        "TAG",
                                        "id : ${res.id} name : ${res.name} fullname: ${res.fullName} url : ${res.htmlUrl} private : ${res.private}"
                                    )
                                }
                            }
                        )
                    }
                }
                createButton("Save") {
                    CoroutineScope(Dispatchers.IO).launch {
                        db.studentDao.insertStudent(
                            Student(
                                1, "Jay", 100
                            )
                        )
                    }
                }
                createButton("Show") {
                    CoroutineScope(Dispatchers.IO).launch {
                        db.studentDao.getAll().stream()
                            .forEach {
                                Log.d("TAG", "NO : ${it.no} NAME : ${it.name} SCORE : ${it.score}")
                            }
                    }
                }
                createButton("Clear") {
                    CoroutineScope(Dispatchers.IO).launch {
                        db.studentDao.clear()
                    }
                }
            }
        }

//        setContent {
//            AndroidPracTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
////                    Greeting("Android")
////                    BackgroundButton("HI")
////                    BackgroundButton("HI 2")
////                    Buttons().ElevatedButton()
//
////                    Column {
////                        RadioButton()
////                        CheckBox()
////                    }
//
////                    Test()
//
////                    LzVertGrid(lists = list)
//                    ScrollBoxes(count = 100)
//                }
//            }
//        }
    }
}

fun ShowDialog(
    title: String,
    msg: String,
    canCancel: Boolean = true,
    posiBtnTxt: String = "확인",
    negaBtnTxt: String = "",
    neutBtnTxt: String = ""
) {
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

class DelegatedPropTest {
    var uid: String by ManageUid()
}

class ManageUid {
    var userId: String = ""
    operator fun getValue(
        delegatedPropTest: DelegatedPropTest,
        property: KProperty<*>
    ): String {
        userId = "UID${Random(10000).nextInt()}"
        return userId
    }

    operator fun setValue(
        delegatedPropTest: DelegatedPropTest,
        property: KProperty<*>,
        s: String
    ) {
        userId = s
        println(userId)
    }
}