package com.tw.bootcamp.bookshop.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity order(@RequestBody Order order){

        OrderResponse orderResponse = orderService.create(order);
        return new ResponseEntity(new OrderService(),HttpStatus.CREATED);
    }
}
