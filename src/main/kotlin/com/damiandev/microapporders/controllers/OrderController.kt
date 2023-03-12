package com.damiandev.microapporders.controllers

import com.damiandev.microapporders.entity.Order
import org.springframework.http.ResponseEntity

interface OrderController {
    fun addOrder(order: Order): ResponseEntity<Order>
    fun getOrderById(id: Long): ResponseEntity<Order>
    fun deleteById(id: Long)
    fun deleteByIds(ids: List<Long>)
    fun getOrdersByCustomerId(customerId: Long): ResponseEntity<List<Order>>
    fun getAllOrders(): ResponseEntity<List<Order>>
}