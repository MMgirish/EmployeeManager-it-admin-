package com.ons.itadmin.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "user")
public class User {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String employeeId;
	
	@OneToMany (cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Asset> assets;
	
	//no-args constructor
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	//parameterized constructor
	public User(long id, String employeeId, List<Asset> assets) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.assets = assets;
	}

	//getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public List<Asset> getAssets() {
		return assets;
	}

	public void setAssets(List<Asset> assets) {
		this.assets = assets;
	}

}
