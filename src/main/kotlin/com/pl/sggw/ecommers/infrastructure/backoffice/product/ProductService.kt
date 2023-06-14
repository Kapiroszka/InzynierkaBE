package com.pl.sggw.ecommers.infrastructure.backoffice.product

import com.pl.sggw.ecommers.domain.backoffice.product.Product
import com.pl.sggw.ecommers.domain.backoffice.product.ProductRepository
import com.pl.sggw.ecommers.domain.backoffice.product.Stock
import com.pl.sggw.ecommers.domain.backoffice.product.StockRepository
import org.springframework.transaction.annotation.Transactional

class ProductService(
    private val productRepository: ProductRepository,
    private val stockRepository: StockRepository
) {

    fun upsertProduct(product: Product) {
        if (product.productId == null) {
            val productId = productRepository.getNextProductId()
            productRepository.addProduct(product.withId(productId))
        } else {
            productRepository.updateProduct(product)
        }
    }

    @Transactional
    fun addStock(stock: Stock) {
        stockRepository.addStock(stock)
        productRepository.updateStock(stock.productId, stock.quantity)
    }

    @Transactional
    fun removeProductFromStock(productId: Long, amount: Long): Boolean {
        productRepository.findProduct(productId)?.let {
            if (it.quantity < amount) {
                return false
            }
            productRepository.decreaseStock(productId, amount)
            return true
        } ?: return false

    }

}
