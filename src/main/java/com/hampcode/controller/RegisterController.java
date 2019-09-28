package com.hampcode.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.mindrot.jbcrypt.BCrypt;

import com.hampcode.business.impl.DoctorBusiness;
import com.hampcode.business.impl.RolBusiness;

import com.hampcode.model.entity.Doctor;
import com.hampcode.model.entity.Rol;
import com.hampcode.model.entity.User;

@Named
@ViewScoped
public class RegisterController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DoctorBusiness doctorBusiness;

	@Inject
	private RolBusiness rolBusiness;

	private Doctor doctor;
	private User user;

	@PostConstruct
	public void init() {
		this.doctor = new Doctor();
		this.user = new User();
	}

	public String registerUser() {
		String redirect = null;		
		try {
			String password = this.user.getPassword();
			String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
			this.user.setPassword(passwordHash);
			this.user.setState("A");
			this.doctor.setUser(user);
			this.user.setDoctor(doctor);
			this.doctorBusiness.insert(doctor);
			
			List<Rol> roles = new ArrayList<Rol>();
			long TIPO_USUARIO = 1;
			Rol r = new Rol();
			r.setId(TIPO_USUARIO);
			roles.add(r);
			rolBusiness.assignRolesToUser(user, roles);
			redirect = "register?faces-redirect=true";
		}catch(Exception e) {
			
		}

		return redirect;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}

