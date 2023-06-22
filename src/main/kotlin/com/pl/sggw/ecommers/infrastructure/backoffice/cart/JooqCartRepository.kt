package com.pl.sggw.ecommers.infrastructure.backoffice.cart

import com.pl.sggw.ecommers.domain.backoffice.cart.Cart
import com.pl.sggw.ecommers.domain.backoffice.cart.CartRepository
import com.pl.sggw.ecommers.domain.backoffice.product.Product
import com.pl.sggw.ecommers.jooq.tables.references.CART
import com.pl.sggw.ecommers.jooq.tables.references.CART_PRODUCT
import com.pl.sggw.ecommers.jooq.tables.references.PRODUCT
import org.jooq.DSLContext
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.time.OffsetDateTime
import java.util.UUID

@Repository
@Transactional
class JooqCartRepository(private val ctx: DSLContext) : CartRepository {

    override fun saveCart(cart: Cart) {
        val uuid = UUID.randomUUID().toString()
        ctx.insertInto(CART)
            .columns(
                CART.ID,
                CART.CUSTOMER_ID,
                CART.CART_VALUE,
                CART.CREATION_TIMESTAMP
            )
            .values(
                uuid,
                cart.userId,
                cart.getValueOfCart(),
                OffsetDateTime.now().toLocalDateTime()
            )
            .execute()

        cart.productToQuantity.entries.stream()
            .forEach {
                saveCartProduct(it.key, it.value, uuid)
            }

    }


    override fun getCart(cartId: String): Cart {
        val products = ctx.select()
            .from(CART_PRODUCT)
            .join(PRODUCT).on(CART_PRODUCT.PRODUCT_ID.eq(PRODUCT.ID))
            .where(CART_PRODUCT.CART_ID.eq(cartId))
            .fetch { r ->
                Product(
                    productId = r.getValue(PRODUCT.ID) as Long,
                    name = r.getValue(PRODUCT.NAME) as String,
                    description = r.getValue(PRODUCT.DESCRIPTION) as String,
                    categoryId = r.getValue(PRODUCT.CATEGORY_ID) as String,
                    salePrice = r.getValue(CART_PRODUCT.PRICE_PER_ITEM) as BigDecimal,
                    promotionalPrice = r.getValue(CART_PRODUCT.PRICE_PER_ITEM) as BigDecimal,
                    image = null,
                    quantity = (r.getValue(CART_PRODUCT.PRICE_PER_ITEM) as BigDecimal).toInt(),
                )
            }
            .associateWith { it.quantity.toLong() }

        return Cart(0L,products)

    }

    override fun getAllCartsForUser(userId: Long): List<Cart> {
        return ctx.select(CART.ID)
            .where(CART.CUSTOMER_ID.eq(userId))
            .fetch{
                r -> r.getValue(CART.ID) as String
            }
            .stream()
            .map { getCart(it) }
            .toList()

    }

    private fun saveCartProduct(product: Product, quantity: Long, uuid: String) {
        ctx.insertInto(CART_PRODUCT)
            .columns(
                CART_PRODUCT.CART_ID,
                CART_PRODUCT.PRODUCT_ID,
                CART_PRODUCT.PRICE_PER_ITEM,
                CART_PRODUCT.QUANTITY
            )
            .values(
                uuid,
                product.productId,
                product.getPrice(),
                quantity.toBigDecimal()
            )
            .execute()

    }

}