package com.aman.productCatalog.Dto;

import java.util.Arrays;

public class ProductDto {

	int pID;
	String name;
	String brand;
	String  description;
	String  code;
	byte [] image;
	double  price;
	
	public ProductDto(int pID, String name, String brand, String description, String code, byte[] image, double price) {
		super();
		this.pID = pID;
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.code = code;
		this.image = image;
		this.price = price;
	}
	
	public ProductDto() { }

	public int getpID() {
		return pID;
	}

	public void setpID(int pID) {
		this.pID = pID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductDto [pID=" + pID + ", name=" + name + ", brand=" + brand + ", description=" + description
				+ ", code=" + code + ", image=" + Arrays.toString(image) + ", price=" + price + "]";
	}
	
	
	
	
	
}
