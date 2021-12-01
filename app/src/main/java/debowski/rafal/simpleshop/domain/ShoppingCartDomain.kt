package debowski.rafal.simpleshop.domain

class ShoppingCartDomain(
    val shoppingCartId: Long = 0,
    var productName: String = "",
    var price: Int = 0,
    var color: String = "",
    var brand: String = "",
    var quantity: Int = 1
)