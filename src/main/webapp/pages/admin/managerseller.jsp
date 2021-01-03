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
      		<h1>卖家审核</h1>      
   		</section>
   		<!-- Main content -->
	    <section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header">
              				<h3 class="box-title">卖家列表</h3>
            			</div>
            			<!-- /.box-header -->
            			<div class="box-body">
             				<table id="example2" class="table table-bordered table-hover">
								<thead>
									<tr>
										<th>序号</th>
										<th>卖家id</th>
										<th>商店名称</th>
										<th>是否有权限</th>
										<th colspan="2">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${sellerlist}" var="list" varStatus="st">
						            	<tr>
						                	<td>${st.count}</td>
						                  	<td>${list.getSellerId()}</td>
						                 	<td>${list.getShopname()}</td>
						                  	<td>
						                  		<c:if test="${list.getPower()==0}">无权限</c:if>
												<c:if test="${list.getPower()==1}">有权限</c:if>
						                  	</td>
						                  	<td>
							                  	<c:if test="${list.getPower()==0}">
													<a href="managerseller.do?power=1&sellerId=${list.getSellerId()}" class="btn btn-primary">审核</a>
												</c:if>
												<c:if test="${list.getPower()==1}">
													<a href="managerseller.do?power=0&sellerId=${list.getSellerId()}" class="btn btn-primary">退审</a>
												</c:if>               
						                  	</td>
						                  	<td>
						                  		<a href="delectseller.do?sellerId=${list.getSellerId()}" class="btn btn-danger">删除</a>
						                	</td>
						                </tr>
						        	</c:forEach>
						        </tbody>
							</table>
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