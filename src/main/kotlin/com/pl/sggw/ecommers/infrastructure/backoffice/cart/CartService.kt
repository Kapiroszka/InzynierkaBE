package com.pl.sggw.ecommers.infrastructure.backoffice.cart

import com.pl.sggw.ecommers.domain.backoffice.cart.Cart
import com.pl.sggw.ecommers.domain.backoffice.cart.CartRepository
import com.pl.sggw.ecommers.infrastructure.backoffice.product.ProductService

import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException

class CartService(
    private val cartRepository: CartRepository,
    private val productService: ProductService
) {
    @Transactional
    fun saveCart(cart: Cart) {
        val resultOfDecreaseProductStock = cart.productToQuantity.entries
            .stream()
            .map {
                productService.removeProductFromStock(it.key.productId!!, it.value)
            }
            .toList()
            .fold(true) { acc, next -> next && acc }
        if (!resultOfDecreaseProductStock) {
            throw RuntimeException("Stock does not contain enough amount of products to fulfilled purchase ")
        }
        cartRepository.saveCart(cart)
    }

    fun findCart(cartId: String) : Cart{
        return cartRepository.getCart(cartId)
    }

    fun getAllUserCarts(userId : Long) : List<Cart>{
        return cartRepository.getAllCartsForUser(userId)
    }
}