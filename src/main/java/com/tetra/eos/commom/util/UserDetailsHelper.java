package com.tetra.eos.commom.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.tetra.eos.user.model.UserVO;

public class UserDetailsHelper {
	
	public static Object getAuthenticatedUser() {
		return (UserVO)RequestContextHolder.getRequestAttributes().getAttribute("user", RequestAttributes.SCOPE_SESSION)==null ? 
				new UserVO() : (UserVO) RequestContextHolder.getRequestAttributes().getAttribute("user", RequestAttributes.SCOPE_SESSION);

	}	
	
	public static Boolean isAuthenticated() {
		
		if (ObjectUtil.isNull((UserVO) RequestContextHolder.getRequestAttributes().getAttribute("user", RequestAttributes.SCOPE_SESSION))) {
			// log.debug("## authentication object is null!!");
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}	

}
