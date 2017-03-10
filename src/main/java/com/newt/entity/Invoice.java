package com.newt.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="invoice")
public class Invoice {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="invoice_Id")
	private int invoiceId;
	private int productId;
	private double discount;

	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	
	public Invoice() {
		super();
	}
	public Invoice(int invoiceId, int productId, double discount) {
		super();
		this.invoiceId = invoiceId;
		this.productId = productId;
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", productId=" + productId + ", discount=" + discount + "]";
	}
}
