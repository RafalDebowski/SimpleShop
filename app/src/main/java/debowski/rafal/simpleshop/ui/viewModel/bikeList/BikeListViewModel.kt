package debowski.rafal.simpleshop.ui.viewModel.bikeList

import android.content.Context
import android.util.EventLog
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import debowski.rafal.simpleshop.domain.BikeDomain
import debowski.rafal.simpleshop.domain.ShoppingCartDomain
import debowski.rafal.simpleshop.repository.Repository
import debowski.rafal.simpleshop.ui.viewModel.base.BaseViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

class BikeListViewModel(applicationContext: Context) : BaseViewModel() {

    private val repository by lazy {
        Repository(applicationContext)
    }

    val action = MutableLiveData<Action>()
    var bikeList = MutableLiveData<List<BikeDomain>>()

    fun getAllBikes() {
        val disposable = repository
            .getAllBikes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                bikeList.value = it.toMutableList()
            }, {
                Log.e("ERROR", it.message.toString())
            })

        addDisposable(disposable)
    }

    fun insertShoppingCartItem(item: ShoppingCartDomain) {
        val disposable = repository
            .insertShoppingCartItem(item)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                action.value = Action.BikeIsAddedToShoppingCart
            }, {
                Log.e("ERROR", it.message.toString())
            })

        addDisposable(disposable)
    }

    sealed class Action {
        object BikeIsAddedToShoppingCart : Action()
    }
}