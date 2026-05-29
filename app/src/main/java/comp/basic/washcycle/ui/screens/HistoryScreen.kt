package comp.basic.washcycle.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import comp.basic.washcycle.data.Settings
import comp.basic.washcycle.viewmodel.LaundrySessionViewModel


@Composable
fun HistoryScreen(viewModel: LaundrySessionViewModel, settings: Settings) {
    val sessions by viewModel.sessions.collectAsState(initial = emptyList())

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(sessions, key = { it.session.id }) {

        }
    }
}









