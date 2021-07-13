package com.tw.bootcamp.bookshop.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tw.bootcamp.bookshop.book.Book;
import com.tw.bootcamp.bookshop.user.CreateUserCommand;
import com.tw.bootcamp.bookshop.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
public class orderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @MockBean
    private OrderController orderController;

    @MockBean
    private ObjectMapper objectMapper;

    @Test
    public void shouldGetAnOrder() throws Exception {

        Order order = new Order(1L, User.createFrom(new CreateUserCommand("some-email","password")),
                new Book("some-book","some-author",300));

        when(orderService.create(any(Order.class))).thenReturn(new OrderResponse());
        mockMvc.perform(MockMvcRequestBuilders.post("/order")).andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1));

    }

}
