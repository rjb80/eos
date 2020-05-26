package com.tetra.eos.restcontoller;

//com.tetra.eos.restcontoller.CommonRestController

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tetra.eos.commom.util.NoAuthCheck;
import com.tetra.eos.common.service.CommonRestService;

@RestController
public class CommonRestController {
	
	@Autowired 
	CommonRestService commonRestService;
	
	//@RequestMapping(value="/hello", method = RequestMethod.GET)
	@NoAuthCheck
	@RequestMapping(value="/hello")
	protected String selecttest123()  throws Exception {
		
		String testStr=null;
		
		String testStr1 = testStr.substring(3);
		
		return commonRestService.selectNow();

		//return "hello world";
	}	
	
	@NoAuthCheck
	@RequestMapping(value="/insertTest1")	
	public String insertTest1()   throws Exception {
		
		String result="fail";
		
		HashMap<String, Object> map1= new HashMap<String, Object>();
		map1.put("col1","01");
		map1.put("col2","01");
		
		int ret = commonRestService.insertTbTemp1(map1);
		
		if(ret>0) {
			result = "success";
		}
		
		return result;
		
	}

	@NoAuthCheck
	@RequestMapping(value="/insertTest2")	
	public String insertTest2()   throws Exception {
		
		String result="fail";
		
		HashMap<String, Object> map1= new HashMap<String, Object>();
		map1.put("col1","02");
		map1.put("col2","02");
		
		int ret = commonRestService.insertTbTemp2(map1);
		
		if(ret>0) {
			result = "success";
		}
		
		return result;
		
	}	
	

	@NoAuthCheck
	@RequestMapping(value="/insertTest3")	
	public String insertTest3()   throws Exception {
		
		String result="fail";
		
	
		int ret = commonRestService.insertTbTemp3();
		
		if(ret>0) {
			result = "success";
		}
		
		return result;
		
	}	
		
	@NoAuthCheck
	@RequestMapping(value="/insertTest4")	
	public String insertTest4()   throws Exception {
		
		String result="fail";
		
		for(int i=7;i<12;i++) {
				
			String val = "0" + Integer.toString(i); 
					
				HashMap<String, Object> map1= new HashMap<String, Object>();
				map1.put("col1",val);
				map1.put("col2",val);
				
				int ret = commonRestService.insertTbTemp2(map1);
				
				if(ret>0) {
					result = "success";
				}
				
		}		
		
		return result;
		
	}	
	
	
	@NoAuthCheck
	@RequestMapping(value="/insertTest5")	
	public String insertTest5()   throws Exception {
		
		String result="fail";
		
		for(int i=7;i<12;i++) {
				
			String val = "0" + Integer.toString(i); 
			
			String val1 =  Integer.toString(i);
					
				HashMap<String, Object> map1= new HashMap<String, Object>();
				map1.put("col1",val);
				map1.put("col2",val);
				
				HashMap<String, Object> map2= new HashMap<String, Object>();
				map2.put("col1",val1);
				map2.put("col2",val1);				
				
				int ret1 = commonRestService.insertTbTemp1(map2);	
				
				int ret = commonRestService.insertTbTemp2(map1);
				
							
				
				if(ret + ret1 >0) {
					result = "success";
				}
				
		}		
		
		return result;
		
	}		
		

	@NoAuthCheck
	@RequestMapping(value="/insertTest6")	
	public String insertTest6()   throws Exception {
		String result="fail";
		
		int ret = commonRestService.insertTbTemp4();
		
		if(ret >0) {
			result = "success";
		}		
		
		return result;
	}
	
}
