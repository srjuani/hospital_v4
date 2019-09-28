package com.hampcode.business;
import java.util.List;

import com.hampcode.model.entity.Rol;
import com.hampcode.model.entity.User;
import com.hampcode.model.entity.UserRol;

public interface IRolBusiness extends IBusiness<Rol> {
	Integer assignRolesToUser(User user, List<Rol> roles) throws Exception;

	List<UserRol> findUserRolesByUser(User user) throws Exception;

}
