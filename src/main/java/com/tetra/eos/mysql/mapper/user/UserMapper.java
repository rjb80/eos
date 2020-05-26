package com.tetra.eos.mysql.mapper.user;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.tetra.eos.user.model.UserVO;

@Repository
@Mapper 
public interface UserMapper {
		
	//List<UserVO> selectLogin(HashMap<String,Object> param) throws Exception;
	List<UserVO> selectLogin(HashMap<String,Object> param) ;
	
}
