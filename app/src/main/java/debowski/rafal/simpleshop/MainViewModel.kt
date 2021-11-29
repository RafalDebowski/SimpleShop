package debowski.rafal.simpleshop

import android.content.Context
import debowski.rafal.simpleshop.domain.BikeDomain
import debowski.rafal.simpleshop.repository.BikeRepository
import debowski.rafal.simpleshop.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(applicationContext: Context) : BaseViewModel() {

    private val bikeRepository by lazy {
        BikeRepository(applicationContext)
    }

    fun insertBike() {
        val disposable = bikeRepository
            .insertBikeDao(
                BikeDomain(
                name = "BIKE",
                price = 1999,
                color = "WHITE",
                brand = "ZIPP"
            )
        ).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()

        addDisposable(disposable)
    }
}