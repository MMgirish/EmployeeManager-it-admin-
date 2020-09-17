package com.ons.itadmin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "asset")
public class Asset {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	private String assetId;
	private String assetName;
	private String assetType;
	private String assetDescription;
	private String assignedBy;
	private long adminID;
	
	//no-arg constructor
	public Asset() {
	}
	
	//parameterized constructor
	public Asset(Long id, String assetID, String assetName, String assetType, String assetDescription, String assignedBy,
			long adminID) {
		super();
		this.id = id;
		this.assetId = assetID;
		this.assetName = assetName;
		this.assetType = assetType;
		this.assetDescription = assetDescription;
		this.assignedBy=assignedBy;
		this.adminID=adminID;
	}
	
	//getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public String getAssetType() {
		return assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	public String getAssetDescription() {
		return assetDescription;
	}
	public void setAssetDescription(String assetDescription) {
		this.assetDescription = assetDescription;
	}

	public String getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}

	public long getAdminID() {
		return adminID;
	}

	public void setAdminID(long adminID) {
		this.adminID = adminID;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
