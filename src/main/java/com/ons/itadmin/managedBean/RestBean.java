package com.ons.itadmin.managedBean;

import java.util.ArrayList;
import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ons.itadmin.controller.UserController;
import com.ons.itadmin.model.User;
import com.ons.itadmin.repository.UserRepository;
import com.ons.itadmin.rest.RestUser;
import com.ons.itadmin.sessionData.SessionData;

@Component (value = "restBean")
@ELBeanName (value = "restBean")
@Scope (value = "request")
public class RestBean {
	
	private List<RestUser> userDirectory;
	private User user;
	private long selectedId;

	@Autowired
	private UserController controller;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SessionData sessionData;
	
	public List<RestUser> getAllUsers(){
		userDirectory=new ArrayList<RestUser>();
		userDirectory=controller.getUser();
		System.out.println("data fetched to restBean...."+userDirectory);
		return userDirectory;
	}
	
	//store the selected into session attribute
	public String saveSelectedId(long id) {
		
		sessionData.setSelectedId(id);
		sessionData.addToSessionAttribute(sessionData.getCurrentSession(), id);
		System.out.println("Data stored in selected Id: "+sessionData.getSelectedId());
		User user;
		try {
			user=userRepository.getUserById(id);
		}
		catch (Exception e) {
			System.out.println("Handled: "+e);
			user=null;
		}
		if(user==null) {
			return "add-asset?faces-redirect=true";
		}
		else {
			return "assets?faces-redirect=true";
		}
	}

	//getters and setters
	public List<RestUser> getUserDirectory() {
		return getAllUsers();
	}

	public void setUserDirectory(List<RestUser> userDirectory) {
		this.userDirectory = userDirectory;
	}

	public long getSelectedId() {
		return selectedId;
	}

	public void setSelectedId(long selectedId) {
		this.selectedId = selectedId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
