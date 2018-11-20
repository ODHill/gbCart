package com.odhill.garbarinoCart.schedule.impl;

import java.util.concurrent.Callable;


public class PayCartTask implements Callable<Void> {
    
	private ProcessCarts proccessCarts;
    
    
    public PayCartTask() {}
    
    public PayCartTask(ProcessCarts proccessCarts) {
    	this.proccessCarts = proccessCarts;
    }

    @Override
    public Void call() {
    	proccessCarts.process();
		return null;      	
    }

}
