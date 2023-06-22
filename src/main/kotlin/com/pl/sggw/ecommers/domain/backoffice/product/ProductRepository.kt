package com.pl.sggw.ecommers.domain.backoffice.product

interface ProductRepository {
    fun addProduct(product: Product)
    fun updateProduct(product: Product)
    fun findProduct(productId: Long): Product?
    fun getNextProductId(): Long
    fun updateStock(productId: Long, quantity: Long)

    fun decreaseStock(productId: Long, quantity: Long)
    fun getProductsFromCategory(categoryId: String): List<Product>


}
