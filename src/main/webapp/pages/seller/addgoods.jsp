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
	      <h1>商品信息管理</h1>      
	    </section>
		<!-- Main content -->
	    <section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header">
		              		<h3 class="box-title">增加商品</h3>
		            	</div>
			            <!-- /.box-header -->
			            <div class="box-body">
					        <form class="form-horizontal" action="addgoods.do" method="post" enctype="multipart/form-data">
								<div class="form-group">
					    			<label for="inputEmail3" class="col-sm-2 control-label">商品名称:</label>
					                <div class="col-sm-10">
					                	<input type="text" required class="form-control" name="name" id="inputEmail3" placeholder="名称">
					                </div>
					    		</div>
					    		<div class="form-group">
					    			<label for="inputEmail3" class="col-sm-2 control-label">商品产地:</label>
					                <div class="col-sm-10">
					                	<input type="text" required class="form-control" name="city" id="inputEmail3" placeholder="产地">
					                </div>
					    		</div>
					    		<div class="form-group">
					    			<label for="inputEmail3" class="col-sm-2 control-label">商品价格:</label>
					                <div class="col-sm-10">
					                	<input type="text" required pattern="[0-9]*" title="只能输入数字" class="form-control" name="price" id="inputEmail3" placeholder="价格">
					                </div>
					    		</div>
					    		<div class="form-group">
					    			<label for="inputEmail3" class="col-sm-2 control-label">商品数量:</label>
					                <div class="col-sm-10">
					                	<input type="text" required pattern="[0-9]*" title="只能输入数字" class="form-control" name="number" id="inputEmail3" placeholder="数量">
					                </div>
					    		</div>
					    		<div class="form-group">
				                	<label for="inputEmail3" class="col-sm-2 control-label">商品图片:</label>
				                  	<div class="col-sm-10">
				                    	<input type="file" required class="form-control" name="goodsPic" id="inputEmail3" placeholder="图片">
				                  	</div>
				                </div>
					    		
					    		<!-- /.box-body -->
					            <div class="box-footer">
					            	<button type="reset" class="btn btn-default">重置</button>
					                <button type="submit" class="btn btn-info pull-right">添加</button>
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