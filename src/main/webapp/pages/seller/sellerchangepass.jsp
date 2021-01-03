<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	      <h1>卖家个人信息管理</h1>      
	    </section>
		<!-- Main content -->
	    <section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header">
		              		<h3 class="box-title">卖家个人密码修改</h3>
		            	</div>
			            <!-- /.box-header -->
			            <div class="box-body">
					    	<!-- form start -->
					    	
					    	<form class="form-horizontal" action="sellerchangepass.do" method="post">
					    		<div class="form-group">
					    			<label for="inputPassword3" class="col-sm-2 control-label">旧密码</label>
					                <div class="col-sm-10">
					                	<input required type="password" class="form-control" name="oldpassword" id="inputPassword3">
					               	</div>
					    		</div>
					    		<div class="form-group">
					    			<label for="inputPassword3" class="col-sm-2 control-label">新密码</label>
					                <div class="col-sm-10">
					                	<input required type="password" class="form-control" name="newpassword" id="inputPassword3">
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