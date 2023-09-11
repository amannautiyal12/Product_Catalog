package com.aman.productCatalog.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.aman.productCatalog.Entity.Products;

@EnableJpaRepositories
@Repository
public interface ProductRepo extends JpaRepository<Products, Integer>{
	
	public List<Products> findByCode(String code);
	public List<Products> findByName(String name);
	public List<Products> findByBrand(String brand);
	public List<Products> findByPriceLessThanEqual(double price);
	
	
	
}
