package debowski.rafal.simpleshop.ui.viewModel.bikeList

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import debowski.rafal.simpleshop.domain.BikeDomain
import debowski.rafal.simpleshop.repository.BikeRepository
import debowski.rafal.simpleshop.ui.viewModel.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class BikeListViewModel(applicationContext: Context) : BaseViewModel() {

    private val bikeRepository by lazy {
        BikeRepository(applicationContext)
    }

    var bikeList = MutableLiveData<List<BikeDomain>>()

    fun getAllBikes() {
        val disposable = bikeRepository
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
}