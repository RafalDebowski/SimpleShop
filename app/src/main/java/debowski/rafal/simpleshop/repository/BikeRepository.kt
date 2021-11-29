package debowski.rafal.simpleshop.repository

import android.content.Context
import androidx.room.Room
import debowski.rafal.simpleshop.MainActivity
import debowski.rafal.simpleshop.database.AppDatabase
import debowski.rafal.simpleshop.domain.BikeDomain
import debowski.rafal.simpleshop.mappers.toBikeEntity
import io.reactivex.Completable

class BikeRepository(applicationContext: Context) {

    private val database = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java,
        MainActivity.DATABASE_NAME
    ).build()

    fun insertBikeDao(bike: BikeDomain) : Completable =
        database.bikeDao().insertBike(bike.toBikeEntity())
}