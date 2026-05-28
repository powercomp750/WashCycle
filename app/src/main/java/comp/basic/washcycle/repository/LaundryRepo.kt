package comp.basic.washcycle.repository

import comp.basic.washcycle.data.LaundrySession
import comp.basic.washcycle.data.LaundrySessionDao
import comp.basic.washcycle.data.SessionWithCategories
import kotlinx.coroutines.flow.Flow

class LaundrySessionRepository(private val dao: LaundrySessionDao) {
    val sessions: Flow<List<SessionWithCategories>> = dao.getAllSessions()
    suspend fun addSessionWithCategories(
        startTime: Long,
        endTime: Long,
        usedFabricConditioner: Boolean,
        categories: List<Pair<String, Int>>
    ) {
        //insert logic
    }

    suspend fun clearAll() {
        //Delete all sessions
    }

    suspend fun deleteSession(session: LaundrySession) {
        //Delete particular session
    }
}