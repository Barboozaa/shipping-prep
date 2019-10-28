package com.company.shippingcrud.controller;

import com.company.shippingcrud.repository.InvoiceRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@WebMvcTest
class InvoiceControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private InvoiceRepository repo;

    private ObjectMapper mapper;

    @BeforeEach
    void setUp() {
    }

    @Test
    void createInvoice() throws Exception {

        String input = "";

        mockMvc.perform(post("/invoice")
            .contentType(MediaType.APPLICATION_JSON)
            .content(input));
    }

    @Test
    void getAllInvoices() {
    }

    @Test
    void getInvoiceById() {
    }

    @Test
    void getInvoicesByCustomerId() {
    }

    @Test
    void updateInvoice() {
    }

    @Test
    void deleteInvoice() {
    }
}