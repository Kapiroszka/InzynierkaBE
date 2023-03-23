package com.pl.sggw.ecommers.infrastructure.backoffice.category.api

import com.pl.sggw.ecommers.domain.backoffice.category.Category
import com.pl.sggw.ecommers.domain.backoffice.category.ProductCategory
import com.pl.sggw.ecommers.infrastructure.backoffice.category.CategoryService
import com.pl.sggw.ecommers.infrastructure.backoffice.category.CategoryTreeNode
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.OffsetDateTime
import java.time.OffsetTime

@Api(value = "add-user", description = "Rest api for category managing")
@RequestMapping("/api/category")
@RestController
class CategoryController(val categoryService: CategoryService) {

    @PostMapping("/")
    @ApiOperation("Add new category")
    fun addCategory(@RequestBody categoryRequest: CategoryRequest): ResponseEntity<Void> {
        return if (categoryService.addNewCategory(
                Category(
                    name = categoryRequest.categoryName,
                    treeRepresentation = ProductCategory.of(categoryRequest.categoryId),
                    time = OffsetDateTime.now().toZonedDateTime()
                )
            )
        ) {
            ResponseEntity.ok().build()
        } else {
            ResponseEntity(HttpStatus.CONFLICT)
        }
    }
    @GetMapping("/")
    fun getCategoryTree() : CategoryTreeNode{
        return categoryService.getCategoryTree()
    }

}