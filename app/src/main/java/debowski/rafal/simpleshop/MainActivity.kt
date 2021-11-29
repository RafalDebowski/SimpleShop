package debowski.rafal.simpleshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    companion object{
        const val DATABASE_NAME = "MY_DATABASE"
    }

    private val viewModel by lazy {
        MainViewModel(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        insertBike()
    }

    private fun insertBike(){
        viewModel.insertBike()
    }
}