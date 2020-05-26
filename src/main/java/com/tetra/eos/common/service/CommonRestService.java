package com.tetra.eos.common.service;

import java.util.HashMap;

public interface CommonRestService {
	String selectNow(); 
	
	int insertTbTemp1(HashMap<String,Object> param) ;
	int insertTbTemp2(HashMap<String,Object> param) ;
	
	int insertTbTemp3() ;
	
	int insertTbTemp4() ;	
	
}
