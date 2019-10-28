package com.company.shippingcrud.controller;

import com.company.shippingcrud.model.InvoiceItem;
import com.company.shippingcrud.repository.InvoiceItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class InvoiceItemController {

    @Autowired
    InvoiceItemRepository repo;

    @PostMapping
    public InvoiceItem createInvoiceItem(InvoiceItem invoiceItem) {
        return repo.save(invoiceItem);
    }

    @GetMapping
    public List<InvoiceItem> getAllInvoiceItems() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<InvoiceItem> getInvoiceItemById(Integer itemId) {
        return repo.findById(itemId);
    }

    @GetMapping("/invoice/{id}")
    public List<InvoiceItem> getItemsByInvoiceId(Integer invoiceId) {
        return repo.getItemsByInvoiceId(invoiceId);
    }

    @PutMapping
    public void updateInvoiceItem(InvoiceItem invoiceItem) {
        repo.save(invoiceItem);
    }

    @DeleteMapping
    public void deleteInvoiceItem(Integer id) {
        repo.deleteById(id);
    }
}
