package com.tetra.eos.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tetra.eos.mysql.mapper.user.UserMapper;
import com.tetra.eos.user.model.UserVO;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService  {

	@Autowired
	UserMapper userMapper;

	@Override
	public List<UserVO> selectLogin(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		
		List<UserVO> list = new ArrayList<UserVO>();
		
//		try {
			list = userMapper.selectLogin(param);
//		}catch(Exception e) {
			//e.printStackTrace();
			
		//}
		
		return list;
	}
	
	
	
}
