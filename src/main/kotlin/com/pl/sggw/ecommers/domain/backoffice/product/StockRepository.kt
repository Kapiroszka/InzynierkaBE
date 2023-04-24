package com.pl.sggw.ecommers.domain.backoffice.product

interface StockRepository {

    fun addStock(stock : Stock)
    fun getAllPurchasesForProduct(productId : Long) : List<Stock>

}
