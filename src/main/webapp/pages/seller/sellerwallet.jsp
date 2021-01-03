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
	      <h1>交易管理</h1>      
	    </section>
		<!-- Main content -->
	    <section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header">
		              		<h3 class="box-title">钱包管理</h3>
		            	</div>
		            	<label for="inputEmail3" class="col-sm-12 ">余额:${seller.wallet}</label>
			            <!-- /.box-header -->
			            <div class="box-body">
					        <form class="form-horizontal" action="sellerwallet.do?type=1" method="post">
								<div class="form-group">
					    			<label for="inputEmail3" class="col-sm-2 control-label">充值</label>
					                <div class="col-sm-10">
					                	<input type="text" required pattern="[0-9]*" title="只能输入数字" class="form-control" name="money" id="inputEmail3" placeholder="充值">
					                </div>
					    		</div>
					    		<!-- /.box-body -->
					            <div class="box-footer">
					            	<button type="reset" class="btn btn-default">重置</button>
					                <button type="submit" class="btn btn-info pull-right">充值</button>
					            </div>
					            <!-- /.box-footer -->
					    	</form>
					    	<form class="form-horizontal" action="sellerwallet.do?type=2" method="post">
								<div class="form-group">
					    			<label for="inputEmail3" class="col-sm-2 control-label">提现</label>
					                <div class="col-sm-10">
					                	<input type="text" required pattern="[0-9]*" title="只能输入数字" class="form-control" name="money" id="inputEmail3" placeholder="提现">
					                </div>
					    		</div>
					    		<!-- /.box-body -->
					            <div class="box-footer">
					            	<button type="reset" class="btn btn-default">重置</button>
					                <button type="submit" class="btn btn-info pull-right">提现</button>
					            </div>
					            <!-- /.box-footer -->
					    	</form>
					    	 ${msg}
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