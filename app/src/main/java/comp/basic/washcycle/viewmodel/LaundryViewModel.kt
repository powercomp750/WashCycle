package comp.basic.washcycle.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import comp.basic.washcycle.data.SessionWithCategories
import comp.basic.washcycle.repository.LaundrySessionRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class LaundrySessionViewModel(private val repository: LaundrySessionRepository) : ViewModel() {
    val sessions: StateFlow<List<SessionWithCategories>> =
        repository.sessions.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun addSession(
        startTime: Long,
        endTime: Long,
        usedFabricConditioner: Boolean,
        categories: List<Pair<String, Int>>
    ) {}

    fun clearAll() {}

    fun deleteSession(session: SessionWithCategories) {}
}


