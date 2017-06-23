<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>书栈注册</title>
	<link rel="stylesheet" href="../css/register.css" type="text/css"></link>
	</head>
	
	<body bgcolor="#CAE8FF">
		<script type="text/javascript">
		
		    // window.onbeforeunload = function(){
 			// return "确定要离开此页面吗？";
 			// }  
 			
		   	function  check(){
		   	
		   	//校验密码
		   	var pwd1 = document.getElementById("pw1").value;
		   	var pwd2 = document.getElementById("pw2").value;
		    if(pwd2!=pwd1){   //这里我只判断是否相等了 没做其他判断
		    	alert("两次输入的密码不一致,请检查！");
		        return false;   //return false是用来阻止表单提交的 
		      }
		    //校验邮箱正确性 		      
		    var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
			var email=document.getElementByName("myEmail").value;
			  
			if(myreg.test(email)){  
 			   return true;
			}else{ 
			   alert('提示\n\n请输入有效的E_mail');
			   myreg.fouce();
 			   return false; 
			}  		      
		   }
		   
		function cfirm(){
		
		    if(confirm("你确定要离开此页面吗？")){
		        location.href="login.jsp";
		     }
		    else{
		      
		    }
		}		   
		   
		</script>
		<center>
			<h1>用户注册</h1><hr><br>
		</center>

		<center>
			<form action="${pageContext.request.contextPath }/servlet/RegisterServlet" method="post">
				<table width="0" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>用户名：</td>
						<td><input type="text" name="username" required  /></td>
					</tr>
					<tr>
						<td>密码： </td>
						<td><input type="password" name="password" id="pw1"required  /></td>
					</tr>

					<tr>
						<td>确认密码：</td>
						<td><input type="password" name="confirmpass" id="pw2"required  /></td>
					</tr>

					<tr>
						<td>电子邮箱：</td>
						<td><input type="text" name="Email" id="myEmail" required  /></td>
					</tr>

					<tr>
						<td>服务协议:</td>
						<td>
							<textarea rows="10" cols="30" >
								这是我们无敌的,你必须服从的条款
							</textarea>
						</td>
					</tr>
					<tr  style="width:200px; height:60px;">
						<td>是否接受协议</td>
						<td><input type="checkbox" name="hope to obey" checked/></td>
					</tr>
					
					<tr>
						<td colspan="2"><input id="sub1" type="submit" value="注册" onClick="return check()"/>
							<input id="sub2" type="button" value="取消" onclick=cfirm() /></td>
					</tr>
				</table>
			</form>
		</center>
	</body>
</html>