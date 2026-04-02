package comp.basic.washcycle.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "laundry_items")
data class LaundryItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String = "",
    val status: String = "waiting", // "waiting" or "done"
    val dateAdded: Long = System.currentTimeMillis(),
    val dateWashed: Long? = null,
    val category: String,
    val count: Int = 1
)
