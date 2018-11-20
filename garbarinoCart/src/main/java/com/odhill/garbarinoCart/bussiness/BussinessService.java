package com.odhill.garbarinoCart.bussiness;

import com.odhill.garbarinoCart.dto.CartDto;
import com.odhill.garbarinoCart.exception.BussinessException;

/**
 * 
 * @author odhill
 *
 */
public interface BussinessService {

	/**
	 * Crea un cart con los parametros dados.
	 * Devuelve un dto del cart creado
	 * 
	 * @param fullname El nombre completo del cliente
	 * @param email El mail del cliente
	 * @return Devuelve un dto del cart creado
	 * @throws BussinessException
	 */
    CartDto createCart(String fullname, String email) throws BussinessException;

    /**
     * Agrega una cantidad dada de un producto a un carro
     * 
     * @param cartId Id del carro a agregar producto
     * @param productId Id del producto
     * @param quantity La cantidad a agregar
     * @throws BussinessException
     */
    void addProductToCart(Long cartId, Long productId, int quantity) throws BussinessException;

    /**
     * Elimina el producto indicado del carro
     * 
     * @param cartId Id del carro a agregar eliminar producto
     * @param productId Id del producto
     * @throws BussinessException
     */
    void removeProductFromCart(Long cartId, Long productId) throws BussinessException;

    /**
     * Devuelve un dto con los datos de cart indicado
     * 
     * @param id Id del carro
     * @return Devuelve un dto con los datos de cart indicado
     * @throws BussinessException
     */
    CartDto getCartById(Long id) throws BussinessException;

    /**
     *  Confirma la compra cambiandole el estado a READY
     * 
     * @param id Id del carro
     * @throws BussinessException
     */
    void confirmBuy(Long id) throws BussinessException;

}
