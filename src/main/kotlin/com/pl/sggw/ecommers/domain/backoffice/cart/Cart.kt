package com.pl.sggw.ecommers.domain.backoffice.cart

import com.pl.sggw.ecommers.domain.backoffice.product.Product
import java.math.BigDecimal

data class Cart(
    val userId: Long,
    val productToQuantity: Map<Product, Long>
) {
    fun getValueOfCart(): BigDecimal {
        return productToQuantity
            .entries
            .stream()
            .map { BigDecimal.valueOf(it.value) * (it.key.promotionalPrice ?: it.key.salePrice) }
            .reduce { acc, next -> acc + next }
            .orElse(BigDecimal.ZERO)
    }

}
