package com.hampcode.controller;


import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hampcode.business.IRolBusiness;
import com.hampcode.model.entity.User;
import com.hampcode.model.entity.UserRol;

@Named
@ViewScoped
public class MasterController implements Serializable {
	
	@Inject
	private IRolBusiness service;

	public void verificarSesion() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			User us = (User) context.getExternalContext().getSessionMap().get("user");
			
			if(us == null) {
				context.getExternalContext().redirect("./../index.xhtml");
			}else {
				//verificacion de roles
				String viewId = context.getViewRoot().getViewId();
				boolean rpta = this.verificarMenu(viewId);
				
				if(!rpta) {
					context.getExternalContext().redirect("./../403.xhtml");
				}
			}			
		} catch (Exception e) {

		}
	}
	
	public boolean verificarMenu(String viewId) throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		User us = (User) context.getExternalContext().getSessionMap().get("user");

		List<UserRol> roles = service.findUserRolesByUser(us);

		String rol = "";
		switch (viewId) {
		case "/medicalconsultation/listmedicalconsultation.xhtml":
			rol = "ADMIN,USER";
			break;
		case "/medicalconsultation/medicalconsultation.xhtml":
			rol = "ADMIN,USER";
			break;
		
		
		default:
			break;
		}

		String arreglo[] = rol.split(",");

		int[] iarr = { 0 };
		roles.forEach(r -> {
			for (String x : arreglo) {
				if (r.getRol().getType().equals(x)) {
					iarr[0]++;
				}
			}
		});

		// System.out.println(iarr[0]);
		if (iarr[0] == 0) {
			return false;
		}
		return true;
	}
	
	public void cerrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
}
