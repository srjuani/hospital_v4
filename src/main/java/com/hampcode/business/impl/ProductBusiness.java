package com.hampcode.business.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.business.IProductBusiness;
import com.hampcode.dto.ReportProductSupplierDto;
import com.hampcode.model.entity.Product;
import com.hampcode.model.repository.IProductRepository;

@Named
public class ProductBusiness implements IProductBusiness, Serializable {

	private static final long serialVersionUID = -5154926924300500747L;
	
	@Inject
	private IProductRepository productRepository;

	@Transactional
	@Override
	public Long insert(Product entity) throws Exception {
		return productRepository.insert(entity);
	}

	@Transactional
	@Override
	public Long update(Product entity) throws Exception {
		return productRepository.update(entity);
	}

	@Transactional
	@Override
	public List<Product> getAll() throws Exception {
		return productRepository.findAll();
	}

	@Transactional
	@Override
	public Optional<Product> getOne(Product entity) throws Exception {
		return productRepository.findById(entity);
	}

	@Override
	public List<Product> getByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.findByName(name);
	}

	@Override
	public List<ReportProductSupplierDto> reportProductForSupplier() throws Exception {
		return productRepository.reportProductForSupplier();
	}

}
