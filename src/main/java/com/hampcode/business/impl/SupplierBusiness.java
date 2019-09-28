package com.hampcode.business.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import com.hampcode.business.ISupplierBusiness;
import com.hampcode.model.entity.Supplier;
import com.hampcode.model.repository.ISupplierRepository;

@Named
public class SupplierBusiness implements ISupplierBusiness, Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ISupplierRepository supplierRepository;

	@Override
	public Long insert(Supplier t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long update(Supplier t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public List<Supplier> getAll() throws Exception {
		return supplierRepository.findAll();
	}

	@Override
	public Optional<Supplier> getOne(Supplier t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
