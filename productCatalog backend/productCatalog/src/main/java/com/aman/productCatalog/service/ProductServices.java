package com.aman.productCatalog.service;

import java.util.List;

import com.aman.productCatalog.Dto.ProductDto;

public interface ProductServices {

	String addProduct(ProductDto productDto);
	List<ProductDto> getAllProducts();

}
