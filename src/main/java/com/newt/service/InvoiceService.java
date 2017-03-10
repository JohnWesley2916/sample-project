package com.newt.service;

import java.util.List;

import com.newt.entity.Invoice;
import com.newt.exception.InvoiceException;


public interface InvoiceService {
 public List<Invoice> findAll();
 public Invoice findByInvoiceId(int invoiceId) throws InvoiceException;
 public Invoice addInvoice(Invoice invoice) throws InvoiceException;
 public Invoice updateInvoice(Invoice invoice) throws InvoiceException;
 public String deleteInvoice(int invoiceId) throws InvoiceException;
 public Invoice findByProductId(int id) throws InvoiceException;
}
