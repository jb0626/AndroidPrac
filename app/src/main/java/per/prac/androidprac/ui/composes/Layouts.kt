import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
@Preview(showBackground = true, showSystemUi = true)
fun cocLayout() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "HI")
    }
} // Center of Center

@Composable
fun createButton(str: String) {
    Button(onClick = { /*TODO*/ }) {
        Text(text = str)
    }
}