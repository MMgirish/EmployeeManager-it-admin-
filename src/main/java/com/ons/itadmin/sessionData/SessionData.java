package com.ons.itadmin.sessionData;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component
public class SessionData {

	private long selectedId;
	private String employeeId;
	private long savedId;
	
	public HttpSession getCurrentSession() {
		FacesContext facesContext= FacesContext.getCurrentInstance();
		HttpSession session=(HttpSession) facesContext.getExternalContext().getSession(false);
		return session;
	}
	
	public HttpSession addToSessionAttribute(HttpSession session, long id) {
		session.setAttribute("id", id);
		System.out.println("stored: "+session.getAttribute("id"));
		return session;
	}
	
	public long getSelectedId() {
		return selectedId;
	}
	public void setSelectedId(long selectedId) {
		this.selectedId = selectedId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public long getSavedId() {
		return savedId;
	}

	public void setSavedId(long savedId) {
		this.savedId = savedId;
	}

}
