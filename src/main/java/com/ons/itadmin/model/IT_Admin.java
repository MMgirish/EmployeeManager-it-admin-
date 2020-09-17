package com.ons.itadmin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "it_admin")
public class IT_Admin {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	private String admin_firstName;
	private String admin_lastName;
	private String adminUserName;
	private String admin_password;
	
	//no-arg constructor
	public IT_Admin() {
		// TODO Auto-generated constructor stub
	}
	
	//parameterized constructor
	public IT_Admin(long id, String admin_firstName, String admin_lastName, String adminUserName,
			String admin_password) {
		super();
		this.id = id;
		this.admin_firstName = admin_firstName;
		this.admin_lastName = admin_lastName;
		this.adminUserName = adminUserName;
		this.admin_password = admin_password;
	}

	//getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdmin_firstName() {
		return admin_firstName;
	}

	public void setAdmin_firstName(String admin_firstName) {
		this.admin_firstName = admin_firstName;
	}

	public String getAdmin_lastName() {
		return admin_lastName;
	}

	public void setAdmin_lastName(String admin_lastName) {
		this.admin_lastName = admin_lastName;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdmin_userName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

}
