package com.company.shippingcrud.repository;

import com.company.shippingcrud.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    List<Invoice> getInvoicesByCustomerId(Integer id);
}
