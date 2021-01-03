<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
        	<div class="pull-left image">
         		<img src="/Phoneshop/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        	</div>
			<div class="pull-left info">
	        	<c:if test="${sessionScope.username!=null }"> 
					<p>登录用户:${sessionScope.username}</p>
			        <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
			    </c:if>
			    <c:if test="${sessionScope.username==null }">
			    	<p>登录用户:未登录</p>
			    	<a href="/Phoneshop/user/login.jsp"><i class="fa fa-circle text-success"></i>登录</a>
			    </c:if>
			</div>
		</div>
	<!-- sidebar menu: : style can be found in sidebar.less -->
	<ul class="sidebar-menu">
		<li class="header"><b>功能选择</b></li>
		<!-- 买家页面 -->
		<c:if test="${sessionScope.role==1}"> 
			<li class="treeview">
				<a href="#">
					<i class="fa fa-user"></i> <span>买家个人信息管理</span>
					<span class="pull-right-container">
	              		<i class="fa fa-angle-left pull-right"></i>
	            	</span>
	          	</a>
	          	<ul class="treeview-menu">
	            	<li><a href=/Phoneshop/pages/buyer/tobuyermodify.do><i class="fa fa-circle-o"></i>个人信息</a></li>
	          	</ul>
	          	<ul class="treeview-menu">
	            	<li><a href=/Phoneshop/pages/buyer/tobuyerchangepass.do><i class="fa fa-circle-o"></i>修改密码</a></li>
	          	</ul>
        	</li>
			<li class="treeview">
				<a href="#">
					<i class="fa fa-money"></i> <span>商品列表</span>
					<span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
				<ul class="treeview-menu">
					<li><a href=/Phoneshop/pages/buyer/togoodslist.do><i class="fa fa-circle-o"></i>全部商品</a></li>
				</ul>
				<ul class="treeview-menu">
					<li><a href=/Phoneshop/pages/buyer/toshopcart.do><i class="fa fa-circle-o"></i>我的购物车</a></li>
				</ul>
			</li>
			<li class="treeview">
				<a href="#">
					<i class="fa fa-money"></i> <span>交易管理</span>
					<span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
				<ul class="treeview-menu">
					<li><a href=/Phoneshop/pages/buyer/tobuyerwallet.do><i class="fa fa-circle-o"></i>钱包管理</a></li>
				</ul>
				<ul class="treeview-menu">
					<li><a href=/Phoneshop/pages/buyer/tobuyerrecord.do><i class="fa fa-circle-o"></i>交易记录</a></li>
				</ul>
			</li>
      		<li class="treeview">
          		<a href=/Phoneshop/pages/buyer/tobuyer.do>
            	<i class="fa fa-pie-chart"></i>
					<span>返回主页</span>
            		<span class="pull-right-container">
               			<i class="fa fa-angle-left pull-right"></i>
            		</span>
          		</a>
        	</li>
        </c:if>
       
		<!-- 卖家页面 -->
		<c:if test="${sessionScope.role==2}"> 
			<li class="treeview">
				<a href="#">
					<i class="fa fa-user"></i> <span>卖家个人信息管理</span>
					<span class="pull-right-container">
	              		<i class="fa fa-angle-left pull-right"></i>
	            	</span>
	          	</a>
	          	<ul class="treeview-menu">
	            	<li><a href=/Phoneshop/pages/seller/tosellermodify.do><i class="fa fa-circle-o"></i>个人信息</a></li>
	          	</ul>
	          	<ul class="treeview-menu">
	            	<li><a href=/Phoneshop/pages/seller/tosellerchangepass.do><i class="fa fa-circle-o"></i>修改密码</a></li>
	          	</ul>
        	</li>
        	<c:if test="${seller.power==1 }">
	        	<li class="treeview">
					<a href="#">
						<i class="fa fa-mobile-phone"></i> <span>商品信息管理</span>
						<span class="pull-right-container">
		              		<i class="fa fa-angle-left pull-right"></i>
		            	</span>
		          	</a>
		          	<ul class="treeview-menu">
		            	<li><a href=/Phoneshop/pages/seller/togoodlist.do><i class="fa fa-circle-o"></i>我的商品</a></li>
		          	</ul>
		          	<ul class="treeview-menu">
		            	<li><a href=/Phoneshop/pages/seller/toaddgoods.do><i class="fa fa-circle-o"></i>增加商品</a></li>
		          	</ul>
	        	</li>
	        	<li class="treeview">
					<a href="#">
						<i class="fa fa-money"></i> <span>交易管理</span>
						<span class="pull-right-container">
		              		<i class="fa fa-angle-left pull-right"></i>
		            	</span>
		          	</a>
		          	<ul class="treeview-menu">
		            	<li><a href=/Phoneshop/pages/seller/tosellerwallet.do><i class="fa fa-circle-o"></i>钱包管理</a></li>
		          	</ul>
		          	<ul class="treeview-menu">
		            	<li><a href=/Phoneshop/pages/seller/tosellerrecord.do><i class="fa fa-circle-o"></i>交易记录</a></li>
		          	</ul>
	        	</li>
			</c:if>
      		<li class="treeview">
          		<a href=/Phoneshop/pages/seller/toseller.do>
            	<i class="fa fa-pie-chart"></i>
					<span>返回主页</span>
            		<span class="pull-right-container">
               			<i class="fa fa-angle-left pull-right"></i>
            		</span>
          		</a>
        	</li>
        </c:if>
		<!-- 管理员页面 -->
		<c:if test="${sessionScope.role==9}"> 
			<li class="treeview">
				<a href="#">
					<i class="fa fa-users"></i> <span>卖家管理</span>
					<span class="pull-right-container">
	              		<i class="fa fa-angle-left pull-right"></i>
	            	</span>
	          	</a>
	          	<ul class="treeview-menu">
	            	<li><a href=/Phoneshop/pages/admin/tomanagerseller.do><i class="fa fa-circle-o"></i>卖家审核</a></li>
	          	</ul>
        	</li>
      		<li class="treeview">
          		<a href=/Phoneshop/pages/admin/toadmin.do>
            	<i class="fa fa-pie-chart"></i>
					<span>返回主页</span>
            		<span class="pull-right-container">
               			<i class="fa fa-angle-left pull-right"></i>
            		</span>
          		</a>
        	</li>
        </c:if>
      </ul>
    </section>
    <!-- /.sidebar -->
 </aside>