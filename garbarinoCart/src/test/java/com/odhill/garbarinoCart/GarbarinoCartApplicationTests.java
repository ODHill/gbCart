package com.odhill.garbarinoCart;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.odhill.garbarinoCart.bussiness.BussinessService;
import com.odhill.garbarinoCart.dto.CartDto;
import com.odhill.garbarinoCart.exception.BussinessException;
import com.odhill.garbarinoCart.schedule.impl.ProcessCarts;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GarbarinoCartApplicationTests {
	
	@Autowired
	private ApplicationContext ctx;
	
	@Autowired
	private BussinessService bussinessService;

	@Test
	public void noStock() throws  BussinessException {
		CartDto cartDto = bussinessService.createCart("Prueba", "mail@gmail.com");
		bussinessService.addProductToCart(cartDto.getIdCart(), 3L, 3);
		bussinessService.confirmBuy(cartDto.getIdCart());
		ProcessCarts pt = ctx.getBean(ProcessCarts.class, cartDto.getIdCart());
		pt.process();
		cartDto = bussinessService.getCartById(cartDto.getIdCart());
		assertEquals("FAILED", cartDto.getStatus());
	}

	@Test
	public void availableStock() throws  BussinessException {
		CartDto cartDto = bussinessService.createCart("Prueba", "mail@gmail.com");
		bussinessService.addProductToCart(cartDto.getIdCart(), 3L, 1);
		bussinessService.confirmBuy(cartDto.getIdCart());
		ProcessCarts pt = ctx.getBean(ProcessCarts.class, cartDto.getIdCart());
		pt.process();
		cartDto = bussinessService.getCartById(cartDto.getIdCart());
		assertEquals("PROCESSED", cartDto.getStatus());
	}

}
