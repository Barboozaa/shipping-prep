package com.company.shippingcrud.repository;

import com.company.shippingcrud.model.InvoiceItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InvoiceItemRepositoryTest {

    @Autowired
    InvoiceItemRepository repo;

    @BeforeEach
    void setUp() {
        repo.deleteAll();
    }

    @Test
    void createGetItem() {
        InvoiceItem item = new InvoiceItem();
        item.setItemDescription("lorem ipsum");

        item = repo.save(item);

        Optional<InvoiceItem> fromRepo = repo.findById(item.getInvoiceItemId());

        assertNotNull(item.getInvoiceItemId());
        assertTrue(fromRepo.isPresent());
        assertEquals(item, fromRepo.get());
    }

    @Test
    void getAllItems() {
        List<InvoiceItem> items = new ArrayList<>();
        items.add(new InvoiceItem());
        items.add(new InvoiceItem());
        items.add(new InvoiceItem());

        repo.saveAll(items);

        List<InvoiceItem> fromRepo = repo.findAll();

        assertEquals(3, fromRepo.size());
    }

    @Test
    void getItemsByInvoiceId() {
        InvoiceItem i = new InvoiceItem();
        i.setInvoiceId(1);
        repo.save(i);
        InvoiceItem i2 = new InvoiceItem();
        i2.setInvoiceId(2);
        repo.save(i2);
        InvoiceItem i3 = new InvoiceItem();
        i3.setInvoiceId(1);
        repo.save(i3);

        List<InvoiceItem> fromRepo = repo.getItemsByInvoiceId(1);

        assertEquals(2, fromRepo.size());
    }
}