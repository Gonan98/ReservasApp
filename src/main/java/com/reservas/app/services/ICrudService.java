package com.reservas.app.services;

import java.util.List;
import java.util.Optional;

public interface ICrudService<T> {

	public T save(T t) throws Exception;
	public void deleteById(int id) throws Exception;
	public Optional<T> findById(int id) throws Exception;
	public List<T> findAll() throws Exception;
	
}
