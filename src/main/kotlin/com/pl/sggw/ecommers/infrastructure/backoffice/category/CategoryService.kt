package com.pl.sggw.ecommers.infrastructure.backoffice.category

import com.pl.sggw.ecommers.domain.backoffice.category.Category

class CategoryService {
    fun addNewCategory(category: Category): Boolean {
        return false

    }

    fun getCategoryTree(): CategoryTreeNode {
        //getAllCategories
        //sortByDepth
        //add to root or to some of children
        //do it for all records
    }

}
