package comp.basic.washcycle.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [],
    version = 1,
    exportSchema = true
)
abstract class LaundryDatabase : RoomDatabase() {
    //Will define the DAO's here
}



