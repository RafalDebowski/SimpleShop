package debowski.rafal.simpleshop.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import debowski.rafal.simpleshop.databinding.ItemBikeListBinding
import debowski.rafal.simpleshop.domain.BikeDomain
import debowski.rafal.simpleshop.domain.ShoppingCartDomain

class BikeListAdapter(
    val onItemClick: (item: BikeDomain) -> Unit
) : RecyclerView.Adapter<BikeListAdapter.BikeViewHolder>() {

    var listItem: List<BikeDomain> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BikeViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val binding = ItemBikeListBinding.inflate(layoutInflater, viewGroup, false)

        return BikeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BikeViewHolder, position: Int) {
        BikeViewHolder(holder.binding).bind(
            listItem[position]
        )
    }

    override fun getItemCount(): Int = listItem.size

    inner class BikeViewHolder(
        val binding: ItemBikeListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BikeDomain) {

            binding.name.text = item.name
            binding.brand.text = item.brand
            binding.color.text = item.color

            binding.buttonIncrease.setOnClickListener {
                onItemClick(item)
            }
        }
    }


}