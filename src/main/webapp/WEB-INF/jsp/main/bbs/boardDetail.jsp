<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>

<body>
<div>

        <div>
            <h2>글쓰기</h2>
            <div>
                <table>
                    <tr>
                        <th>제목</th>
                        <td>${result.title }</td>
                    </tr>
                    <tr>
                        <th>내용</th>
                        <td>
                        <p>
                        ${result.content }
                        </p>
                        </td>
                    </tr>
                    <tr>
                        <th>작성자</th>
                        <td>${result.writer }</td>
                    </tr>
                </table>
                <div>
                    <a href="<c:url value='/board/updateContent${pageMaker.makeQueryPage(result.code, pageMaker.cri.page) }'/>"  >수정</a>
                    <a href="<c:url value='/board/boardList${pageMaker.makeQueryPage(result.code, pageMaker.cri.page) }'/>" >목록</a>
                    <a href='#' onClick='fn_relay()'>답변</a>                    
                </div>
            </div>
        </div>
    </div>
   
    
    
    <div>
<script>
//목록
function fn_cancel(){
    
    var form = document.getElementById("viewForm");
    
    form.action = "<c:url value='/board/boardList${pageMaker.makeQueryPage(result.code, pageMaker.cri.page) }'/>";
    form.submit();
    
}
 
//수정
function fn_update(){
    
    var form = document.getElementById("viewForm");
    
    form.action = "<c:url value='/board/updateContent${pageMaker.makeQueryPage(result.code, pageMaker.cri.page) }'/>";
    
    
    
    
    form.submit();
}
 
//답변
function fn_relay(){
    
    var form = document.getElementById("viewForm");
    
    form.action = "<c:url value='/board/relayForm'/>";
    form.submit();
    
}
</script>
</div>
</body>
</html>
