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

import com.hampcode.model.entity.Doctor;
import com.hampcode.model.repository.IDoctorRepository;

@Named
public class DoctorRepository implements IDoctorRepository, Serializable {

	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "tallerPU")
	private EntityManager em;

	@Override
	public Long insert(Doctor entity) throws Exception {
		em.persist(entity);
		return entity.getId();
	}

	@Override
	public Long update(Doctor entity) throws Exception {
		em.merge(entity);
		return entity.getId();
	}

	@Override
	public List<Doctor> findAll() throws Exception {
		List<Doctor> doctors = new ArrayList<>();

		Query q = em.createQuery("SELECT d FROM Doctor d");
		doctors = (List<Doctor>) q.getResultList();
		return doctors;
	}

	@Override
	public Optional<Doctor> findById(Doctor entity) throws Exception {
		Doctor doctorFound = new Doctor();

		List<Doctor> doctors = new ArrayList<>();
		Query q = em.createQuery("FROM Doctor d WHERE d.id = ?1");
		q.setParameter(1, entity.getId());

		doctors = (List<Doctor>) q.getResultList();

		if (doctors != null && !doctors.isEmpty()) {
			doctorFound = doctors.get(0);
		}

		return Optional.of(doctorFound);
	}

	@Override
	public List<Doctor> findByName(String name) throws Exception {
		return em.createQuery("from Doctor where name like :name", Doctor.class)
				.setParameter("name", "%" + name + "%").getResultList();
	}

	@Override
	public Optional<Doctor> findByDni(String dni) throws Exception {
		Doctor doctor;
		TypedQuery<Doctor> doctorExist = em.createQuery("SELECT d FROM Doctor d  WHERE d.dni =:dni",
				Doctor.class);
		doctorExist.setParameter("dni", dni);
		doctor = doctorExist.getSingleResult();

		return Optional.of(doctor);
	}

}