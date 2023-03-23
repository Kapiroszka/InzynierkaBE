package com.pl.sggw.ecommers.infrastructure.backoffice.category

data class CategoryTreeNode(
    val id: String,
    val name: String,
    val parentId : String?,
    val children : List<CategoryTreeNode>
)

