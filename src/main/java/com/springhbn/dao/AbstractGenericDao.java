package com.springhbn.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractGenericDao<E> implements GenericDAO<E> {

	private Class<E> entityClass;

	@SuppressWarnings("unchecked")
	public AbstractGenericDao() {
		this.entityClass = ((Class<E>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0]);
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public Serializable save(E entity) {
		return this.getSession().save(entity);
	}

	@Override
	public void saveOrUpdate(E entity) {
		getSession().saveOrUpdate(entity);
	}

	@Override
	public void delete(Serializable id) {
		E entity = findById(id);
		getSession().delete(entity);
	}

	@Override
	public void deleteAll() {
		List<E> entities = findAll();
		for(E entity:entities){
			getSession().delete(entity);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> findAll() {
		return getSession().createCriteria(this.entityClass).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> findByExample(E entity) {
		Example example = Example.create(entity);
		return getSession().createCriteria(this.entityClass).add(example).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<E> findByLike(E entity) {
		Example example = Example.create(entity).enableLike();
		return getSession().createCriteria(this.entityClass).add(example).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E findById(Serializable id) {
		return (E) getSession().get(this.entityClass, id);
	}

	@Override
	public void clear() {
		getSession().clear();
	}

	@Override
	public void flush() {
		getSession().flush();
	}
}
