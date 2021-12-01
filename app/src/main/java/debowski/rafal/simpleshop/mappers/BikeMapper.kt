package debowski.rafal.simpleshop.mappers

import debowski.rafal.simpleshop.domain.BikeDomain
import debowski.rafal.simpleshop.entity.BikeEntity

fun BikeEntity.toBikeDomain(): BikeDomain =
    BikeDomain(
        bikeId = this.bikeId,
        name = this.name,
        price = this.price,
        color = this.color,
        brand = this.brand
    )

fun BikeDomain.toBikeEntity(): BikeEntity =
    BikeEntity(
        bikeId = this.bikeId,
        name = this.name,
        price = this.price,
        color = this.color,
        brand = this.brand
    )

fun List<BikeEntity>.toBikeDomainList(): List<BikeDomain> =
    this.map { it.toBikeDomain() }

fun List<BikeEntity>.toBikeEntityList(): List<BikeDomain> =
    this.map { it.toBikeDomain() }
