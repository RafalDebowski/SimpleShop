package debowski.rafal.simpleshop.ui.fragments

import android.icu.lang.UCharacter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import debowski.rafal.simpleshop.R
import debowski.rafal.simpleshop.databinding.FragmentBikeListBinding
import debowski.rafal.simpleshop.ui.adapters.BikeListAdapter
import debowski.rafal.simpleshop.ui.viewModel.bikeList.BikeListViewModel

class BikeListFragment : Fragment() {

    private lateinit var binding: FragmentBikeListBinding
    private lateinit var navController: NavController

    private val adapter = BikeListAdapter()

    private lateinit var viewModel : BikeListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBikeListBinding.inflate(inflater, container, false)
        navController = NavHostFragment.findNavController(this)

        viewModel = BikeListViewModel(
            binding.root.context
        )

        viewModel.getAllBikes()

        binding.recyclerViewBikeList.layoutManager = LinearLayoutManager(inflater.context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewBikeList.adapter = adapter

        observeData()
        initButtons()

        return binding.root
    }


    private fun observeData(){
        viewModel.bikeList.observe(
            viewLifecycleOwner,
            {
                adapter.listItem = it
            }
        )
    }

    private fun initButtons() {
        binding.buttonShoppingCart.setOnClickListener {
            navController.navigate(R.id.action_bikeListFragment_to_shopingCartFragment)
        }
    }

}