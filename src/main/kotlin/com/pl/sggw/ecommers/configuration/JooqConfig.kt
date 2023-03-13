package com.pl.sggw.tinder.configuration

import com.zaxxer.hikari.HikariDataSource
import org.jooq.SQLDialect
import org.jooq.impl.DataSourceConnectionProvider
import org.jooq.impl.DefaultDSLContext
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.metadata.HikariDataSourcePoolMetadata
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy
import javax.sql.DataSource


@Configuration
class JooqConfig {

    @Bean
    @ConfigurationProperties("spring.datasource")
    fun dataSource(): DataSource{
        return HikariDataSource()
    }

    @Bean
    fun jdbcTemplate(dataSource: DataSource) : JdbcTemplate {
        return JdbcTemplate(dataSource)
    }

    @Bean
    fun dataSourceTransactionManager(dataSource: DataSource): DataSourceTransactionManager{
        return DataSourceTransactionManager(dataSource)
    }

    @Bean
    fun transactionAwareDataSourceProxy(dataSource: DataSource): TransactionAwareDataSourceProxy{
        return TransactionAwareDataSourceProxy(dataSource)
    }

    @Bean
    fun dataSourceConnectionProvider(transactionAwareDataSourceProxy: TransactionAwareDataSourceProxy): DataSourceConnectionProvider{
        return DataSourceConnectionProvider(transactionAwareDataSourceProxy)
    }

    @Bean
    fun dslContext(dataSourceConnectionProvider :DataSourceConnectionProvider): DefaultDSLContext{
        return DefaultDSLContext(
            dataSourceConnectionProvider,
            SQLDialect.POSTGRES
        )
    }

}