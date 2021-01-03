<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setBundle basename="com.city.shop.message.Info"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="./css/style.css">
    <script src="./js/jquery.min.js"></script>
	<script src="./js/common.js"></script>
	<!--背景图片自动更换-->
	<script src="./js/supersized.3.2.7.min.js"></script>
	<script src="./js/supersized-init.js"></script>
	<!--表单验证-->
	<script src="./js/jquery.validate.min.js?var1.14.0"></script>
    <title><fmt:message key="user.login.title"/></title>
</head>
<body>
	<div class="login-container">
		<h1><fmt:message key="user.login.h1"/></h1>
		<div class="connect">
			<p><fmt:message key="user.login.welcome"/></p>
		</div>
		<form method="POST" action="login.do">      
	    	<div>  
	    		<input type="text" name="username" placeholder="<fmt:message key="user.login.username"/>" required value="${cookie.username.value}"/>
			</div>
			<div>
				<input type="password" name="password" placeholder="<fmt:message key="user.login.password"/>" required value="${cookie.password.value}"/>	
			</div>		                                                       
			<div class="yzm">	
				<input name="verifycode" type="text" required placeholder="<fmt:message key="user.login.verifycode"/>">			
				<img src="VerifyCodetologin.do" id="verify" border="0" onclick="change()" style="cursor:pointer;">
			</div>
			<div  class="yonghu">		        
				<input type="radio" name="role" value="1" checked><fmt:message key="user.login.buyer"/>
				<input type="radio" name="role" value="2"><fmt:message key="user.login.seller"/>
				<input type="radio" name="role" value="9"><fmt:message key="user.login.admin"/>
			</div>	
			<div  class="remenber">
				<input type="checkbox" name="remember" ${cookie.checked.value}><fmt:message key="user.login.remember"/>
	        </div>       
	        <button type="submit" id="submit"><fmt:message key="user.login.submit"/></button>	        
	        <h3>${msg}</h3>
		</form>
	    <div>
	    	<a href="toRegisterBuyer.do">
	        	<button type="button" class="register-tis"><fmt:message key="user.login.registerbuyer"/></button>
	        </a>
	    </div>
	    <div>
	    	<a href="toRegisterSeller.do">
	        	<button type="button" class="register-tis"><fmt:message key="user.login.registerseller"/></button>
	        </a>
		</div>  
	</div>
</body>
<script type="text/javascript">  
      function change(){  
          var img =document.getElementById("verify");
          img.src="VerifyCodetologin.do?a="+new Date().getTime();  //
          //缓存问题，例如ie不能换，google能换；ie自作聪明，不就是图片，路径一样，我上次保存了，直接给你
          //加一个永远不重复的参数，Servlet同一个但参数不同他就不敢自作主张，必须问服务器
      }  
    </script>  
</html>