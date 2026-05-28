package comp.basic.washcycle.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [LaundryItem::class, LaundrySession::class, LaundryCategory::class],
    version = 1,
    exportSchema = true
)
abstract class LaundryDatabase : RoomDatabase() {
    abstract fun laundryDao(): LaundryDao
    abstract fun sessionDao(): LaundrySessionDao

    companion object {
        @Volatile
        private var INSTANCE: LaundryDatabase? = null

        fun getDatabase(context: Context): LaundryDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LaundryDatabase::class.java,
                    "laundry_db"
                )
                    .fallbackToDestructiveMigration(false) // ✅ deletes old data, creates new schema
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}



