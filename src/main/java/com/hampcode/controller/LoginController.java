package com.hampcode.controller;

import java.io.Serializable;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.mindrot.jbcrypt.BCrypt;

import com.hampcode.business.IUserBusiness;
import com.hampcode.model.entity.User;

@Named
@ViewScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IUserBusiness userBusiness;
	
	private User user;

	@PostConstruct
	public void init() {
		this.user = new User();
	}

	public String authentication() {
		String redirect = null;

		try {
			Optional<User> userFound = this.userBusiness.authentication(user);
			
			if (userFound.isPresent() && userFound.get().getState().equalsIgnoreCase("A")) {
				
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", userFound.get());
				redirect = "/medicalconsultation/medicalconsultation?faces-redirect=true";
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales incorrectas"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(BCrypt.hashpw("123", BCrypt.gensalt()));

		return redirect;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
