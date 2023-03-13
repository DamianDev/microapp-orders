package com.damiandev.microapporders.configuration

import com.damiandev.microapporders.entity.Orders
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DatabaseInitializer {

    @Value("\${spring.datasource.url}")
    lateinit var url: String

    @Value("\${spring.datasource.driverClassName}")
    lateinit var driverClassName: String

    @Value("\${spring.datasource.username}")
    lateinit var username: String

    @Value("\${spring.datasource.password}")
    lateinit var password: String

    @Bean
    fun initDatasource() {
        DBContext.init(url, driverClassName, username, password)
    }

    @Bean
    fun initDatabase() {
        transaction(Database.connect(DBContext.dataSource)) {
            SchemaUtils.create(Orders)
        }
    }
}