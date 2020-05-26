<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
    
<!DOCTYPE html>
<html>
    <head>
    </head> 
    <body>
        <!-- content 내용 -->
        <div id="content">
        
        <c:if test="${user == null}">
        
	        <form role="form" method="post" autocomplete="off" action="/login">
	        	<p>
	        	<label for="userId">아이디</label>
	        	<input type="text" id="userId" name="userId" />
	        	</p>
	        	
	        	<p>
	        	<label for="userPw">패스워드</label>
	        	<input type="text" id="userPw" name="userPw" />
	        	</p>
	        	<button type="submit">로그인</button>
	        	        	
	        </form>
        </c:if>

        <c:if test="${user != null}">
        	<p>${user.userName}님 환영합니다.</p>
        </c:if>        
        ${user.userName}님
        ...index
        </div>
    </body>
</html>