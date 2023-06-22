package com.pl.sggw.ecommers.infrastructure.backoffice.product

import com.pl.sggw.ecommers.domain.backoffice.product.Product
import com.pl.sggw.ecommers.domain.backoffice.product.Stock
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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

    @PostMapping("/add-stock")
    @ApiOperation("Add new stock")
    fun addStock(@RequestBody stock : Stock): ResponseEntity<Void>{
        productService.addStock(stock)
        return ResponseEntity.ok().build()
    }
    @GetMapping("/{categoryId}")
    @ApiOperation("Get all products from category")
    fun getProductsFromCategory(@PathVariable categoryId: String) : ResponseEntity<List<Product>> {
        return ResponseEntity.ok().body(productService.getProductsFromCategory(categoryId))

    }

}