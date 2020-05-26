package com.tetra.eos.common.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tetra.eos.mysql.mapper.common.CommonMapper;

@Service("CommonRestService")
@Transactional
public class CommonRestServiceImpl implements CommonRestService  {

	@Autowired
	CommonMapper commonMapper;
	
	@Override
	public String selectNow() {
		// TODO Auto-generated method stub
		String nowDt = "";
		
		try {
			HashMap<String,Object> map = commonMapper.selectNow();
			
			nowDt = (String)map.get("nowdt");
			
		}catch(Exception e) {
			e.printStackTrace();	
		}
		
		return nowDt;
	}

	@Override
	public int insertTbTemp1(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		
		int result = commonMapper.insertTbTemp1(param);
		
		return result;
	}

	@Override
	public int insertTbTemp2(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		
		int result = commonMapper.insertTbTemp2(param);
		
		return result;
	}

	@Override
	public int insertTbTemp3() {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> map1= new HashMap<String, Object>();
		HashMap<String, Object> map2= new HashMap<String, Object>();
		
		map1.put("col1","04");
		map1.put("col2","04");
		
		map1.put("col1","004");
		map1.put("col2","004");
		
		int result1 = commonMapper.insertTbTemp1(map1);
		
		int result2 = commonMapper.insertTbTemp2(map2);
		
		return result1 + result2;
	}
	
	
	@Override
	public int insertTbTemp4() {
		// TODO Auto-generated method stub
		int ret1 =0;
		int ret =0;
		
		for(int i=7;i<12;i++) {
			
			String val = "0" + Integer.toString(i); 
			
			String val1 =  Integer.toString(i);
					
				HashMap<String, Object> map1= new HashMap<String, Object>();
				map1.put("col1",val);
				map1.put("col2",val);
				
				HashMap<String, Object> map2= new HashMap<String, Object>();
				map2.put("col1",val1);
				map2.put("col2",val1);				
				
				 ret1 = commonMapper.insertTbTemp1(map2);	
				
				 ret = commonMapper.insertTbTemp2(map1);
				
							
				
//				if(ret + ret1 >0) {
//					result = "success";
				//}
				
		}			
		
		
		return ret1 + ret;
	}	
	
}
