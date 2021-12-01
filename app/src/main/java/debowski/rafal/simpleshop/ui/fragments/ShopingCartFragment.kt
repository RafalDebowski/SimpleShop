package debowski.rafal.simpleshop.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import debowski.rafal.simpleshop.R
import debowski.rafal.simpleshop.databinding.FragmentBikeListBinding
import debowski.rafal.simpleshop.databinding.FragmentShopingCartBinding


class ShopingCartFragment : Fragment() {

    private lateinit var binding: FragmentShopingCartBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =  FragmentShopingCartBinding.inflate(layoutInflater, container, false)
        navController = NavHostFragment.findNavController(this)

        initButtons()

        return binding.root
    }

    private fun initButtons(){

        binding.buttonBikeList.setOnClickListener {
            navController.navigate(R.id.action_shopingCartFragment_to_bikeListFragment)
        }
    }
}