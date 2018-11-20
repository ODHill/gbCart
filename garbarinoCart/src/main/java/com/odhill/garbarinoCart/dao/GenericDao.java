package com.odhill.garbarinoCart.dao;

import javax.persistence.LockModeType;

import com.odhill.garbarinoCart.exception.DaoException;

/**
 * 
 * @author odhill
 *
 * @param <T>
 */
public interface GenericDao<T, E> {
	
	@SuppressWarnings("hiding")
	<E> T find(E obj);
	
	@SuppressWarnings("hiding")
	<E> T find(E obj,LockModeType lockMode);
		
	void save(T obj) throws DaoException;	
	
	void remove(T obj);
	
	T merge(T obj);
	
	@SuppressWarnings("hiding")
	<E> T getReference(E obj);

}
