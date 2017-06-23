<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    
    <title>书栈,你的图书客栈</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  
  <body>
   主页 <br><hr>
  
  <% String user=(String)session.getAttribute("user"); %>
  <% if (user==null || "".equals(user)){ %>
  	<a href="html/login.jsp">登录</a>
  	<h3>你好，游客</h3>
   <%}else{%>  
   <h2>你好，<%=user%></h2> </br>
   <a href="${pageContext.request.contextPath }/servlet/LogoutServlet">注销</a>
   
  <%}%>
    
  </body>
</html>
