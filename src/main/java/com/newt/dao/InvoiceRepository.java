package com.newt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.newt.entity.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {

	public List<Invoice> findAll();
	public Invoice findOne(int id);
	public String delete(int id);
    public <S extends Invoice> List<S> save(Iterable<S> invoice);
    public Invoice getInvoiceDetailsByInvoiceId(int invoiceId);
	public Invoice findByProductId(int id);
}
