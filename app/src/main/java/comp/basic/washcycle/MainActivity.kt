package comp.basic.washcycle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.lifecycle.viewmodel.compose.viewModel
import comp.basic.washcycle.data.LaundryDatabase
import comp.basic.washcycle.repository.LaundrySessionRepository
import comp.basic.washcycle.ui.screens.AppNavHost
import comp.basic.washcycle.ui.theme.WashCycleTheme
import comp.basic.washcycle.viewmodel.LaundrySessionViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            WashCycleTheme {
                // Database
                val database = LaundryDatabase.getDatabase(applicationContext)

                // Repository
                //val repository = LaundrySessionRepository()

                // ViewModel
                val viewModel: LaundrySessionViewModel = viewModel()

                // Navigation
                AppNavHost(
                    viewModel = viewModel
                )
            }
        }
    }
}

