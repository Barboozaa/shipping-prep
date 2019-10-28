package com.company.shippingcrud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer invoiceId;
    private Integer customerId;
    private String shiptoZip;
    private LocalDate purchaseDate;
    private BigDecimal totalCost;
    private BigDecimal salesTax;
    private BigDecimal surcharge;

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getShiptoZip() {
        return shiptoZip;
    }

    public void setShiptoZip(String shiptoZip) {
        this.shiptoZip = shiptoZip;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public BigDecimal getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(BigDecimal salesTax) {
        this.salesTax = salesTax;
    }

    public BigDecimal getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(BigDecimal surcharge) {
        this.surcharge = surcharge;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return invoiceId.equals(invoice.invoiceId) &&
                customerId.equals(invoice.customerId) &&
                shiptoZip.equals(invoice.shiptoZip) &&
                purchaseDate.equals(invoice.purchaseDate) &&
                totalCost.equals(invoice.totalCost) &&
                salesTax.equals(invoice.salesTax) &&
                surcharge.equals(invoice.surcharge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, customerId, shiptoZip, purchaseDate, totalCost, salesTax, surcharge);
    }
}