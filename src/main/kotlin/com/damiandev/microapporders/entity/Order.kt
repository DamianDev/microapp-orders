package com.damiandev.microapporders.entity

import org.jetbrains.exposed.sql.Table
import java.math.BigDecimal

data class Order(val id: Long?, val customerId: Long, val date: Long, val amount: BigDecimal, val description: String)

object Orders : Table() {
    val id = long("id").autoIncrement()
    val customerId = long("customerId")
    val date = long("date")
    val amount = decimal("amount", 10, 2)
    val description = varchar("description", 100)

    override val primaryKey = PrimaryKey(id)
}