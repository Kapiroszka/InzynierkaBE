package com.pl.sggw.ecommers.domain.backoffice.category

data class ProductCategory(
    val categoryId: String,
    val level: List<Int>
) {
    companion object {
        private const val LEVEL_SEPARATOR = "."

        fun of(categoryId: String) = ProductCategory(
            categoryId = categoryId,
            level = categoryId.split(LEVEL_SEPARATOR).map { it.toInt() }
        )
    }

    fun getAncestorName(levelsFromRoot : Int) : String{
        return level.take(levelsFromRoot).joinToString (separator = ".")
    }

}
