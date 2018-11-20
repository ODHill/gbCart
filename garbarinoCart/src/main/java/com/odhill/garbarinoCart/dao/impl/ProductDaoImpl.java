package com.odhill.garbarinoCart.dao.impl;

import java.text.MessageFormat;

import org.springframework.stereotype.Repository;

import com.odhill.garbarinoCart.dao.ProductDao;
import com.odhill.garbarinoCart.exception.NotFoundException;
import com.odhill.garbarinoCart.model.Product;

/**
 * 
 * @author odhill
 *
 */
@Repository
public class ProductDaoImpl extends GenericDaoImpl <Product, Long> implements ProductDao{

	/**
	 * Devuelve un Product con el id dado. Tira excepcion en caso que no exista
	 * 
	 * @param id el id del Product
	 * @return Devuelve un Product con el id dado. Tira excepcion en caso que no exista
	 * @throws NotFoundException
	 */
	@Override
	public Product getProduct(Long id) throws NotFoundException {

		Product product = find(id);
		
		if (product == null) {
			throw new NotFoundException(MessageFormat.format("No existe product con id {0}", id)); 
		}
		
		return product;
	}

}
