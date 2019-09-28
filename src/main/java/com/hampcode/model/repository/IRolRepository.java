package com.hampcode.model.repository;

import java.util.List;

import com.hampcode.model.entity.Rol;
import com.hampcode.model.entity.User;
import com.hampcode.model.entity.UserRol;

public interface IRolRepository extends IRepository<Rol> {

	Integer insertUserRole(List<UserRol> userRoles) throws Exception;

	List<UserRol> findUserRolesByUser(User user) throws Exception;
}
