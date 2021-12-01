package debowski.rafal.simpleshop.repository

import android.content.Context
import androidx.room.Room
import debowski.rafal.simpleshop.MainActivity
import debowski.rafal.simpleshop.database.AppDatabase
import debowski.rafal.simpleshop.domain.BikeDomain
import debowski.rafal.simpleshop.domain.ShoppingCartDomain
import debowski.rafal.simpleshop.mappers.toBikeDomainList
import debowski.rafal.simpleshop.mappers.toBikeEntity
import debowski.rafal.simpleshop.mappers.toShoppingCartDomainList
import debowski.rafal.simpleshop.mappers.toShoppingCartEntity
import io.reactivex.Completable
import io.reactivex.Single

class Repository(applicationContext: Context) {

    private val database = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java,
        MainActivity.DATABASE_NAME
    ).build()

    fun insertBikeDaoList(bike: List<BikeDomain>): Completable =
        database.bikeDao().insertBikeList(bike.map { it.toBikeEntity() })

    fun getAllBikes(): Single<List<BikeDomain>> =
        database.bikeDao().getAllBikes().map {
            it.toBikeDomainList()
        }

    fun insertShoppingCartItem(shoppingItem: ShoppingCartDomain): Completable =
        database.ShoppingCartDao().insertShoppingCartItem(shoppingItem.toShoppingCartEntity())


    fun getAllShoppingCartItems(): Single<List<ShoppingCartDomain>> =
        database.ShoppingCartDao().getAllShoppingCartItems().map {
            it.toShoppingCartDomainList()
        }

    fun deleteShoppingCartItemById(shoppingCartId: Long): Completable =
        database.ShoppingCartDao().deleteShoppingCartItemById(shoppingCartId)

    fun deleteAllBikes(): Completable =
        database.bikeDao().deleteAllBikes()

    fun updateShoppingCartItemById(shoppingCartId: Long, quantity: Int): Completable =
        database.ShoppingCartDao().updateShoppingCartItemById(shoppingCartId, quantity)

}