package com.aman.productCatalog.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="serviceability")
public class Serviceability {
	
	@Id
	int id;
	@Column(name="pincodes")
	int pincodes;
	@Column(name="pid")
	int pid;
	@Column(name="estimatedays")
	int estimatedays;
	 
	public Serviceability(int id, int pincodes, int pid, int estimatedays) {
		super();
		this.id = id;
		this.pincodes = pincodes;
		this.pid = pid;
		this.estimatedays = estimatedays;
	}
	
	public Serviceability() { }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPincodes() {
		return pincodes;
	}

	public void setPincodes(int pincodes) {
		this.pincodes = pincodes;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getEstimatedays() {
		return estimatedays;
	}

	public void setEstimatedays(int estimatedays) {
		this.estimatedays = estimatedays;
	}

	@Override
	public String toString() {
		return "Serviceability [id=" + id + ", pincodes=" + pincodes + ", pid=" + pid + ", estimatedays=" + estimatedays
				+ "]";
	}
	 
	
	
	
}
