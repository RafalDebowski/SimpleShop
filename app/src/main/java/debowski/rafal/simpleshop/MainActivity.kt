package debowski.rafal.simpleshop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import debowski.rafal.simpleshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object{
        const val DATABASE_NAME = "MY_DATABASE"
    }

    private lateinit var binding: ActivityMainBinding

    private val viewModel by lazy {
        MainViewModel(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater, null)
        binding.lifecycleOwner = this

        insertBike()

        setContentView(binding.root)
    }

    private fun insertBike(){
        viewModel.insertBike()
    }
}