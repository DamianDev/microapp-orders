package com.damiandev.microapporders.configuration

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import javax.sql.DataSource


object DBContext {
    lateinit var dataSource: DataSource

    fun init(url: String, driverClassName: String, username: String, password: String) {
        val config = HikariConfig()
        config.jdbcUrl = url
        config.driverClassName = driverClassName
        config.username = username
        config.password = password

        dataSource = HikariDataSource(config)
    }
}