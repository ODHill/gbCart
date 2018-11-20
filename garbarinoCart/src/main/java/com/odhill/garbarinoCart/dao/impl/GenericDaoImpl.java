package com.odhill.garbarinoCart.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

import com.odhill.garbarinoCart.dao.GenericDao;
import com.odhill.garbarinoCart.exception.DaoException;



/**
 * 
 * @author odhill
 *
 * @param <T>
 */
public abstract class GenericDaoImpl <T, E> implements GenericDao <T, E>{
	
	@PersistenceContext
	protected EntityManager em;
	
	Class<T> clazz;
	
	public GenericDaoImpl() {
		clazz = getType(getClass());
	}

	@SuppressWarnings("unchecked")
	private Class<T> getType(Class<?> clase) {
		Type tipo = clase.getGenericSuperclass();
		if(tipo instanceof ParameterizedType)
			return (Class<T>) ((ParameterizedType)tipo).getActualTypeArguments()[0];
		else
			return getType(clase.getSuperclass());
	}
	
	@SuppressWarnings("hiding")
	public <E> T find(E obj){
		return (T) em.find(clazz, obj);
	}
	
	@SuppressWarnings("hiding")
	public <E> T find(E obj,LockModeType lockMode) {
		return (T) em.find(clazz, obj, lockMode);
	}
	
	public void save(T obj) throws DaoException {
		try {
			em.persist(obj);
		} catch (Exception e) {
			throw new DaoException("Error al guardar", e);
		}
	}
	
	public T merge(T obj) {
		return em.merge(obj);
	}
	
	public void remove(T obj) {
		em.remove(em.merge(obj));
	}

	@SuppressWarnings("hiding")
	public <E> T getReference(E obj){
		return (T) em.getReference(clazz, obj);
	}
}
