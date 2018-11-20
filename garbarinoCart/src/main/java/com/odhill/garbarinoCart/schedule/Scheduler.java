package com.odhill.garbarinoCart.schedule;

/**
 * 
 * @author odhill
 *
 */
public interface Scheduler {
	
	/**
	 * Metodo que se ejecuta cada cierto tiempo para procesar los carts en estado READY
	 * 
	 */
	void proccess();

}
