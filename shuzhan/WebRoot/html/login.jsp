<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<title>书栈登录</title>
		
	<link rel="stylesheet" href="../css/login.css" type="text/css"></link>
	</head>
	
	<body>
	<center>
		<div id="logindiv">
			<h1><a href="../index.jsp" title="BOOKSHOME" tabindex="-1">BOOKSHOME</a></h1>
			<form name="loginform" id="loginform" action="${pageContext.request.contextPath }/servlet/LoginServlet" method="post">
				<p>
					<label for="user_login">Username or Email<br>
					<input type="text" name="log" id="user_login" class="input" value="" size="20" required ></label>
				</p>	
				<p>
					<label for="user_pass">Password<br>
					<input type="password" name="pwd" id="user_pass" class="input" value="" size="20" required></label>
				</p>
				<div class="selectButton">
					<input type="submit" value="登录" id="login">				
				</div>
			</form>
			<p id="nav">
				<a rel="nofollow" href="register.jsp">Register</a> | 	<a href="">Lost your password?</a>
			</p>
		</div>	
	</center>
	</body>
</html>