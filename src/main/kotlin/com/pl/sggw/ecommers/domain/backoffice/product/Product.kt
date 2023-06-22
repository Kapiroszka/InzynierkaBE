package com.pl.sggw.ecommers.domain.backoffice.product

import java.math.BigDecimal

data class Product(
    val productId: Long?,
    val name: String,
    val description: String?,
    val categoryId: String,
    val salePrice: BigDecimal,
    val promotionalPrice: BigDecimal?,
    val image : ByteArray?,
    val quantity: Int
) {
    fun isAvailable() = quantity > 0

    fun withId(productId : Long): Product{
        return copy(productId = productId)
    }

    fun getPrice() : BigDecimal{
        return promotionalPrice ?: salePrice
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product

        if (productId != other.productId) return false
        if (name != other.name) return false
        if (description != other.description) return false
        if (categoryId != other.categoryId) return false
        if (salePrice != other.salePrice) return false
        if (promotionalPrice != other.promotionalPrice) return false
        if (quantity != other.quantity) return false

        return true
    }

    override fun hashCode(): Int {
        var result = productId?.hashCode() ?: 0
        result = 31 * result + name.hashCode()
        result = 31 * result + (description?.hashCode() ?: 0)
        result = 31 * result + categoryId.hashCode()
        result = 31 * result + salePrice.hashCode()
        result = 31 * result + (promotionalPrice?.hashCode() ?: 0)
        result = 31 * result + quantity
        return result
    }

}
