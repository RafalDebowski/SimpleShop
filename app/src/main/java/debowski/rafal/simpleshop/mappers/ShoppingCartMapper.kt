package debowski.rafal.simpleshop.mappers

import debowski.rafal.simpleshop.domain.ShoppingCartDomain
import debowski.rafal.simpleshop.entity.ShoppingCartEntity

fun ShoppingCartEntity.toShoppingCartDomain(): ShoppingCartDomain =
    ShoppingCartDomain(
       shoppingCartId = this.shoppingCartId,
        productName = this.productName,
        price = this.price,
        color = this.color,
        brand = this.brand,
        quantity = this.quantity
    )

fun ShoppingCartDomain.toShoppingCartEntity(): ShoppingCartEntity =
    ShoppingCartEntity(
        shoppingCartId = this.shoppingCartId,
        productName = this.productName,
        price = this.price,
        color = this.color,
        brand = this.brand,
        quantity = this.quantity
    )


fun List<ShoppingCartEntity>.toShoppingCartDomainList() : List<ShoppingCartDomain> =
    this.map { it.toShoppingCartDomain() }

fun List<ShoppingCartDomain>.toShoppingCartEntityList() : List<ShoppingCartEntity> =
    this.map { it.toShoppingCartEntity() }