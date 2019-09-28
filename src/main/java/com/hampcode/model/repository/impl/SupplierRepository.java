package com.hampcode.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hampcode.model.entity.Supplier;

import com.hampcode.model.repository.ISupplierRepository;

@Named
public class SupplierRepository implements ISupplierRepository,Serializable{


	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "tallerPU")
	private EntityManager em;
	
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
	public List<Supplier> findAll() throws Exception {
		List<Supplier> suppliers = new ArrayList<>();

		TypedQuery<Supplier> query = em.createQuery("SELECT s FROM Supplier s",
				Supplier.class);
		suppliers = query.getResultList();
		return suppliers;
	}

	@Override
	public Optional<Supplier> findById(Supplier t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
