package com.odhill.garbarinoCart.schedule.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.odhill.garbarinoCart.dao.CartDao;
import com.odhill.garbarinoCart.schedule.Scheduler;

/**
 * 
 * @author odhill
 *
 */
@Service
public class SchedulerImpl implements Scheduler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerImpl.class);
	
	@Autowired
	private CartDao cartDao;
	
    @Autowired
    private ApplicationContext ctx;
	    
	/**
	 * Metodo que se ejecuta cada cierto tiempo para procesar los carts en estado READY
	 * 
	 */
	@Override
	@Scheduled(cron="0 * * * * *")
	public void proccess() {
		List<Long> carts =  cartDao.getReadyCarts();
		LOGGER.info("***************EJECUTANDO SCHEDULER**************");

        List<PayCartTask> tasks = new ArrayList<>();
 
        
        for (Long cartId : carts) {
        	ProcessCarts pt = ctx.getBean(ProcessCarts.class, cartId);
        	tasks.add(new PayCartTask(pt));
        }
        
        if (!tasks.isEmpty()) {
			ExecutorService executorService = Executors.newCachedThreadPool();
	        try {
				List<Future<Void>> futures = executorService.invokeAll(tasks);

				for (Future<Void> future : futures) {
						try {
							future.get();
						} catch (InterruptedException | ExecutionException ex) {
							LOGGER.error("Error al mientras se procesaba tarea de pagos", ex);
						}
				}
				
				
			} catch (RejectedExecutionException | InterruptedException e) {
				LOGGER.error("Error al ejecutar las tareas de procesamiento de pagos", e);
			}
	       
	         executorService.shutdown();
		
        }
        
        LOGGER.info("******************FIN SCHEDULER******************");
	}
}
