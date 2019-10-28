package com.company.shippingcrud.repository;

import com.company.shippingcrud.model.Invoice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        i.setTotalCost(new BigDecimal("5.60"));
        i.setSalesTax(new BigDecimal("0.96"));
        i.setSurcharge(new BigDecimal("3.50"));

        i = repo.save(i);

        assertNotNull(i.getInvoiceId());
    }

    @Test
    void testGetInvoices() {
        Invoice i = new Invoice();
        i.setCustomerId(3);
        i.setShiptoZip("44334");
        i.setPurchaseDate(LocalDate.of(2010, 07, 15));
        i.setTotalCost(new BigDecimal("5.60"));
        i.setSalesTax(new BigDecimal("0.96"));
        i.setSurcharge(new BigDecimal("3.50"));
        i = repo.save(i);

        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice());
        invoices.add(new Invoice());

        repo.saveAll(invoices);

        invoices.add(i);

        List<Invoice> fromRepo = repo.findAll();
        Optional<Invoice> singleFrom = repo.findById(i.getInvoiceId());

        // test get all
        assertEquals(3, fromRepo.size());
        assertEquals(i, fromRepo.get(0));
        // test get by id
        assertTrue(singleFrom.isPresent());
        assertEquals(i, singleFrom.get());
    }

    @Test
    void testGetByCustomer() {
        Invoice i = new Invoice();
        i.setCustomerId(3);
        Invoice i2 = new Invoice();
        i2.setCustomerId(2);
        Invoice i3 = new Invoice();
        i3.setCustomerId(3);
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(i);
        invoices.add(i2);
        invoices.add(i3);
        repo.saveAll(invoices);

        List<Invoice> fromRepo = repo.getInvoicesByCustomerId(3);

        assertEquals(2, fromRepo.size());
    }
}