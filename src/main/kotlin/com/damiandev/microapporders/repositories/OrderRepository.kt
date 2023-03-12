package com.damiandev.microapporders.repositories

import com.damiandev.microapporders.entity.Order

interface OrderRepository {
    fun addOrder(order: Order): Order?
    fun getAllOrders(): List<Order>
    fun getOrder(id: Long): Order?
    fun getOrderByCustomerId(customerId: Long): List<Order>
    fun deleteById(id: Long)
    fun deleteByIds(ids: List<Long>)
}