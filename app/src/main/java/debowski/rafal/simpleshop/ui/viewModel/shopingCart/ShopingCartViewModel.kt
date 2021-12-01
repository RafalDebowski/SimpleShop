package debowski.rafal.simpleshop.ui.viewModel.shopingCart

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import debowski.rafal.simpleshop.domain.ShoppingCartDomain
import debowski.rafal.simpleshop.repository.Repository
import debowski.rafal.simpleshop.ui.viewModel.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ShopingCartViewModel(applicationContext: Context) : BaseViewModel() {

    private val repository by lazy {
        Repository(applicationContext)
    }

    var shopingCartList = MutableLiveData<List<ShoppingCartDomain>>()
    var sumPrice = MutableLiveData<Int>()

    fun getAllShoppingCartItems() {
        val disposable = repository
            .getAllShoppingCartItems()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    shopingCartList.value = it
                    sumPrice.value = updateSumPrice(it)
                }, {
                    Log.e("MESSAGE_ERROR", it.message.toString())
                }
            )

        addDisposable(disposable)
    }

    private fun updateSumPrice(list: List<ShoppingCartDomain>): Int {
        var sumPrice = 0
        list.forEach {
            sumPrice += (it.price * it.quantity)
        }

        return sumPrice
    }


    fun deleteShoppingCartItemById(shoppingCartId: Long) {
        val disposable = repository
            .deleteShoppingCartItemById(shoppingCartId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                getAllShoppingCartItems()
            }, {
                Log.e("MESSAGE_ERROR", it.message.toString())
            })

        addDisposable(disposable)
    }

    fun updateShoppingCartItemById(shoppingCartId: Long, quantity: Int) {
        val disposable = repository
            .updateShoppingCartItemById(shoppingCartId, quantity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    getAllShoppingCartItems()
                }, {
                    Log.e("MESSAGE_ERROR", it.message.toString())
                }
            )

        addDisposable(disposable)
    }
}