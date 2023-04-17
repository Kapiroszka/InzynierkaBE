package com.pl.sggw.ecommers.infrastructure.backoffice.product

import com.pl.sggw.ecommers.domain.backoffice.product.Product
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api(value = "product-controller", description = "Rest api for product managing")
@RequestMapping("/api/product")
@RestController
class ProductController(private val productService: ProductService) {

    @PostMapping("/")
    @ApiOperation("Add new product")
    fun upsertProduct(@RequestBody product: Product): ResponseEntity<Void> {
        productService.upsertProduct(product)
        return ResponseEntity.ok().build()
    }

}