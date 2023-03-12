package com.damiandev.microapporders.services.impl

import com.damiandev.microapporders.entity.Order
import com.damiandev.microapporders.repositories.OrderRepository
import com.damiandev.microapporders.services.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl @Autowired constructor(private val orderRepository: OrderRepository): OrderService {
    override fun addOrder(order: Order): Order? {
        return orderRepository.addOrder(order)
    }

    override fun getAllOrders(): List<Order> {
        return orderRepository.getAllOrders()
    }

    override fun getOrderById(id: Long): Order? {
        return orderRepository.getOrder(id)
    }

    override fun getOrdersByCustomerId(customerId: Long): List<Order> {
        return orderRepository.getOrderByCustomerId(customerId)
    }

    override fun deleteById(id: Long) {
        orderRepository.deleteById(id)
    }

    override fun deleteByIds(ids: List<Long>) {
        orderRepository.deleteByIds(ids)
    }

}