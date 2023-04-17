package com.pl.sggw.ecommers.domain.backoffice.product

import java.math.BigDecimal

data class Product(
    val productId: Long?,
    val name: String,
    val description: String?,
    val categoryId: String,
    val salePrice: BigDecimal,
    val promotionalPrice: BigDecimal?,
    val quantity: Int
) {
    fun isAvailable() = quantity > 0

    fun withId(productId : Long): Product{
        return copy(productId = productId)
    }

}
