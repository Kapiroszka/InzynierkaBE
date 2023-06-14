package com.pl.sggw.ecommers.infrastructure.backoffice.product

import com.pl.sggw.ecommers.domain.backoffice.product.Product
import com.pl.sggw.ecommers.domain.backoffice.product.ProductRepository
import com.pl.sggw.ecommers.jooq.tables.references.PRODUCT
import org.jooq.DSLContext
import org.jooq.impl.DSL.max
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.time.OffsetDateTime


@Repository
@Transactional
class JooqProductRepository(private val ctx: DSLContext) : ProductRepository {
    override fun addProduct(product: Product) {
        ctx.insertInto(PRODUCT)
            .columns(
                PRODUCT.NAME,
                PRODUCT.DESCRIPTION,
                PRODUCT.CATEGORY_ID,
                PRODUCT.SALE_PRICE,
                PRODUCT.PROMOTIONAL_PRICE,
                PRODUCT.QUANTITY,
                PRODUCT.CREATION_TIMESTAMP,
                PRODUCT.MODIFICATION_TIMESTAMP
            )
            .values(
                product.name,
                product.description,
                product.categoryId,
                product.salePrice,
                product.promotionalPrice,
                product.quantity.toBigDecimal(),
                OffsetDateTime.now().toLocalDateTime(),
                OffsetDateTime.now().toLocalDateTime()
            )
            .execute()

    }

    override fun updateProduct(product: Product) {
        ctx.update(PRODUCT)
            .set(PRODUCT.NAME, product.name)
            .set(PRODUCT.DESCRIPTION, product.description)
            .set(PRODUCT.CATEGORY_ID, product.categoryId)
            .set(PRODUCT.SALE_PRICE, product.salePrice)
            .set(PRODUCT.PROMOTIONAL_PRICE, product.promotionalPrice)
            .set(PRODUCT.QUANTITY, product.quantity.toBigDecimal())
            .set(PRODUCT.MODIFICATION_TIMESTAMP, OffsetDateTime.now().toLocalDateTime())
            .where(PRODUCT.ID.eq(product.productId))
            .execute()
    }

    override fun findProduct(productId: Long): Product? {
        return ctx.select()
            .from(PRODUCT)
            .where(PRODUCT.ID.eq(productId))
            .fetch { r ->
                Product(
                    productId = r.getValue(PRODUCT.ID) as Long,
                    name = r.getValue(PRODUCT.NAME) as String,
                    description = r.getValue(PRODUCT.DESCRIPTION) as String,
                    categoryId = r.getValue(PRODUCT.CATEGORY_ID) as String,
                    salePrice = r.getValue(PRODUCT.SALE_PRICE) as BigDecimal,
                    promotionalPrice = r.getValue(PRODUCT.PROMOTIONAL_PRICE) as BigDecimal,
                    quantity = r.getValue(PRODUCT.QUANTITY) as Int,

                    )
            }
            .firstOrNull()

    }

    //TODO: potencjalnie do usuniecia po integracji z FE
    override fun getNextProductId(): Long {
        return (ctx.select(max(PRODUCT.ID))
            .from(PRODUCT)
            .fetch { r -> r.get(0) as Long }
            .firstOrNull() ?: 0) + 1
    }

    override fun updateStock(productId: Long, quantity: Long) {
        ctx.update(PRODUCT)
            .set(PRODUCT.QUANTITY, PRODUCT.QUANTITY.add(quantity))
            .where(PRODUCT.ID.eq(productId))
            .execute()
    }

    override fun decreaseStock(productId: Long, quantity: Long) {
        ctx.update(PRODUCT)
            .set(PRODUCT.QUANTITY, PRODUCT.QUANTITY.sub(quantity))
            .where(PRODUCT.ID.eq(productId))
            .execute()
    }
}