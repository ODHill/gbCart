package com.odhill.garbarinoCart.dao;

import java.util.List;

import com.odhill.garbarinoCart.dto.ProductInCartDto;
import com.odhill.garbarinoCart.model.ProductInCart;
import com.odhill.garbarinoCart.model.ProductInCartId;

/**
 * 
 * @author odhill
 *
 */
public interface ProductInCartDao extends GenericDao<ProductInCart, ProductInCartId> {
	
	/**
	 * Devuelve un DTO con los productInCart buscados por id de Cart
	 * 
	 * @param idCArt el id del Cart
	 * @return Devuelve un DTO con los productInCart buscados por id de Cart
	 */
	List<ProductInCartDto> getProductsByIdCart(Long idCart);


}
