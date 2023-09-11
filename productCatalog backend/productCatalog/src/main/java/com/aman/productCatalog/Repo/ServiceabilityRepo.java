package com.aman.productCatalog.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aman.productCatalog.Entity.Serviceability;

public interface ServiceabilityRepo extends JpaRepository<Serviceability, Integer> {

	
	List<Serviceability> findByIdAndPincodes(int id ,int code);
	
}
