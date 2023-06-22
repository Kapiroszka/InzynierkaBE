package com.pl.sggw.ecommers.infrastructure.backoffice.category

import com.pl.sggw.ecommers.domain.backoffice.category.CategoryRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CategoryConfig {

    @Bean
    fun categoryService(categoryRepository: CategoryRepository): CategoryService {
        return CategoryService(categoryRepository)
    }
}