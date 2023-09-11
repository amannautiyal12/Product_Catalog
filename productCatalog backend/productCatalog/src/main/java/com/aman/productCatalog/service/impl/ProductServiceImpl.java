package com.aman.productCatalog.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aman.productCatalog.Dto.ProductDto;
import com.aman.productCatalog.Entity.Products;
import com.aman.productCatalog.Repo.ProductRepo;
import com.aman.productCatalog.service.ProductServices;

@Service
public class ProductServiceImpl implements ProductServices{
	
	@Autowired
	private ProductRepo productRepo;

	@Override
	public String addProduct(ProductDto productDto) {
		// TODO Auto-generated method stub
		Products product=new Products(
				productDto.getpID(),
				productDto.getName(),
				productDto.getBrand(),
				productDto.getDescription(),
				productDto.getCode(),
				productDto.getImage(),
				productDto.getPrice()
		);
		
		productRepo.save(product);
		return product.getName();
	}
	
	@Override
	public List<ProductDto> getAllProducts() {
	    // Implementation to fetch all products
		 List<Products> product = productRepo.findAll();
		 List<ProductDto> productDtos = new ArrayList<>();
		 for (Products prod : product) {
	            ProductDto productDto = new ProductDto(
	            	prod.getID(),
	            	prod.getName(),
	            	prod.getBrand(),
	            	prod.getDescription(),
	            	prod.getCode(),
	            	prod.getImage(),
	            	prod.getPrice()
	            );
	            productDtos.add(productDto);
	        }
		 return productDtos;
		 
	}

	

	
}
