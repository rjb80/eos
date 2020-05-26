package com.tetra.eos.commom.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;




@RestControllerAdvice(basePackages="com.tetra.eos.restcontoller")
public class RestExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);
	
  //@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
	
  @ExceptionHandler(value = Exception.class)
  
  public String handleException(Exception e) {
	  
	  log.debug("RestExceptionHandler");
	  
    return e.getMessage();
  }
}