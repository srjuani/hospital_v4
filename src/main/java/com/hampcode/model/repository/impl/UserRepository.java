package com.hampcode.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import com.hampcode.model.entity.User;
import com.hampcode.model.repository.IUserRepository;

@Named
public class UserRepository implements IUserRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "tallerPU")
	private EntityManager em;

	@Override
	public Long insert(User t) throws Exception {
		em.persist(t);
		return t.getDoctor().getId();
	}

	@Override
	public Long update(User t) throws Exception {
		em.merge(t);
		return t.getDoctor().getId();
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() throws Exception {
		List<User> users = new ArrayList<>();

		Query query = em.createQuery("SELECT c FROM User c");
		users = (List<User>) query.getResultList();

		return users;
	}

	@Override
	public Optional<User> findById(User t) throws Exception {

		User user;
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.id = ?1", User.class);
		query.setParameter(1, t.getDoctor().getId());

		user = query.getSingleResult();

		return Optional.of(user);
	}

	@Override
	public String getPassworHashedByUserName(String username) throws Exception {
		User user = new User();

		try {

			Query query = em.createQuery("FROM User u WHERE u.username = ?1");
			query.setParameter(1, username);

			List<User> lista = query.getResultList();
			if (!lista.isEmpty()) {
				user = lista.get(0);
			}
		} catch (Exception e) {
			throw e;
		}

		return user != null ? user.getPassword() : "";
	}

	@Override
	public Optional<User> findUserByUsername(User user) throws Exception {
		
		User userFound;
		TypedQuery<User> query = em.createQuery("FROM User u WHERE u.username = ?1 and u.password = ?2", User.class);
		query.setParameter(1, user.getUsername());
		query.setParameter(2, user.getPassword());

		userFound = query.getSingleResult();

		return Optional.of(userFound);
	}

}
