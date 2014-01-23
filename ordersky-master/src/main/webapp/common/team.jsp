<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link href="css/jumbotron.css" rel="stylesheet">
<jsp:include page="head2.jsp"></jsp:include>
<title>用户登录</title>

<script type="text/javascript">
	$(function() {

	});
</script>

</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-3 column">
				<div class="list-group">
					<a href="#" class="list-group-item active">Home</a>
					<div class="list-group-item">List header</div>
					<div class="list-group-item">
						<h4 class="list-group-item-heading">List group item heading</h4>
						<p class="list-group-item-text">...</p>
					</div>
					<div class="list-group-item">
						<span class="badge">14</span>Help
					</div>
					<a class="list-group-item active"><span class="badge">14</span>Help</a>
				</div>
			</div>
			<div class="col-md-7 column">
				<div class="row clearfix">
					<div class="col-md-4 column">
						<img alt="140x140" src="http://lorempixel.com/140/140/food/" />
					</div>
					<div class="col-md-8 column">
						<h3>h3. Lorem ipsum dolor sit amet.</h3>
					</div>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>Product</th>
							<th>Payment Taken</th>
							<th>Status</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>0</td>
							<td>TB - Monthly</td>
							<td>01/04/2012</td>
							<td>Default</td>
						</tr>
						<tr class="active">
							<td>1</td>
							<td>TB - Monthly</td>
							<td>01/04/2012</td>
							<td>Approved</td>
						</tr>
						<tr class="success">
							<td>2</td>
							<td>TB - Monthly</td>
							<td>02/04/2012</td>
							<td>Declined</td>
						</tr>
						<tr class="warning">
							<td>3</td>
							<td>TB - Monthly</td>
							<td>03/04/2012</td>
							<td>Pending</td>
						</tr>
						<tr class="danger">
							<td>4</td>
							<td>TB - Monthly</td>
							<td>04/04/2012</td>
							<td>Call in to confirm</td>
						</tr>
					</tbody>
				</table>
				<address>
					<strong>Twitter, Inc.</strong><br /> 795 Folsom Ave, Suite 600<br /> San Francisco, CA 94107<br />
					<abbr title="Phone">P:</abbr> (123) 456-7890
				</address>
			</div>
			<div class="col-md-2 column">
				<h3>
					<span class="label label-primary">我的订单</span>
				</h3>
				<br>
				<ul>
					<li>Lorem ipsum dolor sit amet</li>
					<li>Consectetur adipiscing elit</li>
					<li>Integer molestie lorem at massa</li>
					<li>Facilisis in pretium nisl aliquet</li>
					<li>Nulla volutpat aliquam velit</li>
					<li>Faucibus porta lacus fringilla vel</li>
					<li>Aenean sit amet erat nunc</li>
					<li>Eget porttitor lorem</li>
				</ul>
				<form class="navbar-form navbar-right" role="form"
					action="<%=request.getContextPath()%>/user/user_order.action" method="post">
					<div class="input-group">
						<div class="input-group-btn">
							<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
								跟随 <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
							</ul>
						</div>
						<!-- /btn-group -->
						<input type="text" class="form-control">
					</div>
					<!-- /input-group -->
					<p></p>
					<button type="submit" class="btn btn-success">提交</button>
					<button type="reset" class="btn btn-warning">清空</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
