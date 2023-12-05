import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import per.prac.androidprac.R

@Composable
fun createConstraintBox() {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        // 0, 838.0952, 0, 920.7619 (dp)
//        Text(text = "Min width $minWidth Max width $maxWidth Min height $minHeight Max height $maxHeight")
        // 0, 2200, 0, 2417 (pixel)
//        Text(text = "Constraints? $constraints")
    }
}

@Composable
//@Preview(showBackground = true, showSystemUi = true)
fun rowLayout() {
    Row {
        Row(modifier = Modifier.align(Alignment.CenterVertically)) {
            Text(
                text = "Hello there"
            )
            Text(
                text = "How are you",
                modifier = Modifier.padding(start = 4.dp, end = 4.dp)
            )
            Text(
                text = "Bye there"
            )
        }
    }
}

@Composable
//@Preview(showBackground = true, showSystemUi = true)
fun colLayout() {
    Column {
        // CenterHorizontally를 사용하기 때문에 ColumnScope 안에서 선언해야 한다.
        val mod = Modifier.align(Alignment.CenterHorizontally)

        Text(text = "Hello there", modifier = mod)
        Text(text = "How r u", modifier = mod)
        Text(text = "Bye there", modifier = mod)
    }
}

@Composable
//@Preview(showBackground = true, showSystemUi = true)
fun rcLayout() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .fillMaxWidth()
        ) {
            Text(text = "Hello there", modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = "How r u", modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = "Bye there", modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }
}

@Composable
//@Preview(showBackground = true, showSystemUi = true)
fun cocLayout() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Hello there")
        Text(text = "How r u")
        Text(text = "Bye there")
    }
} // Center of Center

@Composable
//@Preview(showSystemUi = true, showBackground = true)
fun bubbleChatLayout() {
    Row {
        Box {
            Image(
                painter = painterResource(id = R.drawable.baseline_chat_bubble_24),
                contentDescription = "Chat Bubble"
            )
            Box(
                modifier = Modifier
                    .background(color = Color.Red, shape = CircleShape)
                    .width(30.dp)
                    .height(30.dp)
                    .align(Alignment.TopEnd)
            ) {
                Text(
                    text = "7",
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun boxLayout() {
    Box(modifier = Modifier.background(color = Color.Gray)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Android Image"
        )
        Icon(
            Icons.Filled.Search,
            contentDescription = "Icon",
            modifier = Modifier.padding(vertical = 46.dp, horizontal = 55.dp)
        )
    }
}

@Composable
fun createButton(str: String) {
    Button(onClick = { /*TODO*/ }) {
        Text(text = str)
    }
}