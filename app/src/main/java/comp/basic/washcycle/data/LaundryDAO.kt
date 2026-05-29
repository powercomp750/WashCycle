package comp.basic.washcycle.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface LaundryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: LaundryItem)

    @Query("SELECT * FROM laundry_items WHERE status = 'waiting' ORDER BY dateAdded ASC")
    fun getPendingItems(): Flow<List<LaundryItem>>

    @Query("SELECT * FROM laundry_items WHERE status = 'done' ORDER BY dateWashed DESC")
    fun getHistory(): Flow<List<LaundryItem>>

    @Query("UPDATE laundry_items SET status = 'done', dateWashed = :date WHERE status = 'waiting'")
    suspend fun markAllAsWashed(date: Long)

    @Query("DELETE FROM laundry_items")
    suspend fun clearAll()
}
