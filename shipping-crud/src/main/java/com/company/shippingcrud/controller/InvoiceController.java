package com.company.shippingcrud.controller;

import com.company.shippingcrud.model.Invoice;
import com.company.shippingcrud.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    InvoiceRepository repo;

    @PostMapping
    public Invoice createInvoice(Invoice invoice) {
        return repo.save(invoice);
    }

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Invoice> getInvoiceById(Integer id) {
        return repo.findById(id);
    }

    @GetMapping("/customer/{id}")
    public List<Invoice> getInvoicesByCustomerId(Integer customerId) {
        return repo.getInvoicesByCustomerId(customerId);
    }

    @PutMapping
    public void updateInvoice(Invoice invoice) {
        repo.save(invoice);
    }

    @DeleteMapping("/{id}")
    public void deleteInvoice(Integer id) {
        repo.deleteById(id);
    }
}
