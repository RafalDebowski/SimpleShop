package debowski.rafal.simpleshop.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Bike")
class BikeEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    var bikeId: Long = 0,

    @ColumnInfo(name = "NAME")
    var name: String,

    @ColumnInfo(name = "PRICE")
    var price: Int,

    @ColumnInfo(name = "COLOR")
    var color: String,

    @ColumnInfo(name = "BRAND")
    var brand: String
)