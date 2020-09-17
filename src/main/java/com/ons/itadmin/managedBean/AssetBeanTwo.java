package com.ons.itadmin.managedBean;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ons.itadmin.model.Asset;
import com.ons.itadmin.model.User;
import com.ons.itadmin.repository.UserRepository;
import com.ons.itadmin.sessionData.SessionData;

@Component (value = "assetBeanTwo")
@ELBeanName (value = "assetBeanTwo")
@Scope (value = "request")
public class AssetBeanTwo {

	private long id;
	private String assetId;
	private String assetName;
	private String assetType;
	private String assetDesc;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SessionData sessionData;
	
	@Transactional
	public String addAnotherAsset(AssetBeanTwo asset) {
		//fetch user with selected id
		User user=userRepository.getUserById(sessionData.getSelectedId());
		
		Asset newAsset= new Asset();
		newAsset.setId(getId());
		newAsset.setAssetId(getAssetId());
		newAsset.setAssetName(getAssetName());
		newAsset.setAssetType(getAssetType());
		newAsset.setAssetDescription(getAssetDesc());
		newAsset.setAssignedBy(sessionData.getCurrentSession().getAttribute("firstName").toString()+" "+sessionData.getCurrentSession().getAttribute("lastName").toString());
		
		user.getAssets().add(newAsset);
		
		try {
			userRepository.save(user);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return "assets?faces-redirect=true";
	}
	
	
	//getters and setters
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
	
}
