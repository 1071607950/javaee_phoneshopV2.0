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
    <title><fmt:message key="user.registerseller.title"/></title>
</head>
<body>
	<div class="register-container">
		<h1><fmt:message key="user.registerseller.h1"/></h1>
		<div class="connect">
			<p><fmt:message key="user.registerseller.welcome"/></p>
		</div>  
		<form action="RegisterSeller.do" method="POST">
			<div>
				<input type="hidden" name="role" value="2"/>
				<input type="text" name="username" required id="username" value="${phone}" placeholder="<fmt:message key="user.registerseller.username"/>" autocomplete="off" id="number" class="phone_number">
			</div>		
			<!--  
			<div>
			<input type="text" name="verify" required id="phoneNumber" placeholder="验证码">
	 	    <a href="/shop/SendMsServlet" style="width:100%;" onclick="getMs(this)" >获取验证码</a> 
			</div>
			-->
			<div>
			    <input type="password" id="password" name="password" required class="password"  placeholder="<fmt:message key="user.registerseller.password"/>" oncontextmenu="return false" onpaste="return false" />
			</div>
			<div>
				<input type="password" id="repassword" name="repassword" required class="confirm_password" placeholder="<fmt:message key="user.registerseller.repassword"/>" oncontextmenu="return false" onpaste="return false" />
			</div>
			<div>
				<input type="text" name="shopname" required class="nickname" placeholder="<fmt:message key="user.registerseller.shopname"/>" autocomplete="off"/>		
			</div>
			<div>
			    <input type="text" name="email" required class="email" placeholder="<fmt:message key="user.registerseller.email"/>" oncontextmenu="return false" onpaste="return false" />   
			</div>
			<div>
				<input type="date" name="birthday" required class="birthday" placeholder="<fmt:message key="user.registerseller.birthady"/>"  autocomplete="off">
			</div>
			<button type="submit" id="submit" onclick="zhuce(this.form)"><fmt:message key="user.registerseller.registerseller"/></button>	  
			<h3>${msg}</h3>
		</form>
		<div>
			<a href="tologin.do">
				<button type="button" class="register-tis"><fmt:message key="user.registerseller.login"/></button>
			</a>
		</div>
	</div>
</body>
<script type="text/javascript">
/*
function getMs(othis){
    var username=document.getElementById("username");
    othis.href="/shop/SendMsServlet?type=2&username="+ username.value;
}*/
function zhuce(oForm){
	  var password1=document.getElementById("password");
	  var password2=document.getElementById("repassword");
	  console.log(password2.value)
	  if(password1.value==password2.value&&password1.value!=""){
		  oForm.submit();
	  }else{
		  alert("两次密码不一样！");
		  return;
	  }
}
</script>
</html>