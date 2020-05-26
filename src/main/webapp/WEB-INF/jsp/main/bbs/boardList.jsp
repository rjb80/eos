<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>


<style>
.abtn {cursor:pointer;}
</style>

</head>
<body>

<div class="container">
    <form id="boardForm" name="boardForm" method="post">
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>날짜</th>
                    <th>조회수</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="result" items="${list }" varStatus="status">
                    <tr>
                        <td><c:out value="${result.code }"/></td>
                        <td><a class="abtn" onClick='fn_view(${result.code},${pageMaker.cri.page})'><c:out value="${result.title }"/></a></td>
                        <td><c:out value="${result.writer }"/></td>
                        <td><c:out value="${result.reg_datetime }"/></td>
                        <td></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        
        <div>
	
 
<ul class="pagination">
  <c:if test="${pageMaker.prev }">
  <li>
      <a href='<c:url value="/board/boardList${pageMaker.makeQueryPage(pageMaker.startPage-1) }"/>'><i class="fa fa-chevron-left"><</i></a>
  </li>
  </c:if> 
  <c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">
  <li>
      <a href='<c:url value="/board/boardList${pageMaker.makeQueryPage(pageNum) }"/>'>${pageNum }</a>
  </li>
  </c:forEach>
  <c:if test="${pageMaker.next && pageMaker.endPage >0 }">
  <li>
      <a href='<c:url value="/board/boardList${pageMaker.makeQueryPage(pageMaker.endPage+1) }"/>'><i class="fa fa-chevron-right">></i></a>
  </li>
  </c:if>
</ul>



        
        
        </div>
        
        
        <div>            
            <a href='#' onClick='fn_write()' class="btn btn-success">글쓰기</a>            
        </div>
    </form>
</div>

<script>
//글쓰기
function fn_write(){
    
    var form = document.getElementById("boardForm");
    
    form.action = "<c:url value='/board/writeForm'/>";
    form.submit();
    
}
 
//글조회
function fn_view(code,page){
    
    
    
    
    var form = document.getElementById("boardForm");
    var url = "<c:url value='/board/viewContent'/>";
    url = url + "?code=" + code + "&page=" + page;
    
    form.action = url;    
    form.submit(); 
}
</script>

</body>
</html>