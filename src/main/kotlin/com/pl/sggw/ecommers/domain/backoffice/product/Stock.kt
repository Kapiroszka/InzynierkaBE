package com.pl.sggw.ecommers.domain.backoffice.product

import java.math.BigDecimal

data class Stock(
    val productId : Long,
    val quantity : Long,
    val pricePerItem : BigDecimal
) 
