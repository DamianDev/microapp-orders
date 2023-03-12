package com.damiandev.microapporders.services

import com.damiandev.microapporders.entity.Order

interface OrderService {
    fun addOrder(order: Order): Order?
    fun getAllOrders(): List<Order>
    fun getOrderById(id: Long): Order?
    fun getOrdersByCustomerId(customerId: Long): List<Order>
    fun deleteById(id: Long)
    fun deleteByIds(ids: List<Long>)
}