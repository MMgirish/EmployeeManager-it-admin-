package com.ons.itadmin.managedBean;

import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ons.itadmin.model.IT_Admin;
import com.ons.itadmin.repository.IT_Repository;

@Component (value = "loginBean")
@ELBeanName (value = "loginBean")
@Scope (value = "request")
public class LoginBean {
	
	Logger logger= Logger.getLogger(getClass().getName());
	private String username;
	private String password;
	
	@Autowired
	private IT_Repository repository;
	
	//authenticate
	public String authenticateUser() {
		IT_Admin admin= repository.adminUserName(username);
		System.out.println("admin----:"+admin);
		if(username!=null) {
			if(admin.getAdmin_password().equals(this.getPassword())) {
				getCuurentSession().setAttribute("firstName", admin.getAdmin_firstName());
				getCuurentSession().setAttribute("lastName", admin.getAdmin_lastName());
				getCuurentSession().setAttribute("userName", admin.getAdminUserName());
				getCuurentSession().setAttribute("id", admin.getId());
				return "dashboard?faces-redirect=true";
			}
			else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Password Invalid",
						"Username and Password do not match...! Please Enter valid credentials"));
				return "login";
			}
			
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Username And Password",
					"username does not exists.."));
			return "login";
		}
	}
	
	
	//logout
	public String logout() {
		getCuurentSession().invalidate();
		return "login?faces-redirect=true";
	}
	
	//getSession
	public HttpSession getCuurentSession() {
		FacesContext context= FacesContext.getCurrentInstance();
		HttpSession session= (HttpSession) context.getExternalContext().getSession(false);
		return session;
	}

	//getter and setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	
}
