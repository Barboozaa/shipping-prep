package com.company.shippingcrud.repository;

import com.company.shippingcrud.model.Invoice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InvoiceRepositoryTest {

    @Autowired
    InvoiceRepository repo;

    @BeforeEach
    void setUp() {
        repo.deleteAll();
    }

    @Test
    void testCreateInvoice() {
        Invoice i = new Invoice();
        i.setCustomerId(3);
        i.setShiptoZip("44334");
        i.setPurchaseDate(LocalDate.of(2010, 07, 15));
        
    }
}