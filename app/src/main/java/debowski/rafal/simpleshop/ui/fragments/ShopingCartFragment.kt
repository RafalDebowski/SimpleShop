package debowski.rafal.simpleshop.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import debowski.rafal.simpleshop.R
import debowski.rafal.simpleshop.databinding.FragmentShopingCartBinding
import debowski.rafal.simpleshop.ui.adapters.ShoppingCartAdapter
import debowski.rafal.simpleshop.ui.viewModel.shopingCart.ShopingCartViewModel


class ShopingCartFragment : Fragment() {

    private lateinit var binding: FragmentShopingCartBinding
    private lateinit var navController: NavController

    private lateinit var viewModel: ShopingCartViewModel

    private val adapter = ShoppingCartAdapter(
        ::onDecreaseClick,
        ::onIncreaseClick
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShopingCartBinding.inflate(layoutInflater, container, false)
        navController = NavHostFragment.findNavController(this)
        binding.recyclerViewShoppingCart.adapter = adapter

        viewModel = ShopingCartViewModel(
            binding.root.context
        )

        viewModel.getAllShoppingCartItems()

        observeData()
        initButtons()

        return binding.root
    }

    private fun onDecreaseClick(shoppingCartId: Long) {
        viewModel.deleteShoppingCartItemById(shoppingCartId)
    }

    private fun onIncreaseClick(shoppingCartId: Long, quantity: Int) {
        viewModel.updateShoppingCartItemById(shoppingCartId, quantity)
    }

    private fun observeData() {
        viewModel.shopingCartList.observe(
            viewLifecycleOwner,
            {
                adapter.listItem = it
            }
        )

        viewModel.sumPrice.observe(
            viewLifecycleOwner,
            {
                binding.sumPrice.text = it.toString()
            }
        )
    }

    private fun initButtons() {
        binding.buttonBikeList.setOnClickListener {
            navController.navigate(R.id.action_shopingCartFragment_to_bikeListFragment)
        }
    }
}