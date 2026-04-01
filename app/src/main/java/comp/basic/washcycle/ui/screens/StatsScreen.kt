package comp.basic.washcycle.ui.screens

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun StatsScreen(viewModel: LaundryViewModel) {
//    // Use the correct StateFlow from your ViewModel
//    val historyItems: List<LaundryItem> by viewModel.historyItems.collectAsState(initial = emptyList())
//
//    val totalCount = historyItems.size
//    val doneCount = historyItems.count { it.status == "done" }
//    val pendingCount = historyItems.count { it.status == "waiting" }
//
//    Scaffold(topBar = { TopAppBar(title = { Text("Stats") }) }) { padding ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(padding)
//                .padding(16.dp)
//        ) {
//            if (totalCount == 0) {
//                Text("No data yet")
//            } else {
//                Text("Total items: $totalCount")
//                Spacer(Modifier.height(8.dp))
//
//                Text("Done: $doneCount")
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth(doneCount.toFloat() / totalCount)
//                        .height(16.dp)
//                        .background(Color(0xFF3DDC84))
//                )
//                Spacer(Modifier.height(12.dp))
//
//                Text("Pending: $pendingCount")
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth(pendingCount.toFloat() / totalCount)
//                        .height(16.dp)
//                        .background(Color(0xFFFF9800))
//                )
//            }
//        }
//    }
//}

// CAUTION!!! INTERNAL FEATURES BEFORE RELEASE!!!








