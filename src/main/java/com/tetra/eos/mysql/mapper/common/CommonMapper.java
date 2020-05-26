package com.tetra.eos.mysql.mapper.common;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//com.tetra.eos.mysql.mapper.common.CommonMapper

@Repository
@Mapper
public interface CommonMapper {
	
	HashMap<String,Object> selectNow() throws Exception;
	
	int insertTbTemp1(HashMap<String,Object> param) ;
	int insertTbTemp2(HashMap<String,Object> param) ;

}
