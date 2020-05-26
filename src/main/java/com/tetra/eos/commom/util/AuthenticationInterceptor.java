package com.tetra.eos.commom.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationInterceptor.class);

	
	// preHandle() : 컨트롤러보다 먼저 수행되는 메서드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	        throws Exception {
		
		logger.info("preHandle call......");
		
				if (handler instanceof HandlerMethod) { // HandlerMethod 는 후에 실행할 컨트롤러의 메소드 입니다. 
					// 메소드명, 인스턴스, 타입, 사용된 Annotation 들을 확인할 수 있습니다. 
					HandlerMethod method = (HandlerMethod) handler; 
					logger.info("handler method name : " + method.getMethod().getName());  
					//return true;
				
		
					AuthCheck authCheck = ((HandlerMethod) handler).getMethodAnnotation(AuthCheck.class);
					
					if (authCheck != null) { 
					
						logger.info("auth");					
						
					    // session 객체를 가져옴
					    HttpSession session = request.getSession();
					    // login처리를 담당하는 사용자 정보를 담고 있는 객체를 가져옴
					    Object obj = session.getAttribute("user");
					     
					    if ( obj ==null ){
					        // 로그인이 안되어 있는 상태임으로 로그인 폼으로 다시 돌려보냄(redirect)
					        response.sendRedirect("/login");
					        return false; // 더이상 컨트롤러 요청으로 가지 않도록false로 반환함
					    }
					}else {
						logger.info("no auth");
					}
				}
	     
	    // preHandle의return은 컨트롤러 요청 uri로 가도 되냐 안되냐를 허가하는 의미임
	    // 따라서true로하면 컨트롤러 uri로 가게 됨.
	    return true;
	}
	
	// 컨트롤러가 수행되고 화면이 보여지기 직전에 수행되는 메서드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	        ModelAndView modelAndView) throws Exception {
	    // TODO Auto-generated method stub
	    super.postHandle(request, response, handler, modelAndView);
	}

}
