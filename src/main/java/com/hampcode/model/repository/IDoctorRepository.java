package com.hampcode.model.repository;

import java.util.List;
import java.util.Optional;

import com.hampcode.model.entity.Doctor;

public interface IDoctorRepository extends IRepository<Doctor> {
	List<Doctor> findByName(String name) throws Exception;

	Optional<Doctor> findByDni(String dni) throws Exception;
}
