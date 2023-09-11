package com.aman.productCatalog.userController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aman.productCatalog.Dto.ProductDto;
import com.aman.productCatalog.Entity.Products;
import com.aman.productCatalog.Repo.ProductRepo;
import com.aman.productCatalog.service.ProductServices;

@RestController
@CrossOrigin
@RequestMapping("api/product")
public class ProductController {
	
	@Autowired
	private ProductServices productServices;
	
	@Autowired
	private ProductRepo repo;
	
	@PostMapping(path= "/saveProducts")
	public String addProduct(@RequestBody ProductDto productDto) {
		String id=productServices.addProduct(productDto);
		return id;
	}

	
	@GetMapping(path="/getProducts")
	public List<ProductDto> getAllProducts(){
		return productServices.getAllProducts();
	}

	
	@GetMapping("/id/{id}")
	public Optional<Products> getID(@PathVariable("id") int id)
	{
		return repo.findById(id);

	}
	
	@GetMapping("/code/{code}")
	public List<Products> getCode(@PathVariable("code") String code)
	{
		return repo.findByCode(code);

	}
	
	@GetMapping("/name/{name}")
	public List<Products> getName(@PathVariable("name") String name)
	{
		return repo.findByName(name);

	}
	
	@GetMapping("/brand/{brand}")
	public List<Products> getBrand(@PathVariable("brand") String brand)
	{
		return repo.findByBrand(brand);

	}
	
	@GetMapping("/price/{price}")
	public List<Products> getPrice(@PathVariable("price") double price)
	{
		return repo.findByPriceLessThanEqual(price);

	}
	
	
	
	
	
}
