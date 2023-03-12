package com.damiandev.microapporders.configuration

import com.damiandev.microapporders.entity.Orders
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DatabaseInitializer {
    @Bean
    fun initDatabase() {
        transaction(Database.connect(DBContext.dataSource)) {
            SchemaUtils.create(Orders)
        }
    }
}