package com.tetra.eos.user.service;

import java.util.HashMap;
import java.util.List;

import com.tetra.eos.user.model.UserVO;

public interface UserService  {
	List<UserVO> selectLogin(HashMap<String,Object> param);
}
