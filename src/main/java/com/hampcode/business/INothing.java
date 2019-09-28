package com.hampcode.business;

import java.util.List;

public interface INothing<T> {
	Integer insert(T t) throws Exception;

	Integer update(T t) throws Exception;

	Integer delete(T t) throws Exception;

	List<T> findAll() throws Exception;

	T findById(T t) throws Exception;
}
