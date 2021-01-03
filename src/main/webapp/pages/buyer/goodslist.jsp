<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
 body {
 	margin: 0px;
 }
#flow-box{
    margin: 10px auto 0 auto;
    padding: 1px;
    display: flex;
    display: -webkit-flex;
    flex-wrap: wrap;
    -webkit-flex-wrap: wrap; /* Safari 6.1+ */
    justify-content: flex-start;
    -webkit-justify-content: flex-start;
    
}
#flow-box div{
    width: 320px;
    height: 350px;
    padding: 10px;
    margin: 10px 10px;
}
#flow-box div img{
    width: 90%;
    height: 90%;
}

</style>
</head>
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
      		<h1>商品列表</h1>      
   		</section>
   		<!-- Main content -->
	    <section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header">
              				<h3 class="box-title">全部商品</h3>
            			</div>
            			<!-- /.box-header -->
            			<div class="box-body">
            				<div id="flow-box">
            					<c:forEach items="${GoodsList}" var="goods">
									<div>
										<a href="togoodsinfo.do?goodId=${goods.getGoodId()}"><img src="goodslistphoto.do?id=${goods.goodId}" /></a>
										<ul>
											<li><strong>商品名：</strong>${goods.name}</li>
											<li><strong>价格：</strong>${goods.price}</li>
										</ul>
									</div>
								</c:forEach>
							</div>
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
	
