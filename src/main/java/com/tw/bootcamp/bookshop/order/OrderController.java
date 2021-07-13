package com.tw.bootcamp.bookshop.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @PostMapping("/order")
    public ResponseEntity order(){
        return new ResponseEntity(null, HttpStatus.CREATED);
    }
}
