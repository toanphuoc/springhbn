package com.springhbn.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<E> {

	Serializable save(E entity);
	
	public void saveOrUpdate(E entity);
	
	public void delete(Serializable id);
	
	public void deleteAll();
	
	public List<E> findAll();

	public List<E> findByExample(E example);
	
	public E findById(Serializable id);
	
	public List<E> findByLike(E entity);

	//clear session;
	public void clear();
	
	//flush session;
	public void flush();
}
