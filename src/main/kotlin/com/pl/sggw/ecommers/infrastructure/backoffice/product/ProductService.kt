package com.pl.sggw.ecommers.infrastructure.backoffice.product

import com.pl.sggw.ecommers.domain.backoffice.product.Product
import com.pl.sggw.ecommers.domain.backoffice.product.ProductRepository

class ProductService(private val productRepository: ProductRepository) {

    fun upsertProduct(product: Product) {
        if (product.productId == null) {
            val productId = productRepository.getNextProductId()
            productRepository.addProduct(product.withId(productId))
        } else {
            productRepository.updateProduct(product)
        }
    }

}
