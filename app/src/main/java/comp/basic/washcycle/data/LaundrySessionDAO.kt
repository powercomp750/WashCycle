package comp.basic.washcycle.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface LaundrySessionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSession(session: LaundrySession): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategories(categories: List<LaundryCategory>)

    @Transaction
    @Query("SELECT * FROM laundry_sessions ORDER BY endTime DESC")
    fun getAllSessions(): Flow<List<SessionWithCategories>>

    @Query("DELETE FROM laundry_sessions")
    suspend fun clearAllSessions()

    @Delete
    suspend fun deleteSession(session: LaundrySession)

    @Query("DELETE FROM laundry_categories WHERE sessionId = :sessionId")
    suspend fun deleteCategoriesForSession(sessionId: Int)
}


