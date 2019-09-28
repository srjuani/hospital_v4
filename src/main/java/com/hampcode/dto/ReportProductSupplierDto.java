package com.hampcode.dto;

import java.io.Serializable;

public class ReportProductSupplierDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String supplier;
	private int quantityproducts;
	private String product;

	public ReportProductSupplierDto() {
		super();
	}

	public ReportProductSupplierDto(String supplier, int quantityproducts, String product) {
		super();
		this.supplier = supplier;
		this.quantityproducts = quantityproducts;
		this.product = product;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}


	public int getQuantityproducts() {
		return quantityproducts;
	}

	public void setQuantityproducts(int quantityproducts) {
		this.quantityproducts = quantityproducts;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

}
