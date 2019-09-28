package com.hampcode.business;

import java.util.Optional;

import com.hampcode.model.entity.User;

public interface IUserBusiness extends IBusiness<User> {

	Optional<User> authentication(User us) throws Exception;
}