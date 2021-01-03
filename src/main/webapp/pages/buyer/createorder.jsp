<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<jsp:include page="/include/head.jsp" />
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
	<jsp:include page="/include/header.jsp"></jsp:include>
  
	<!-- Left side column. contains the logo and sidebar -->
	<jsp:include page="/include/left.jsp"></jsp:include>

 	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
    <!-- Content Header (Page header) -->
	    <section class="content-header">
	      <h1>交易管理</h1>
	    </section>
		<!-- Main content -->
	    <section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header">
		              		<h3 class="box-title">支付订单</h3>
		            	</div>
			            <!-- /.box-header -->
			            <div class="box-body">
					    	<!-- form start -->	
					    	<form class="form-horizontal" action="payorders.do" method="post">
					    		<c:forEach items="${orders}" var="list">
						    		<div class="form-group">
						    			<label for="inputEmail3" class="col-sm-12 control-label" style="text-align:left;">订单号:${list.getOrderid()}</label>
						    		</div>
						    		<div class="form-group">
					                	<label for="inputEmail3" class="col-sm-12 control-label" style="text-align:left;">商品:${list.getGoodid()}</label>
					                </div>
					                <div class="form-group">
					                	<label for="inputEmail3" class="col-sm-12 control-label" style="text-align:left;">数量:${list.getNumber()}</label>
					                </div>
					                <div class="form-group">
					                	<label for="inputEmail3" class="col-sm-12 control-label" style="text-align:left;">时间:${list.getCreatedate()}</label>
					                </div>
					                <div class="form-group">
					                	<label for="inputEmail3" class="col-sm-12 control-label" style="text-align:left;">状态:${list.getStatus()}</label>
					                </div>
					                <div class="form-group">
					                	<label for="inputEmail3" class="col-sm-12 control-label" style="text-align:left;">交易金额:${list.getAllmoney()}</label>
					                </div>
					                <input type="hidden" value="${list.getOrderid()}" name="ordersid"/>
					                <button type="submit" class="btn btn-info">确认支付</button>
					                <a href="toshopcart.do"><button type="button" class="btn btn-default">取消</button></a>
					                <!-- /.box-body -->
						            <!-- /.box-footer -->
					            </c:forEach>
					            ${msg}
					    	</form>
					    	
			            </div>
		        		<!-- /.box-body -->
			        </div>
		        <!-- /.box -->
		        <!-- /.box -->
	        	</div>
	        <!-- /.col -->
			</div>
			<!-- /.row -->
	    </section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
	<jsp:include page="/include/footer.jsp"></jsp:include>

	<!-- Control Sidebar -->
	<jsp:include page="/include/aside.jsp"></jsp:include>
	<!-- /.control-sidebar -->
	<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
	<div class="control-sidebar-bg"></div>
	</div>
<!-- ./wrapper -->
<jsp:include page="/include/script.jsp"></jsp:include>
</body>
</html>