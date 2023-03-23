package com.pl.sggw.ecommers.domain.backoffice.category

import java.time.ZonedDateTime

data class Category(
    val name : String,
    val treeRepresentation : ProductCategory,
    val time : ZonedDateTime
)
