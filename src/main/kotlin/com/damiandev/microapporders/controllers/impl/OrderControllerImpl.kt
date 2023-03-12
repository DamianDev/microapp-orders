package com.damiandev.microapporders.controllers.impl

import com.damiandev.microapporders.controllers.OrderController
import com.damiandev.microapporders.entity.Order
import com.damiandev.microapporders.services.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/orders")
class OrderControllerImpl @Autowired constructor(private val orderService: OrderService): OrderController {
    @PostMapping("add")
    override fun addOrder(@RequestBody order: Order): ResponseEntity<Order> {
        return ResponseEntity.ok(orderService.addOrder(order))
    }

    @GetMapping("{id}")
    override fun getOrderById(@PathVariable id: Long): ResponseEntity<Order> {
        return ResponseEntity.ok(orderService.getOrderById(id))
    }

    @DeleteMapping("delete/{id}")
    override fun deleteById(@PathVariable id: Long) {
        orderService.deleteById(id)
    }

    @DeleteMapping("delete")
    override fun deleteByIds(@RequestParam ids: List<Long>) {
        orderService.deleteByIds(ids)
    }

    @GetMapping("customer/{customerId}")
    override fun getOrdersByCustomerId(@PathVariable customerId: Long): ResponseEntity<List<Order>> {
        return ResponseEntity.ok(orderService.getOrdersByCustomerId(customerId))
    }

    @GetMapping("all")
    override fun getAllOrders(): ResponseEntity<List<Order>> {
        return ResponseEntity.ok(orderService.getAllOrders())
    }
}