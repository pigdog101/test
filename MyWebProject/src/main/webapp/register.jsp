<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户注册</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	  <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
	  <script type="text/javascript" src="js/my_js.js"></script>
  </head>
  <body>
  <c:forEach items="${requestScope.errors}" var="error">
  ${error.getDefaultMessage()}
  </c:forEach>
  <input type="button" value="Json" id="testJson"/>
    <form method="post" action="show1">
    	用户名：<input type="text" name="username"><br>
    	密码：<input type="password" name="password"><br>
    	确认密码：<input type="password" name="password2"><br>
    	<input type="submit" value="提交"/>
    	
    </form><br>
    <a href="show2/123/abc">跳转</a>
    <a href="show3">Cookie</a>
    <form action="show4" method="post">
        ID:<input type="text" name="id">
                            用户名：<input type="text" name="username"><br>
    	密码：<input type="password" name="password"><br>
    	<input type="submit" value="tijiao">
    </form>
    <a href="TestModelAndView">MV</a>
    ${requestScope.User.id }
    <a href="TestModelMap">ModelMap</a>
    ${sessionScope.User1.username }
    <br>
    <br>
    <form action="testModelAttribute" method="post">
<!--                             用户名：<input type="text" name="username"><br> -->
<!--     	密码：<input type="password" name="password"><br> -->
    	<input type="submit" value="xiugai">
    </form>
    <a href="viewname">viewname</a>
    <form action="testMyConverse" method="post">
                            用户名：<input type="text" name="userInfo"><br>
    	<input type="submit" value="zhuanhuan">
    </form>
        <form action="testTimeFormat" method="post">
                            用户名：<input type="text" name="birthday"><br>
    	<input type="submit" value="zhuanhuan">
    </form>
    <form action="testUpload" method="post" enctype="multipart/form-data">
        <input type="text" name="desc"/>
        <input type="file" name="file"/>
        <input  type="submit" value="上传"/>
    </form>
    <a href="makesure" >makesure</a>
  </body>
</html>
