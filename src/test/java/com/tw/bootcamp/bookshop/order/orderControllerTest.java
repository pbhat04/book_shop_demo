package com.tw.bootcamp.bookshop.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
public class orderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderController orderController;

    @Test
    public void shouldGetAnOrder() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/order")).andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1));

    }

}
