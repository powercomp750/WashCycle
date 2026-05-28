package comp.basic.washcycle.ui.screens

import androidx.compose.runtime.Composable
import comp.basic.washcycle.data.Settings
import comp.basic.washcycle.viewmodel.LaundrySessionViewModel


@Composable
fun AddLaundrySessionScreen(viewModel: LaundrySessionViewModel, settings: Settings) {

    //The clothes I mostly handle
    val predefinedCategories = listOf(
        "Shirts","T-Shirts","Jeans","Trousers/Pants","Vests","Underwear","Napkins","Socks","Bedsheets","Others"
    )

}



