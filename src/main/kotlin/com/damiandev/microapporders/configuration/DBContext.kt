package com.damiandev.microapporders.configuration

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import javax.sql.DataSource


object DBContext {

    var dataSource: DataSource = connect()

    private fun connect(): DataSource{
        val config = HikariConfig()
        config.jdbcUrl = "jdbc:postgresql://localhost:5432/ordersdb"
        config.driverClassName="org.postgresql.Driver"
        config.username = "postgres"
        config.password = "docker"

        return HikariDataSource(config)
    }
}