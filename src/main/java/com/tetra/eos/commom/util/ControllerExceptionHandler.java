package com.tetra.eos.commom.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice(basePackages="com.tetra.eos.controller")
public class ControllerExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public String noLoginException(Exception e, Model model) {
    	
    	log.debug("ControllerExceptionHandler");
    	
        model.addAttribute("errorMessage", e.getMessage());
        return "common/error";
    }
}