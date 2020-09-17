package com.ons.itadmin.managedBean;

import java.util.ArrayList;
import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ons.itadmin.model.Asset;
import com.ons.itadmin.model.User;
import com.ons.itadmin.repository.UserRepository;
import com.ons.itadmin.sessionData.SessionData;

@Component (value = "assetBean")
@ELBeanName (value = "assetBean")
@Scope (value = "request")
public class AssetBean {

	private long id;
	private String assetId;
	private String assetName;
	private String assetType;
	private String assetDesc;
	private String assignedBy;
	private String assignedDate;
	private List<User> list;

	@Autowired
	private SessionData sessionData;

	@Autowired
	private UserRepository repository;

	public String addAsset(AssetBean asset) {
		System.out.println("Inside Add Asset path1");
		User theUser=new User();
		//set user id
		theUser.setId(sessionData.getSelectedId());
		
		List<Asset> assetList=new ArrayList<Asset>();
		Asset theAsset=new Asset();
		theAsset.setAssetId(getAssetId());
		theAsset.setAssetName(getAssetName());
		theAsset.setAssetType(getAssetType());
		theAsset.setAssetDescription(getAssetDesc());
		theAsset.setAssignedBy(sessionData.getCurrentSession().getAttribute("firstName").toString()+" "+sessionData.getCurrentSession().getAttribute("lastName").toString());
		assetList.add(theAsset);
		
		//set user assets
		theUser.setAssets(assetList);
		
		//save user with his asset into db
		try {
			//userService.saveUser(theUser);
			repository.save(theUser);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("User saved........");
		return "assets.xhtml";		
	}
	
	@Transactional
	public List<User> getOneUser() {
		Long id=sessionData.getSelectedId();
		List<User> newList=new ArrayList<User>();
		User theUser=repository.getUserById(id);
		newList.add(theUser);
		list=newList;
		System.out.println("user: "+theUser);
		return newList;		
	}
	
	@Transactional
	public String removeAsset(Asset asset){
		Long id=sessionData.getSelectedId();
		User theUser=repository.getUserById(id);
		for (Asset a : theUser.getAssets()) {
			if(a.getId()==asset.getId()) {
				theUser.getAssets().remove(a);
				System.out.println("asset removed: "+a.getId());
			}
		}
		repository.save(theUser);
		System.out.println("asset from user and saved to db...");
		return "assets.xhtml";
	}
	//getters and setterss.
	public long getId() {
		return id;
	}
	
	
	public void setId(long id) {
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
	
	
	public String getAssetDesc() {
		return assetDesc;
	}
	
	
	public void setAssetDesc(String assetDesc) {
		this.assetDesc = assetDesc;
	}
	
	
	public String getAssignedBy() {
		return assignedBy;
	}
	
	
	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}
	
	
	public String getAssignedDate() {
		return assignedDate;
	}
	
	
	public void setAssignedDate(String assignedDate) {
		this.assignedDate = assignedDate;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}
	

}
