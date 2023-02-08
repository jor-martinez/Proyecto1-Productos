package com.martinez.app.proyecto1.services;

import java.util.List;

public interface IService<T, S> {
	T create(S s);
	List<T> findAll();
	T findById(Long id);
	void delete(Long id);
}
