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
	      <h1>商品列表</h1>      
	    </section>
		<!-- Main content -->
	    <section class="content">
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
						<div class="box-header">
		              		<h3 class="box-title">商品详情</h3>
		            	</div>
			            <!-- /.box-header -->
			            <div class="box-body">
			          		<form class="form-horizontal" action="addshopcart.do" method="post">
								<div style="float:left;margin-right:10px">
									<img src="goodslistphoto.do?id=${sellerGoodsInfoView.goods.goodId}" />
								</div>
								<div style="float:left;text-align:left;">
									<ul>
										<li><strong>商品名：</strong>${sellerGoodsInfoView.goods.name}</li><br/>
										<li><strong>价格：</strong>${sellerGoodsInfoView.goods.price}</li><br/>
										<li><strong>城市：</strong>${sellerGoodsInfoView.goods.city}</li><br/>
										<li><strong>卖家：</strong>${sellerGoodsInfoView.seller.shopname}</li><br/>
									    <input type="hidden" required name="goodId" value="${sellerGoodsInfoView.goods.goodId}"/>
										购买数量:
										<input type="button" class="btn btn-primary" value="-" onClick="javascript:this.form.number.value--;"/>
										<input style=" width:40px; height:40px;" required pattern="[0-9]*" title="只能输入数字" type="text" name="number" value="1"/>
										<input type="button" class="btn btn-primary" value="+" onClick="javascript:this.form.number.value++;"><br /><br />
										<button type="submit" class="btn btn-info">加入购物车</button>
										<a href="toshopcart.do"><button type="button" class="btn btn-info">查看购物车</button></a>
									</ul>
								</div>
					            <!-- /.box-footer -->
					            ${state }
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