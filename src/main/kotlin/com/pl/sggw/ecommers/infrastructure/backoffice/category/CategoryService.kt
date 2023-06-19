package com.pl.sggw.ecommers.infrastructure.backoffice.category

import com.pl.sggw.ecommers.domain.backoffice.category.Category
import com.pl.sggw.ecommers.domain.backoffice.category.CategoryRepository

class CategoryService(private val categoryRepository: CategoryRepository) {
    fun addNewCategory(category: Category): Boolean {
        categoryRepository.saveNewCategory(category)
        return true
    }

    //TODO: Add cache
    fun getCategoryTree(): CategoryTreeNode {
        var result = CategoryTreeNode("0", "root", null, mutableListOf())
        val categories = categoryRepository.getAllCategories()
            .groupBy { it.treeRepresentation.level.size }
            .toSortedMap()
        categories.forEach { entry ->
            run {
                entry.value.forEach {
                    var subCategory = result
                    for (i in 1..entry.key) {
                        subCategory = subCategory.findChild(it.treeRepresentation.getAncestorName(i))
                    }
                    subCategory.children.add(
                        CategoryTreeNode(
                            it.treeRepresentation.categoryId,
                            it.name,
                            subCategory.id,
                            mutableListOf()
                        )
                    )
                }
            }
        }
        return result
    }

}
