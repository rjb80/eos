package com.tetra.eos.contoller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.tetra.eos.user.model.UserVO;
import com.tetra.eos.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired 
	UserService userService;

	//어노테이션처리를 이용한 인터셉터처리
	@RequestMapping(value="/login" , method = RequestMethod.GET)
	protected String Loginform(UserVO user,HttpServletRequest req) {
		
		String referrer = req.getHeader("Referer");

		req.getSession().setAttribute("prevPage", referrer);
        
		
		
		return "user/login";
	}
	
	//어노테이션처리를 이용한 인터셉터처리
	@RequestMapping(value="/login" , method = RequestMethod.POST)
	protected RedirectView selectLogin(UserVO user,HttpServletRequest req) {
		

		
		HttpSession session = req.getSession();
		
		String prevPage = (String)session.getAttribute("prevPage");
		
		//session.setAttribute("prevPage", referrer);
		
		
		//String referrer = req.getHeader("Referer");
		
		if(prevPage==null || prevPage.length() <= 0 ) {
			prevPage ="/";
		}
		
		//System.out.println("::::::::::: " + referrer);
		
		//session.setAttribute("prevPage", referrer);
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		map.put("userId",user.getUserId());
		map.put("userPw",user.getUserPw());
		
		
		List<UserVO> login = userService.selectLogin(map);

		 RedirectView redirectView = new RedirectView();
		
		 if(login.size()<= 0) {
			  session.setAttribute("user", null);
		       redirectView.setUrl("/");
			  
			 } else {
			  session.setAttribute("user", login.get(0));
			  session.removeAttribute("prevPage");
  	          redirectView.setUrl(prevPage);
			  
		 }		
		
		
		//return list;
		 //return "redirect:/home";
		 System.out.println(prevPage);
		 
	       return redirectView;		 
		 

		//return "hello world";
	}	

}
