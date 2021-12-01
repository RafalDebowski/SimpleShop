package debowski.rafal.simpleshop.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import debowski.rafal.simpleshop.databinding.ItemShoppingCartBinding
import debowski.rafal.simpleshop.domain.ShoppingCartDomain

class ShoppingCartAdapter(
    private val onDecreaseClick: (shoppingCartId: Long) -> Unit,
    private val onIncreaseClick: (shoppingCartId: Long, quantity: Int) -> Unit
) : RecyclerView.Adapter<ShoppingCartAdapter.ShoppingCartViewHolder>() {

    var listItem: List<ShoppingCartDomain> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingCartViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemShoppingCartBinding.inflate(layoutInflater, parent, false)

        return ShoppingCartViewHolder(binding)
    }

    override fun getItemCount(): Int = listItem.size

    override fun onBindViewHolder(holder: ShoppingCartViewHolder, position: Int) {
        ShoppingCartViewHolder(holder.binding).bind(
            listItem[position]
        )
    }

    inner class ShoppingCartViewHolder(
        val binding: ItemShoppingCartBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ShoppingCartDomain) {

            binding.name.text = item.productName
            binding.quantity.text = item.quantity.toString()
            binding.price.text = item.price.toString()


            binding.buttonDecrease.setOnClickListener {
                decreaseQuantity(item)
            }

            binding.buttonIncrease.setOnClickListener {
                increaseQuantity(item)
            }
        }

        private fun increaseQuantity(item: ShoppingCartDomain) {
            item.quantity += 1
            binding.quantity.text = item.quantity.toString()

            onIncreaseClick(item.shoppingCartId, item.quantity)

            notifyItemChanged(adapterPosition)
        }

        private fun decreaseQuantity(item: ShoppingCartDomain) {

            if (item.quantity > 1) {
                item.quantity -= 1
                onIncreaseClick(item.shoppingCartId, item.quantity)
            } else {
                onDecreaseClick(item.shoppingCartId)
            }
            binding.quantity.text = item.quantity.toString()

            notifyDataSetChanged()
        }
    }
}


