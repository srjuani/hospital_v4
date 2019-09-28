package com.hampcode.business;

import java.util.List;

import com.hampcode.dto.ReportProductSupplierDto;
import com.hampcode.model.entity.Product;

public interface IProductBusiness extends IBusiness<Product> {


	 List<Product> getByName(String name) throws Exception;
	 
	 
	 List<ReportProductSupplierDto> reportProductForSupplier() throws Exception;
}
