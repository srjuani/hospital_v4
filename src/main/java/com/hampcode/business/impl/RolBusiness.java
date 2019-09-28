package com.hampcode.business.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.hampcode.business.IRolBusiness;
import com.hampcode.model.entity.Rol;
import com.hampcode.model.entity.User;
import com.hampcode.model.entity.UserRol;
import com.hampcode.model.repository.impl.RolRepository;

@Named
public class RolBusiness implements IRolBusiness, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private RolRepository rolRepository;

	@Transactional
	@Override
	public Long insert(Rol t) throws Exception {
		return rolRepository.insert(t);
	}

	@Transactional
	@Override
	public Long update(Rol t) throws Exception {
		return rolRepository.update(t);
	}

	

	@Override
	public List<Rol> getAll() throws Exception {
		return rolRepository.findAll();
	}

	@Override
	public Optional<Rol> getOne(Rol t) throws Exception {
		return rolRepository.findById(t);
	}

	@Transactional
	@Override
	public Integer assignRolesToUser(User user, List<Rol> roles) throws Exception {
		List<UserRol> userRoles = new ArrayList<>();

		roles.forEach(rol -> {
			UserRol userRol = new UserRol();
			userRol.setUser(user);
			userRol.setRol(rol);
			userRoles.add(userRol);
		});

		rolRepository.insertUserRole(userRoles);

		return 1;
	}

	@Override
	public List<UserRol> findUserRolesByUser(User user) throws Exception {
		return rolRepository.findUserRolesByUser(user);
	}

}
