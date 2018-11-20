package com.odhill.garbarinoCart.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.odhill.garbarinoCart.dao.ProductInCartDao;
import com.odhill.garbarinoCart.dto.ProductInCartDto;
import com.odhill.garbarinoCart.model.ProductInCart;
import com.odhill.garbarinoCart.model.ProductInCartId;

/**
 * 
 * @author odhill
 *
 */
@Repository
public class ProductInCartDaoImpl extends GenericDaoImpl <ProductInCart, ProductInCartId> implements ProductInCartDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductInCartDto> getProductsByIdCart(Long idCart) {
        return em.createNamedQuery(ProductInCart.QUERY_PRODUCTS_BY_CART_ID).setParameter("idCart", idCart).getResultList();        
	}



}
