package comp.basic.washcycle.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.Relation
import kotlinx.serialization.Serializable

@Entity(tableName = "laundry_sessions")
data class LaundrySession(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val startTime: Long,
    val endTime: Long,
    val usedFabricConditioner: Boolean
)


@Entity(tableName = "laundry_categories")
data class LaundryCategory(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val sessionId: Int,
    val category: String,
    val count: Int
)


data class SessionWithCategories(
    @Embedded val session: LaundrySession,
    @Relation(
        parentColumn = "id",
        entityColumn = "sessionId"
    )
    val categories: List<LaundryCategory>
)



