package com.odhill.garbarinoCart.schedule.impl;

import java.util.List;

import javax.persistence.LockModeType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.odhill.garbarinoCart.dao.CartDao;
import com.odhill.garbarinoCart.dao.ProductDao;
import com.odhill.garbarinoCart.dao.ProductInCartDao;
import com.odhill.garbarinoCart.dto.ProductInCartDto;
import com.odhill.garbarinoCart.exception.NoStockException;
import com.odhill.garbarinoCart.model.Cart;
import com.odhill.garbarinoCart.model.Product;
import com.odhill.garbarinoCart.model.Status;

public class ProcessCarts {

	private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerImpl.class);

	private Long cartId;

	@Autowired
	private CartDao cartDao;

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ProductInCartDao productInCartDao;

	public ProcessCarts(Long cartId) {
		this.cartId = cartId;
	}

	@Transactional(rollbackFor = Exception.class)
	public void process() {

		LOGGER.info("Procesando compra de cartId {}", cartId);
		Cart cart = cartDao.getReference(cartId);

		try {
			
			List<ProductInCartDto> productos = productInCartDao.getProductsByIdCart(cartId);
			
			for (ProductInCartDto productInCartDto : productos) {
				Product product = productDao.find(productInCartDto.getIdProduct(), LockModeType.PESSIMISTIC_WRITE);
				
				LOGGER.info("stock {}, cantidad {} " , product.getStock(), productInCartDto.getQuantity());
				if(productInCartDto.getQuantity() <= product.getStock()) {
					int stock = product.getStock() - productInCartDto.getQuantity(); 
					product.setStock(stock);
				}  else {
					LOGGER.warn("No hay suficiente stock para cumplimentar cartId {}", cart.getIdCart());
					throw new NoStockException("No stock");
				}
			}
			
			cart.setStatus(Status.PROCESSED);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			cart.setStatus(Status.FAILED);
		}

		LOGGER.info("Fin compra de cartId {}, estado final {}", cart.getIdCart(), cart.getStatus());
	}
	
}
