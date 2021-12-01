package debowski.rafal.simpleshop

import android.content.Context
import debowski.rafal.simpleshop.domain.BikeDomain
import debowski.rafal.simpleshop.repository.Repository
import debowski.rafal.simpleshop.ui.viewModel.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel(applicationContext: Context) : BaseViewModel() {

    private val bikeRepository by lazy {
        Repository(applicationContext)
    }

    fun insertBikeList() {
        val disposable = bikeRepository
            .insertBikeDaoList(createBikesToSave())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()

        addDisposable(disposable)
    }

    fun deleteAllBikes() {
        val disposable = bikeRepository
            .deleteAllBikes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()

        addDisposable(disposable)
    }

    private fun createBikesToSave(): List<BikeDomain> {
        return listOf(      //MOCK DATA
            BikeDomain(
                name = "TABOU BLADE 29 2.0",
                price = 1899,
                color = "RED",
                brand = "TABOU"
            ),
            BikeDomain(
                name = "TABOU BLADE 30 4.0",
                price = 2300,
                color = "WHITE",
                brand = "TABOU"
            ),
            BikeDomain(
                name = "TABOU BLADE X 29 2.10",
                price = 1999,
                color = "GREEN",
                brand = "TABOU"
            ),
            BikeDomain(
                name = "NORTHTEC HALCYON ",
                price = 1899,
                color = "YELLOW",
                brand = "NORTHTEC"
            ),
            BikeDomain(
                name = "SCOTT CONTESSA ACTIVE 60",
                price = 1999,
                color = "BLACK",
                brand = "SCOTT"
            ),
            BikeDomain(
                name = "HEAD TROY I 27,5",
                price = 5299,
                color = "BLACK",
                brand = "HEAD"
            ),
            BikeDomain(
                name = "KELLYS VANITY 10",
                price = 4399,
                color = "WHITE",
                brand = "KELLYS"
            ),
            BikeDomain(
                name = "KROSS HEXAGON 3.0",
                price = 3200,
                color = "BLACK",
                brand = "KROSS"
            ),
            BikeDomain(
                name = "UNIBIKE EMOTION 26 EQ",
                price = 2455,
                color = "PINK",
                brand = "UNIBIKE"
            ),
            BikeDomain(
                name = "BULLS PULSAR ECO 27,5",
                price = 3100,
                color = "BLACK",
                brand = "BULLS"
            ),
            BikeDomain(
                name = "CTM SUZZY 2.0",
                price = 1530,
                color = "RED",
                brand = "CTM"
            ),
            BikeDomain(
                name = "ROCKRIDER ST 540 27,5",
                price = 1299,
                color = "WHITE",
                brand = "ROCKRIDER"
            )
        )
    }
}