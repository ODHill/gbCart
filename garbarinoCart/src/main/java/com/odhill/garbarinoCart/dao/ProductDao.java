package com.odhill.garbarinoCart.dao;

import com.odhill.garbarinoCart.exception.NotFoundException;
import com.odhill.garbarinoCart.model.Product;

/**
 * 
 * @author odhill
 *
 */
public interface ProductDao extends GenericDao<Product, Long> {
	
	/**
	 * Devuelve un Product con el id dado. Tira excepcion en caso que no exista
	 * 
	 * @param id el id del Product
	 * @return Devuelve un Product con el id dado. Tira excepcion en caso que no exista
	 * @throws NotFoundException
	 */
	Product getProduct(Long id) throws NotFoundException;


}
