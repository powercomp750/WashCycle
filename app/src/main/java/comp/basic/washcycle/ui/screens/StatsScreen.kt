package comp.basic.washcycle.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import comp.basic.washcycle.viewmodel.LaundrySessionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatsScreen(viewModel: LaundrySessionViewModel) {
    // Use the correct StateFlow from your ViewModel
    //val historyItems: List<LaundryItem> by viewModel

    val totalCount = 0
    val doneCount = 0
    val pendingCount = 0

    Scaffold(topBar = { TopAppBar(title = { Text("Stats") }) }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            if (totalCount == 0) {
                Text("No data yet")
            } else {
                Text("Total items: $totalCount")
                Spacer(Modifier.height(8.dp))

                Text("Done: $doneCount")
                Box(
                    modifier = Modifier
                        .fillMaxWidth(doneCount.toFloat() / totalCount)
                        .height(16.dp)
                        .background(Color(0xFF3DDC84))
                )
                Spacer(Modifier.height(12.dp))

                Text("Pending: $pendingCount")
                Box(
                    modifier = Modifier
                        .fillMaxWidth(pendingCount.toFloat() / totalCount)
                        .height(16.dp)
                        .background(Color(0xFFFF9800))
                )
            }
        }
    }
}








