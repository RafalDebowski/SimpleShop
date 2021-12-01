package debowski.rafal.simpleshop.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import debowski.rafal.simpleshop.entity.BikeEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface BikeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBike(bike : BikeEntity) : Completable

    @Query("SELECT * FROM Bike")
    fun getAllBikes() : Single<List<BikeEntity>>
}