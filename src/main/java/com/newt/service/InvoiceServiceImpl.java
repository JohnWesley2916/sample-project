package com.newt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newt.dao.InvoiceRepository;
import com.newt.entity.Invoice;
import com.newt.exception.InvoiceException;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	@Autowired
	InvoiceRepository invoiceRepository;


	public List<Invoice> findAll() {
		return invoiceRepository.findAll();
	}

	public Invoice findByInvoiceId(int invoiceId) throws InvoiceException{
		return invoiceRepository.findOne(invoiceId);
	}

	public Invoice addInvoice(Invoice invoice) throws InvoiceException {
		return invoiceRepository.save(invoice);
	}

	public Invoice updateInvoice(Invoice invoice) throws InvoiceException{
		return invoiceRepository.save(invoice);
	}

	public String deleteInvoice(int invoiceId) throws InvoiceException {
		return invoiceRepository.delete(invoiceId);
	}
	@Override
	public Invoice findByProductId(int id) throws InvoiceException{
		return invoiceRepository.findByProductId(id);
	}

}
