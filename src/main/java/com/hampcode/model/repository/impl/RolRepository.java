package com.hampcode.model.repository.impl;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hampcode.model.entity.Rol;
import com.hampcode.model.entity.User;
import com.hampcode.model.entity.UserRol;
import com.hampcode.model.repository.IRolRepository;

@Named
public class RolRepository implements IRolRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "tallerPU")
	private EntityManager em;

	@Override
	public Long insert(Rol t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Long update(Rol t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Rol> findAll() throws Exception {
		List<Rol> roles = new ArrayList<>();

		Query q = em.createQuery("SELECT r FROM Rol r");
		roles = (List<Rol>) q.getResultList();
		return roles;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Optional<Rol> findById(Rol t) throws Exception {

		Rol rol=new Rol();
		List<Rol> roles = new ArrayList<>();
		Query query = em.createQuery("FROM Rol r where r.id = ?1");
		query.setParameter(1, t.getId());

		roles = (List<Rol>) query.getResultList();

		if(roles!=null && !roles.isEmpty()) {
			rol=roles.get(0);
		}
		
		
		return Optional.of(rol);
	}

	@Override
	public Integer insertUserRole(List<UserRol> userRoles) throws Exception {
		try {
			
			int[] iarr = { 0 };
			userRoles.forEach(r -> {
				em.persist(r);
				if (iarr[0] % 100 == 0) {
					em.flush();
					em.clear();
				}
				iarr[0]++;
			});						
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

	
	@Override
	public List<UserRol> findUserRolesByUser(User user) throws Exception {
		List<UserRol> userRoles = new ArrayList<UserRol>();

		try {
			Query query = em.createQuery("FROM UserRol ur where ur.user.customer.id =?1");
			query.setParameter(1, user.getDoctor().getId());

			userRoles = (List<UserRol>) query.getResultList();
			
		} catch (Exception e) {
			throw e;
		}
		
		return userRoles;
	}

}

