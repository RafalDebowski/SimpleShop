package debowski.rafal.simpleshop.database

import androidx.room.Database
import androidx.room.RoomDatabase
import debowski.rafal.simpleshop.dao.BikeDao
import debowski.rafal.simpleshop.dao.ShoppingCartDao
import debowski.rafal.simpleshop.entity.BikeEntity
import debowski.rafal.simpleshop.entity.ShoppingCartEntity

@Database(
    entities = [
        BikeEntity::class,
        ShoppingCartEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bikeDao(): BikeDao

    abstract fun ShoppingCartDao(): ShoppingCartDao
}