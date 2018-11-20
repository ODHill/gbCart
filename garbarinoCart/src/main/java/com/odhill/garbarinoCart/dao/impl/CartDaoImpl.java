package com.odhill.garbarinoCart.dao.impl;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.odhill.garbarinoCart.dao.CartDao;
import com.odhill.garbarinoCart.exception.NotFoundException;
import com.odhill.garbarinoCart.model.Cart;

/**
 * 
 * @author odhill
 *
 */
@Repository
public class CartDaoImpl extends GenericDaoImpl <Cart, Long> implements CartDao {
    

	/**
	 * Devuelve los ids de los carts en estado READY 
	 * 
	 * @return Devuelve los ids de los carts en estado READY
	 */
	@SuppressWarnings("unchecked")
	@Override
    public List<Long> getReadyCarts(){
        return em.createNamedQuery(Cart.QUERY_READY_CARTS).getResultList();        
    }

    /**
     * Devuelve un Cart con el id dado. Tira excepcion en caso que no exista este cart
     * 
     * @param id el id del Cart
     * @return Devuelve un Cart con el id dado. Tira excepcion en caso que no exista este cart
     * @throws NotFoundException
     */
	@Override
	public Cart getCart(Long id) throws NotFoundException {
		
		Cart cart = find(id);
		
		if (cart == null) {
			throw new NotFoundException(MessageFormat.format("No existe cart con id {0}", id)); 
		}
		
		return cart;
	}

}
