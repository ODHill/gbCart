package com.odhill.garbarinoCart;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.odhill.garbarinoCart.schedule.impl.ProcessCarts;
/**
 * 
 * @author odhill
 *
 */
@SpringBootApplication
@EnableScheduling
public class GarbarinoCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(GarbarinoCartApplication.class, args);
	}
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public ProcessCarts getProcessCartsPrototype(Long cartId) {
	    return new ProcessCarts(cartId);
	}
}
