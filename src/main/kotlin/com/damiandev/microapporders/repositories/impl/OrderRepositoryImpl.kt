package com.damiandev.microapporders.repositories.impl

import com.damiandev.microapporders.configuration.DBContext
import com.damiandev.microapporders.entity.Order
import com.damiandev.microapporders.entity.Orders
import com.damiandev.microapporders.repositories.OrderRepository
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.SqlExpressionBuilder.inList
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryImpl : OrderRepository {
    override fun addOrder(order: Order): Order? {
        val insertStatement = transaction(Database.connect(DBContext.dataSource))
        {
            Orders.insert {
                it[customerId] = order.customerId
                it[date] = order.date
                it[amount] = order.amount
                it[description] = order.description
            }
        }
        return insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToOrder)
    }

    override
    fun getAllOrders(): List<Order> {
        return transaction(Database.connect(DBContext.dataSource))
        {
            Orders.selectAll().map(::resultRowToOrder)
        }
    }

    override fun getOrder(id: Long): Order? {
        return transaction(Database.connect(DBContext.dataSource)) {
            Orders.select { Orders.id eq id }
                    .map(::resultRowToOrder)
                    .singleOrNull()
        }
    }

    override fun getOrderByCustomerId(customerId: Long): List<Order> {
        return transaction(Database.connect(DBContext.dataSource)) {
            Orders.select { Orders.customerId eq customerId }
                    .map(::resultRowToOrder)
        }
    }

    override fun deleteById(id: Long) {
        transaction(Database.connect(DBContext.dataSource)) {
            Orders.deleteWhere { Orders.id eq id }
        }
    }

    override fun deleteByIds(ids: List<Long>) {
        transaction(Database.connect(DBContext.dataSource)) {
            Orders.deleteWhere { id inList ids }
        }
    }

    private fun resultRowToOrder(row: ResultRow) = Order(
            id = row[Orders.id],
            customerId = row[Orders.customerId],
            date = row[Orders.date],
            description = row[Orders.description],
            amount = row[Orders.amount]
    )
}