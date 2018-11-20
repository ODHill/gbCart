package com.odhill.garbarinoCart.restService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.odhill.garbarinoCart.bussiness.BussinessService;
import com.odhill.garbarinoCart.dto.AddProductToCartDto;
import com.odhill.garbarinoCart.dto.CartDto;
import com.odhill.garbarinoCart.dto.GenericResponse;
import com.odhill.garbarinoCart.dto.RequestCart;
import com.odhill.garbarinoCart.exception.BussinessException;

/**
 * @author odhill
 *
 */
@RestController
public class RestService {

	@Autowired
	private BussinessService bussinessService;


	@PostMapping(value="carts", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CartDto> createCart(@RequestBody RequestCart requestCart) throws BussinessException {
		return new ResponseEntity<CartDto>(bussinessService.createCart(requestCart.getFullName(), requestCart.getEmail()), HttpStatus.CREATED);       
	}


	@PostMapping(value="carts/{id}/products", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponse> addProductsToCart(@PathVariable long id, @RequestBody AddProductToCartDto addProductToCartDto) throws BussinessException {
		bussinessService.addProductToCart(id, addProductToCartDto.getId(), addProductToCartDto.getQuantity());
		return new ResponseEntity<GenericResponse>(new GenericResponse("Producto agregado correctamente"), HttpStatus.OK);
	}

	
    @DeleteMapping (value="carts/{cartId}/products/{productId}")
	public ResponseEntity<GenericResponse> removeProductFromCart(@PathVariable Long cartId, @PathVariable Long productId) throws BussinessException {
		bussinessService.removeProductFromCart(cartId,  productId);
		return new ResponseEntity<GenericResponse>(new GenericResponse("Producto eliminado correctamente"), HttpStatus.ACCEPTED);
	}


    @GetMapping(value="carts/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CartDto> getCart(@PathVariable Long id) throws BussinessException {
    	return new ResponseEntity<CartDto>(bussinessService.getCartById(id), HttpStatus.OK);  
	}
    
    @PostMapping(value="carts/{id}/checkout")
    public ResponseEntity<GenericResponse> confirmBuy(@PathVariable Long id) throws BussinessException {
    	bussinessService.confirmBuy(id);
    	return new ResponseEntity<GenericResponse>(new GenericResponse("Carrito en estado READY"), HttpStatus.OK);
    }
    
}
