package com.pl.sggw.ecommers.infrastructure.backoffice.category

import com.pl.sggw.ecommers.domain.backoffice.category.Category
import com.pl.sggw.ecommers.domain.backoffice.category.CategoryRepository
import com.pl.sggw.ecommers.domain.backoffice.category.ProductCategory
import com.pl.sggw.ecommers.jooq.tables.references.CATEGORY
import org.jooq.DSLContext
import java.time.OffsetDateTime
import java.time.ZonedDateTime

class JooqCategoryRepository(private val ctx: DSLContext) : CategoryRepository {
    override fun saveNewCategory(category: Category) {
        ctx.insertInto(CATEGORY)
            .columns(
                CATEGORY.NAME,
                CATEGORY.TREEREPRESENTAION,
                CATEGORY.CREATION_TIMESTAMP,
                CATEGORY.MODIFICATION_TIMESTAMP
            )
            .values(
                category.name,
                category.treeRepresentation.categoryId,
                OffsetDateTime.now().toLocalDateTime(),
                OffsetDateTime.now().toLocalDateTime()
            )
            .execute()
    }

    override fun getAllCategories(): List<Category> {
        return ctx.selectFrom(CATEGORY)
            .fetch { r ->
                Category(
                    name = r.getValue(CATEGORY.NAME) as String,
                    treeRepresentation = ProductCategory.of(r.getValue(CATEGORY.TREEREPRESENTAION) as String),
                    time = r.getValue(CATEGORY.MODIFICATION_TIMESTAMP) as ZonedDateTime
                )
            }.toList()
    }
}