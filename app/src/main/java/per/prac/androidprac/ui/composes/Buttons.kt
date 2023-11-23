package per.prac.androidprac.ui.composes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
    val isChecked = remember {
        mutableStateOf(false)
    }
    Row(modifier = Modifier
        .clickable {
            isChecked.value = !isChecked.value
        }
        .background(Color.Transparent)) {
        Checkbox(checked = isChecked.value, onCheckedChange = {
            isChecked.value = it
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

@Composable
@Preview(showBackground = true)
fun Test() {
    BoxWithConstraints {
        Text("My minHeight is $minHeight while my max Width is $maxWidth")
    }
}