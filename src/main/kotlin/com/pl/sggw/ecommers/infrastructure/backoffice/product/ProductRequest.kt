package com.pl.sggw.ecommers.infrastructure.backoffice.product

import com.pl.sggw.ecommers.domain.backoffice.product.Product
import com.pl.sggw.ecommers.domain.backoffice.product.Stock
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.math.BigDecimal

data class ProductRequest(
    val productId: Long?,
    val name: String,
    val description: String?,
    val categoryId: String,
    val salePrice: BigDecimal,
    val promotionalPrice: BigDecimal?,
    val quantity: Int
)