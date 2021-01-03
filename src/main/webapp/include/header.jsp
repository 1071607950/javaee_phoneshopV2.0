<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header class="main-header">
    <!-- Logo -->
    <a href="/Phoneshop/pages/admin/admin.jsp" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>淘淘</b></span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>淘淘手机商城</b></span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->
          <!-- Notifications: style can be found in dropdown.less -->
          
          <!-- Tasks: style can be found in dropdown.less -->
          
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="/Phoneshop/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs">
	              <c:if test="${sessionScope.username!=null }"> 
	             	 <p>${sessionScope.username}</p>
	              </c:if>
	              <c:if test="${sessionScope.username==null }">
	              	<p>未登录</p>
	              </c:if>
              </span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="/Phoneshop/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                <c:if test="${sessionScope.username!=null }"> 
	            	<p>${sessionScope.username}</p>
	            </c:if>
	            <c:if test="${sessionScope.username==null }">
	            	<p>未登录</p>
	            </c:if>
              </li>
              <!-- Menu Body -->
              
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                <c:if test="${sessionScope.role==1}"> 
                  <a href="/Phoneshop/pages/buyer/tobuyerchangepass.do" class="btn btn-default btn-flat">修改密码</a>
                </c:if>
                <c:if test="${sessionScope.role==2}"> 
                  <a href="/Phoneshop/pages/seller/tosellerchangepass.do" class="btn btn-default btn-flat">修改密码</a>
                </c:if>
                <c:if test="${sessionScope.role==9}"> 
                  <a href="#" class="btn btn-default btn-flat">管理员不允许修改密码</a>
                </c:if>
                </div>
                <div class="pull-right">
                  <a href="/Phoneshop/user/loginOut.do" class="btn btn-default btn-flat">注销退出</a>
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->
          <li>
            <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
          </li>
        </ul>
      </div>
    </nav>
  </header>
