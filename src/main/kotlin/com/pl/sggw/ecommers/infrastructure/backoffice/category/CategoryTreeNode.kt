package com.pl.sggw.ecommers.infrastructure.backoffice.category

data class CategoryTreeNode(
    val id: String,
    val name: String,
    val parentId : String?,
    val children : MutableList<CategoryTreeNode>
){
    fun findChild(childID : String) : CategoryTreeNode {
        return children.stream().filter { it.id == childID }.findFirst().get()
    }

}

