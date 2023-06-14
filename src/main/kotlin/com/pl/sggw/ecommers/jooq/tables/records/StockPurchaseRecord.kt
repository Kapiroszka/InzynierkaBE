/*
 * This file is generated by jOOQ.
 */
package com.pl.sggw.ecommers.jooq.tables.records


import com.pl.sggw.ecommers.jooq.tables.StockPurchase

import java.math.BigDecimal
import java.time.LocalDateTime

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record5
import org.jooq.Row5
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class StockPurchaseRecord() : UpdatableRecordImpl<StockPurchaseRecord>(StockPurchase.STOCK_PURCHASE), Record5<Long?, Long?, BigDecimal?, BigDecimal?, LocalDateTime?> {

    var id: Long?
        set(value) = set(0, value)
        get() = get(0) as Long?

    var productId: Long?
        set(value) = set(1, value)
        get() = get(1) as Long?

    var quantity: BigDecimal?
        set(value) = set(2, value)
        get() = get(2) as BigDecimal?

    var pricePerItem: BigDecimal?
        set(value) = set(3, value)
        get() = get(3) as BigDecimal?

    var creationTimestamp: LocalDateTime?
        set(value) = set(4, value)
        get() = get(4) as LocalDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Long?> = super.key() as Record1<Long?>

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row5<Long?, Long?, BigDecimal?, BigDecimal?, LocalDateTime?> = super.fieldsRow() as Row5<Long?, Long?, BigDecimal?, BigDecimal?, LocalDateTime?>
    override fun valuesRow(): Row5<Long?, Long?, BigDecimal?, BigDecimal?, LocalDateTime?> = super.valuesRow() as Row5<Long?, Long?, BigDecimal?, BigDecimal?, LocalDateTime?>
    override fun field1(): Field<Long?> = StockPurchase.STOCK_PURCHASE.ID
    override fun field2(): Field<Long?> = StockPurchase.STOCK_PURCHASE.PRODUCT_ID
    override fun field3(): Field<BigDecimal?> = StockPurchase.STOCK_PURCHASE.QUANTITY
    override fun field4(): Field<BigDecimal?> = StockPurchase.STOCK_PURCHASE.PRICE_PER_ITEM
    override fun field5(): Field<LocalDateTime?> = StockPurchase.STOCK_PURCHASE.CREATION_TIMESTAMP
    override fun component1(): Long? = id
    override fun component2(): Long? = productId
    override fun component3(): BigDecimal? = quantity
    override fun component4(): BigDecimal? = pricePerItem
    override fun component5(): LocalDateTime? = creationTimestamp
    override fun value1(): Long? = id
    override fun value2(): Long? = productId
    override fun value3(): BigDecimal? = quantity
    override fun value4(): BigDecimal? = pricePerItem
    override fun value5(): LocalDateTime? = creationTimestamp

    override fun value1(value: Long?): StockPurchaseRecord {
        this.id = value
        return this
    }

    override fun value2(value: Long?): StockPurchaseRecord {
        this.productId = value
        return this
    }

    override fun value3(value: BigDecimal?): StockPurchaseRecord {
        this.quantity = value
        return this
    }

    override fun value4(value: BigDecimal?): StockPurchaseRecord {
        this.pricePerItem = value
        return this
    }

    override fun value5(value: LocalDateTime?): StockPurchaseRecord {
        this.creationTimestamp = value
        return this
    }

    override fun values(value1: Long?, value2: Long?, value3: BigDecimal?, value4: BigDecimal?, value5: LocalDateTime?): StockPurchaseRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        this.value5(value5)
        return this
    }

    /**
     * Create a detached, initialised StockPurchaseRecord
     */
    constructor(id: Long? = null, productId: Long? = null, quantity: BigDecimal? = null, pricePerItem: BigDecimal? = null, creationTimestamp: LocalDateTime? = null): this() {
        this.id = id
        this.productId = productId
        this.quantity = quantity
        this.pricePerItem = pricePerItem
        this.creationTimestamp = creationTimestamp
    }
}
