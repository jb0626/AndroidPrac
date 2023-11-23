package per.prac.androidprac.ui.composes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LzVertGrid(lists: List<String>) {
    LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 120.dp)) {
        items(lists) {
            Column(
                modifier = Modifier
                    .height(100.dp)
            ) {
                Text(
                    text = it,
                    modifier = Modifier
                        .align(CenterHorizontally)
                        .border(BorderStroke(width = 1.dp, color = Color.Black)),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun ScrollBoxes(count: Int) {
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }

    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .size(100.dp)
            .padding(horizontal = 8.dp)
            .verticalScroll(state)
    ) {
        repeat(count) {
            Text(text = "No. $it", modifier = Modifier.padding(4.dp))
        }
    }
}