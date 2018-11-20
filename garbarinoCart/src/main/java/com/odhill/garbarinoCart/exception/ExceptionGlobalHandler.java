package com.odhill.garbarinoCart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * 
 * @author odhill
 *
 */
@ControllerAdvice
public class ExceptionGlobalHandler {
	

    @ExceptionHandler(BussinessException.class)
    public ResponseEntity<?> resourceNotFoundException(BussinessException ex, WebRequest request) {
         ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
