package com.hampcode.business.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;

import com.hampcode.business.IUserBusiness;
import com.hampcode.model.entity.User;
import com.hampcode.model.repository.IUserRepository;

@Named
public class UserBusiness implements IUserBusiness, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IUserRepository userRepository;

	@Transactional
	@Override
	public Long insert(User t) throws Exception {
		return userRepository.insert(t);
	}

	@Transactional
	@Override
	public Long update(User t) throws Exception {
		return userRepository.update(t);
	}

	

	@Override
	public List<User> getAll() throws Exception {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getOne(User t) throws Exception {
		return userRepository.findById(t);
	}

	@Override
	public Optional<User> authentication(User user) throws Exception {
		String password = user.getPassword();		
		
		String passwordHash = userRepository.getPassworHashedByUserName(user.getUsername());
		
		if(BCrypt.checkpw(password, passwordHash)) {
			user.setPassword(passwordHash);
			return userRepository.findUserByUsername(user);
		}
		
		return Optional.of(new User());
	}

}
