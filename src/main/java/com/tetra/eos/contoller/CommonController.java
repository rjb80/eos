package com.tetra.eos.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tetra.eos.commom.util.NoAuthCheck;


@Controller
public class CommonController {
	
	   @NoAuthCheck
	   @RequestMapping(value="/hellojsp") 
	    public String hellojsp()  throws Exception {
		   
//			String testStr=null;
			
//			String testStr1 = testStr.substring(3);
			
			
			
		   
		   
	        return "common/test";            
	    }


	   
	   @RequestMapping(value= {"/","/index","/home"}) 
	    public String index()  throws Exception {
		   
//			String testStr=null;
			
//			String testStr1 = testStr.substring(3);
			
			
			
		   
		   
	        return "main/index";            
	    }

		

}
