package debowski.rafal.simpleshop.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ShoppingCart")
class ShoppingCartEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    val shoppingCartId: Long,

    @ColumnInfo(name = "productName")
    var productName: String,

    @ColumnInfo(name = "price")
    var price: Int,

    @ColumnInfo(name = "color")
    var color: String,

    @ColumnInfo(name = "brand")
    var brand: String,

    @ColumnInfo(name = "quantity")
    var quantity: Int,

    )