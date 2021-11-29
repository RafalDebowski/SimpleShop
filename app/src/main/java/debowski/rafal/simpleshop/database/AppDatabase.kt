package debowski.rafal.simpleshop.database

import androidx.room.Database
import androidx.room.RoomDatabase
import debowski.rafal.simpleshop.dao.BikeDao
import debowski.rafal.simpleshop.entity.BikeEntity

@Database(
    entities = [BikeEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bikeDao(): BikeDao
}