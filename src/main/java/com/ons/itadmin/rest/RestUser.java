package com.ons.itadmin.rest;

public class RestUser {

	private Long id;
	private String userId;
	private String firstName;
	private String lastName;
	private String reportingManager;
	private String username;
	private boolean enabled;
	
	//default constructor
	public RestUser() {
		// TODO Auto-generated constructor stub
	}
	
	//parameterized constructor
	public RestUser(Long id, String employeeId, String firstName, String lastName, String reportingManager,
			String username, boolean enabled) {
		super();
		this.id = id;
		this.userId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.reportingManager = reportingManager;
		this.username = username;
		this.enabled = enabled;
	}
	
	//getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getReportingManager() {
		return reportingManager;
	}
	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
