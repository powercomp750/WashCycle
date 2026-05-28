package comp.basic.washcycle.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import comp.basic.washcycle.data.Settings
import comp.basic.washcycle.viewmodel.LaundrySessionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavHost(viewModel: LaundrySessionViewModel) {
    data class TabItem(val route: String, val label: String, val icon: ImageVector)
    val navController = rememberNavController()
    var selected by remember { mutableStateOf("Add") }
    val context = LocalContext.current
    val settingsStorage = remember { Settings(context) }
//    val db = LaundryDatabase.getDatabase(context)
//    val sessionRepo = remember { LaundrySessionRepository(dao = db.sessionDao()) }
//    val backupManager = remember { BackupManager(sessionRepo) }

    val tabs = listOf(
        TabItem("add", "Add", Icons.Default.AddCircle),
        TabItem("history", "History", Icons.Default.History),
        TabItem("stats", "Stats", Icons.Default.BarChart)
    )

    Scaffold(
        topBar = { CenterAlignedTopAppBar(
            title = { Text("WashCycle") },
            actions = {
                IconButton(onClick = { navController.navigate("settings") }) {
                    Icon(Icons.Default.Settings, contentDescription = "Settings")
                }

            }
        ) },
        bottomBar = {
            NavigationBar {
                tabs.forEach { tab ->
                    NavigationBarItem(
                        icon = { Icon(tab.icon, contentDescription = tab.label) },
                        label = { Text(tab.label) },
                        selected = selected.equals(tab.route, ignoreCase = true),
                        onClick = {
                            selected = tab.route
                            navController.navigate(tab.route) { launchSingleTop = true }
                        }
                    )
                }
            }
        }
    ) { padding ->
        NavHost(navController = navController, startDestination = "add", modifier = Modifier.fillMaxSize().padding(padding)) {
            composable("add") { AddLaundrySessionScreen(viewModel, settingsStorage) }
            composable("history") { HistoryScreen(viewModel, settingsStorage) }
            composable("stats") { StatsScreen(viewModel,settingsStorage) }
            composable("settings") { SettingsScreen(viewModel,settingsStorage, backupManager)  }
        }
    }
}