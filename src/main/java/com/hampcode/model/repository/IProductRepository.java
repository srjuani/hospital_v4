package com.hampcode.model.repository;

import java.util.List;

import com.hampcode.dto.ReportProductSupplierDto;
import com.hampcode.model.entity.Product;

public interface IProductRepository extends IRepository<Product> {
	List<Product> findByName(String name);
	
	 List<ReportProductSupplierDto> reportProductForSupplier()throws Exception;
}
