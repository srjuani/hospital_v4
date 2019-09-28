package com.hampcode.business;

import java.util.List;
import java.util.Optional;

public interface IBusiness<T> {

	Long insert(T entity) throws Exception;

	Long update(T entity) throws Exception;

	List<T> getAll() throws Exception;

	Optional<T> getOne(T entity) throws Exception;

}
