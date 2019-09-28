package com.hampcode.model.repository;


import java.util.Optional;

import com.hampcode.model.entity.User;

public interface IUserRepository extends IRepository<User> {

	String getPassworHashedByUserName(String username) throws Exception;

	Optional<User> findUserByUsername(User user) throws Exception;
}

