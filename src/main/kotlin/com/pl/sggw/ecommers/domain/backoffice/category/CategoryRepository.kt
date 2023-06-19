package com.pl.sggw.ecommers.domain.backoffice.category

interface CategoryRepository {
    fun saveNewCategory(category: Category)
    fun getAllCategories():List<Category>
}