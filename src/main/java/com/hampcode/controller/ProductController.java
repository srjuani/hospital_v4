package com.hampcode.controller;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.hampcode.business.IProductBusiness;
import com.hampcode.business.ISupplierBusiness;

import com.hampcode.model.entity.Product;
import com.hampcode.model.entity.Supplier;
import com.hampcode.util.Message;

@Named
@SessionScoped
public class ProductController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IProductBusiness productBusiness;

	
	@Inject
	private ISupplierBusiness supplierBusiness;

	private List<Product> products;
	private Product product;
	private Product productSelect;

	
	private Supplier supplier;
	private List<Supplier> suppliers;

	@PostConstruct
	public void init() {
		product = new Product();
		products = new ArrayList<>();
		productSelect = new Product();

		
		supplier = new Supplier();
		suppliers = new ArrayList<>();

		this.getAllProducts();
	}

	public void getAllProducts() {
		try {
			products = productBusiness.getAll();
		} catch (Exception e) {
			Message.messageError("Error Product :" + e.getMessage());
		}
	}

	public String newProduct() {
		try {
			this.resetForm();
			
			this.suppliers = supplierBusiness.getAll();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "insert";
	}

	public String saveProduct() {
		String view = "";
		try {

			if (product.getId() != null) {
				
				product.setSupplier(supplier);
				productBusiness.update(product);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {
				
				product.setSupplier(supplier);
				productBusiness.insert(product);
				Message.messageInfo("Registro guardado exitosamente");

			}
			this.getAllProducts();
			this.resetForm();
			view = "list";
		} catch (Exception e) {
			Message.messageError("Error Product :" + e.getMessage());
		}

		return view;
	}

	public String editProduct() {
		String view = "";
		try {
			if (this.productSelect != null) {
				this.suppliers = supplierBusiness.getAll();
				this.product = productSelect;

				view = "/product/update";
			} else {
				Message.messageInfo("Debe seleccionar un producto");
			}
		} catch (Exception e) {
			Message.messageError("Error Product :" + e.getMessage());
		}

		return view;
	}

	public String goListDoctor() {
		this.resetForm();
		return "list";
	}

	public void selectProduct(SelectEvent e) {
		this.productSelect = (Product) e.getObject();
	}

	public void resetForm() {
		this.productSelect = new Product();
		this.product = new Product();
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Product getProductSelect() {
		return productSelect;
	}

	public void setProductSelect(Product productSelect) {
		this.productSelect = productSelect;
	}

	

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

}
