package comp.basic.washcycle.data.backup

import kotlinx.serialization.Serializable

@Serializable
data class WashCycleBackup(
    val sessions: List<SessionWithCategoriesSerializable>
)

@Serializable
data class SessionWithCategoriesSerializable(
    val session: LaundrySessionSerializable,
    val categories: List<LaundryCategorySerializable>
)

@Serializable
data class LaundrySessionSerializable(
    val id: Int,
    val startTime: Long,
    val endTime: Long,
    val usedFabricConditioner: Boolean
)

@Serializable
data class LaundryCategorySerializable(
    val id: Int,
    val sessionId: Int,
    val category: String,
    val count: Int
)
