package com.pl.sggw.ecommers.infrastructure.backoffice.product

import com.pl.sggw.ecommers.domain.backoffice.product.Stock
import com.pl.sggw.ecommers.domain.backoffice.product.StockRepository
import com.pl.sggw.ecommers.jooq.tables.references.STOCK_PURCHASE
import org.jooq.DSLContext
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal

@Repository
@Transactional
class JooqStockRepository(private val ctx: DSLContext) : StockRepository {
    override fun addStock(stock: Stock) {
       ctx.insertInto(STOCK_PURCHASE)
            .columns(
                STOCK_PURCHASE.PRODUCT_ID,
                STOCK_PURCHASE.QUANTITY,
                STOCK_PURCHASE.PRICE_PER_ITEM
            )
            .values(
                stock.productId,
                stock.quantity.toBigDecimal(),
                stock.pricePerItem
            )
           .execute()

    }

    override fun getAllPurchasesForProduct(productId: Long): List<Stock> {
       return ctx.select()
           .from(STOCK_PURCHASE)
           .where(STOCK_PURCHASE.PRODUCT_ID.eq(productId))
           .fetch{
               r ->
               Stock(
                   productId = r.getValue(STOCK_PURCHASE.PRODUCT_ID) as Long,
                   quantity = r.getValue(STOCK_PURCHASE.QUANTITY) as Long,
                   pricePerItem = r.getValue(STOCK_PURCHASE.PRICE_PER_ITEM) as BigDecimal
               )
           }
           .toList()

    }
}