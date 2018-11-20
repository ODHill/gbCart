package com.odhill.garbarinoCart.dao;

import java.util.List;

import com.odhill.garbarinoCart.exception.NotFoundException;
import com.odhill.garbarinoCart.model.Cart;

/**
 * 
 * @author odhill
 *
 */
public interface CartDao extends GenericDao<Cart, Long>{

	/**
	 * Devuelve los ids de los carts en estado READY 
	 * 
	 * @return Devuelve los ids de los carts en estado READY
	 */
    List<Long> getReadyCarts();
    
    /**
     * Devuelve un Cart con el id dado. Tira excepcion en caso que no exista este cart
     * 
     * @param id el id del Cart
     * @return Devuelve un Cart con el id dado. Tira excepcion en caso que no exista este cart
     * @throws NotFoundException
     */
    Cart getCart(Long id) throws NotFoundException;

}
