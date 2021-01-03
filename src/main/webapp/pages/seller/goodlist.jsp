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
              				<h3 class="box-title">我的商品</h3>
            			</div>
            			<!-- /.box-header -->
            			<div class="box-body">
             				<table id="example2" class="table table-bordered table-hover">
								<thead>
									<tr>
										<th>产品id</th>
										<th>产品名称</th>
										<th>产地</th>
										<th>价格</th>
										<th>数量</th>
										<th>图片</th>
										<th colspan="2">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${goodslist}" var="list">
						            	<tr>
						                  	<td>${list.goodId}</td>
						                 	<td>${list.name}</td>
						                 	<td>${list.city}</td>
						                 	<td>${list.price}</td>
						                 	<td>${list.number}</td>
						                 	<td><img src="goodlistphoto.do?id=${list.goodId}"  width="50" height="50"/></td>
						                  	<td>
						                  		<a href="tomodifygoods.do?id=${list.goodId}" class="btn btn-primary">修改</a>  
						                  	</td>
						                  	<td>
						                  		<a href="deletegoods.do?id=${list.goodId}" class="btn btn-danger">删除</a>
						                	</td>
						                </tr>
						        	</c:forEach>
						        </tbody>
							</table>
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
	
