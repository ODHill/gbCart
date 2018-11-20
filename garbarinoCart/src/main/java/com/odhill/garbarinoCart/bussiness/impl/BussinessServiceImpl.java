package com.odhill.garbarinoCart.bussiness.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.odhill.garbarinoCart.bussiness.BussinessService;
import com.odhill.garbarinoCart.dao.CartDao;
import com.odhill.garbarinoCart.dao.ProductDao;
import com.odhill.garbarinoCart.dto.CartDto;
import com.odhill.garbarinoCart.exception.BussinessException;
import com.odhill.garbarinoCart.exception.DaoException;
import com.odhill.garbarinoCart.exception.InvalidAmountOfProductsException;
import com.odhill.garbarinoCart.exception.InvalidCartStateException;
import com.odhill.garbarinoCart.exception.InvalidParameterException;
import com.odhill.garbarinoCart.exception.NotFoundException;
import com.odhill.garbarinoCart.model.Cart;
import com.odhill.garbarinoCart.model.Product;
import com.odhill.garbarinoCart.model.ProductInCart;
import com.odhill.garbarinoCart.model.Status;
import com.odhill.garbarinoCart.util.Utils;

/**
 * 
 * @author odhill
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BussinessServiceImpl implements BussinessService {	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BussinessServiceImpl.class);

	@Autowired
	private CartDao cartDao;

	@Autowired
	private ProductDao productDao;

	/**
	 * Crea un cart con los parametros dados.
	 * Devuelve un dto del cart creado
	 * 
	 * @param fullname El nombre completo del cliente
	 * @param email El mail del cliente
	 * @return Devuelve un dto del cart creado
	 * @throws BussinessException
	 */
	@Override
	public CartDto createCart(String fullName, String email) throws BussinessException {
		LOGGER.info("Generando cart para {}", fullName);
		try {
			if (StringUtils.isNotBlank(fullName) && Utils.validateMail(email)) {

				Cart newCart = new Cart();
				newCart.setCreationDate(new Date());
				newCart.setEmail(email);
				newCart.setFullName(fullName);
				newCart.setTotal(0);
				newCart.setStatus(Status.NEW);
				cartDao.save(newCart);
        
				return Utils.convertToDto(newCart, CartDto.class);
			} else {
				throw new InvalidParameterException("Parametros invalidos");
			}
		} catch	(DaoException  | InvalidParameterException e) {
			LOGGER.error(e.getMessage(), e);
			throw new BussinessException(e.getMessage(), e);
		}

	}


    /**
     * Agrega una cantidad dada de un producto a un carro
     * 
     * @param cartId Id del carro a agregar producto
     * @param productId Id del producto
     * @param quantity La cantidad a agregar
     * @throws BussinessException
     */
	@Override
	public void addProductToCart(Long cartId, Long productId, int quantity) throws BussinessException {
		LOGGER.info("Agregando productId: {} cantidad {} para cartId: {}", productId, quantity, cartId);
		try {			
			validQuantity(quantity);
			
			Cart cart = cartDao.getCart(cartId);			
			validCartState(cart);
			
			Product product = productDao.getProduct(productId);			
			ProductInCart productInCart = cart.containsProduct(product);
	
			if(productInCart != null) {
				productInCart.addItem(); 
			} else {
				productInCart = new ProductInCart();
				productInCart.setCart(cart);
				productInCart.setProduct(product);
				productInCart.setQuantity(quantity);
				productInCart.setUnitPrice(product.getUnitPrice());
				cart.addProduct(productInCart);
			}
			
			cart.calculateTotal();

		} catch (NotFoundException | InvalidCartStateException | InvalidAmountOfProductsException e) {
			LOGGER.error(e.getMessage(), e);
			throw new BussinessException(e.getMessage(), e);
		}


	}

    /**
     * Elimina el producto indicado del carro
     * 
     * @param cartId Id del carro a agregar eliminar producto
     * @param productId Id del producto
     * @throws BussinessException
     */
	@Override
	public void removeProductFromCart(Long cartId, Long productId) throws BussinessException {
		LOGGER.info("Eliminando productId: {} para cartId: {}", productId, cartId);
		try {
			Cart cart = cartDao.getCart(cartId);
			
			validCartState(cart);
			
			Product product = productDao.getProduct(productId);			
			ProductInCart productInCart = cart.containsProduct(product);
			
			if (productInCart != null) {
				cart.getProducts().remove(productInCart);
				cart.calculateTotal();
			}
						
			
		} catch (NotFoundException | InvalidCartStateException e) {
			LOGGER.error(e.getMessage(), e);
			throw new BussinessException(e.getMessage(), e);
		}

	}
	
    /**
     * Devuelve un dto con los datos de cart indicado
     * 
     * @param id Id del carro
     * @return Devuelve un dto con los datos de cart indicado
     * @throws BussinessException
     */
	@Override
	public CartDto getCartById(Long id) throws BussinessException {
		LOGGER.info("Obteniendo datos de cartId: {}", id);
		try {
			Cart cart = cartDao.getCart(id); 

			CartDto cartDto = Utils.convertToDto(cart, CartDto.class);

			return cartDto;
		} catch (NotFoundException e) {
			LOGGER.error(e.getMessage(), e);
			throw new BussinessException(e.getMessage(), e);
		}
	}

    /**
     *  Confirma la compra cambiandole el estado a READY
     * 
     * @param id Id del carro
     * @throws BussinessException
     */
	@Override
	public void confirmBuy(Long id) throws BussinessException {
		LOGGER.info("Confirmando compra para cartId: {}", id);
		try {
			Cart cart = cartDao.getCart(id);
			
			validCartState(cart);
			
			cart.setStatus(Status.READY);
		} catch (NotFoundException | InvalidCartStateException e) {
			LOGGER.error(e.getMessage(), e);
			throw new BussinessException(e.getMessage(), e);
		}	
	}	
	
	private void validCartState(Cart cart) throws InvalidCartStateException {
		if(!cart.getStatus().equals(Status.NEW)) {
			throw new InvalidCartStateException("Status Invalido. Status: " + cart.getStatus());
		}
	}
	
	private void validQuantity(int quantity) throws InvalidAmountOfProductsException {
		if(quantity <= 0) {
			throw new InvalidAmountOfProductsException("La cantidad de productos debe ser superior a 0. Cantidad Ingresada: " + quantity);
		}
	}
}
