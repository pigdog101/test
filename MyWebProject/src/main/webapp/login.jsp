<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	  <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
	  <script type="text/javascript" src="js/my_js.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%-- ${requestScope.person.name}   --%>
<!-- <br/> -->
<%-- <c:set target="${requestScope.person}" property="name" value="jjj"/> --%>
<%-- ${requestScope.person.name}   --%>
<!-- <br> -->
<%-- <c:out value="${requestScope.person}" default="zs-22"></c:out> --%>
<!-- <br> -->
<%-- <c:out value="${requestScope.perso}" default="zs-22"></c:out> --%>
<form action="ajaxTest" method="post">
手机号码<input type="text" name="pNum"/>
姓名<input type="text" name="pName">
<input type="submit" value="提交">
</form>
<form action="TestModelMap" method="post">
手机号码<input type="text" name="pNum"/>
姓名<input type="text" name="pName">
<input type="submit" value="提交">
</form>
<%-- <c:set var="a" value="b" scope="request"></c:set> --%>
<!-- <br> -->
<%-- <c:out value="${a}"></c:out> --%>
<%-- <c:remove var="a"/> --%>
<!-- <br> -->
<%-- <c:out value="${a}"></c:out> --%>
<%-- <c:out value="${requestScope.list[1].name}"></c:out> --%>
<!-- <br> -->
<%-- <c:choose> --%>
<%--     <c:when test="${requestScope.list[1].name == '学生'}"> --%>
<!--     毛征旺 -->
<%--     </c:when> --%>
<%--     <c:otherwise> --%>
<!--     其他人员 -->
<%--     </c:otherwise> --%>
<%-- </c:choose> --%>
<%-- <c:forEach var="p" items="${requestScope.list}"> --%>
<%-- ${p.name} --%>
<%-- </c:forEach> --%>
</body>
</html>