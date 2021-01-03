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
	      <h1>买家个人信息管理</h1>      
	    </section>
		<!-- Main content -->
	    <section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header">
		              		<h3 class="box-title">买家个人信息修改</h3>
		            	</div>
			            <!-- /.box-header -->
			            <div class="box-body">
					    	<!-- form start -->
					    	<form class="form-horizontal" action="buyermodify.do" method="post">
					    		<div class="form-group">
					    			<label for="inputEmail3" class="col-sm-2 control-label">账号</label>
					                <div class="col-sm-10">
					                	<input type="text" class="form-control" name="id" id="inputEmail3" value="${buyer.buyerId}" readonly>
					                </div>
					    		</div>
					    		<div class="form-group">
				                	<label for="inputEmail3" class="col-sm-2 control-label">昵称</label>
									<div class="col-sm-10">
				                   		<input type="text" class="form-control" name="nickname" value="${buyer.nickname}">
				                	</div>
				                </div>
				                
				                <div class="form-group">
				                	<label for="inputEmail3" class="col-sm-2 control-label">邮箱</label>
									<div class="col-sm-10">
				                   		<input type="text" class="form-control" name="email" value="${buyer.email}">
				                	</div>
				                </div>
				                <div class="form-group">
				                	<label for="inputEmail3" class="col-sm-2 control-label">生日</label>
									<div class="col-sm-10">
				                   		<input type="date" class="form-control" name="birthday" value=<fmt:formatDate value="${buyer.birthday}" pattern="yyyy-MM-dd"/>  >
				                	</div>
				                </div>
				                <div class="form-group">
				                	<label for="inputEmail3" class="col-sm-2 control-label">地址</label>
									<div class="col-sm-10">
				                   		<input type="text" class="form-control" name="address" value="${buyer.address}">
				                	</div>
				                </div>
				                <!-- /.box-body -->
					            <div class="box-footer">
					            	<button type="reset" class="btn btn-default">重置</button>
					                <button type="submit" class="btn btn-info pull-right">修改</button>
					            </div>
					            <!-- /.box-footer -->
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