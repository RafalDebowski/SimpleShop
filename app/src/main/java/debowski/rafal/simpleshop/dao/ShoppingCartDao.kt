package debowski.rafal.simpleshop.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import debowski.rafal.simpleshop.entity.ShoppingCartEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface ShoppingCartDao {

    @Insert
    fun insertShoppingCartItem(shoppingItem: ShoppingCartEntity): Completable

    @Query("SELECT * FROM ShoppingCart")
    fun getAllShoppingCartItems(): Single<List<ShoppingCartEntity>>

    @Query("DELETE FROM ShoppingCart WHERE ShoppingCart.ID =:shoppingCartId")
    fun deleteShoppingCartItemById(shoppingCartId: Long): Completable

    @Query("UPDATE ShoppingCart SET quantity= :quantity WHERE ShoppingCart.ID =:shoppingCartId ")
    fun updateShoppingCartItemById(shoppingCartId: Long, quantity: Int): Completable
}