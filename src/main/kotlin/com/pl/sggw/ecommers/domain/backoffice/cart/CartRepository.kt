package com.pl.sggw.ecommers.domain.backoffice.cart


interface CartRepository {
    fun saveCart(cart: Cart)
    fun getCart(cartId: String): Cart
    fun getAllCartsForUser(userId : Long) : List<Cart>
}