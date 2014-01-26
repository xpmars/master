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
<jsp:include page="head2.jsp"></jsp:include>
<title>用户登录</title>

<script type="text/javascript">
	$(function() {
		var week = new Date().getDay();
		var wid = "w" + week;
		$('#'+ wid).addClass("active");
		$('#countdowner').scojs_countdown({until: 1364382956});
	});
	
</script>

</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-3 column">
				<div class="row clearfix">
					<div class="col-md-12 column">
						<blockquote>
						<h3 class="text-danger">距本次订餐结束：</h3>
						<p>
						    <div id="countdowner" data-d="días" data-h="horas" data-m="minutos" data-s="segundos"></div>
<script>
$('#countdowner').scojs_countdown({until: 1364382956});
</script>
						
					</blockquote>
					</div>
				</div>
				<div class="list-group" id="rest">
					<a href="#" class="list-group-item active"><span class="glyphicon glyphicon-tags"></span>&nbsp;&nbsp;&nbsp;&nbsp;每周菜单</a>
					<a href="#" class="list-group-item" id="w1"><span class="badge">Mon</span>家乐缘</a>
					<a href="#" class="list-group-item" id="w2"><span class="badge">Tues</span>都城</a>
					<a href="#" class="list-group-item" id="w3"><span class="badge">Wed</span>湘忆木桶饭</a>
					<a href="#" class="list-group-item" id="w4"><span class="badge">Thur</span>悦香鸡</a>
					<a href="#" class="list-group-item" id="w5"><span class="badge">Fri</span>家乐缘</a>
					<a href="#" class="list-group-item" id="w6"><span class="badge">Sat</span>麦当劳</a>
					<a href="#" class="list-group-item" id="w7"><span class="badge">Sun</span>真功夫</a>
				</div>
				<div class="navbar-bottom">
					<address>
						<strong>Twitter, Inc.</strong><br /> 795 Folsom Ave, Suite 600<br />
						San Francisco, CA 94107<br /> <abbr title="Phone">P:</abbr> (123)
						456-7890
					</address>
				</div>
			</div>
			<div class="col-md-7 column">
				<div class="row clearfix">
					<div class="col-md-4 column">
						<img alt="140x140" src="http://lorempixel.com/140/140/food/" />
					</div>
					<div class="col-md-8 column">
						<h3 class="name" class="text-info">
							<a class="value" href="#"> 家乐缘 </a>
						</h3>
						<div class="class=" text-danger" title="87534766/87534789">
							<span class="glyphicon glyphicon-earphone"></span> <abbr
								title="Phone">87534766/&#8203;87534789</abbr>
						</div>
					</div>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>Dishes</th>
							<th>Time Interval</th>
							<th>Price</th>
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

			</div>
			<div class="col-md-2 column">
				<h3>
					<span class="label label-primary">我的订单</span>
				</h3>
				<br>
				<ul class="list-group">
					<li class="list-group-item"><span class="badge">11</span> 魚香肉丝
					</li>
					<li class="list-group-item"><span class="badge">2</span> 三杯鸡</li>
				</ul>
				<form class="navbar-form navbar-right" role="form"
					action="<%=request.getContextPath()%>/user/user_order.action"
					method="post">
					<div class="input-group">
						<div class="input-group-btn">
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown">
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
					<button type="submit" class="btn btn-success">
						<span class="glyphicon glyphicon-ok"></span> 提交
					</button>
					<button type="reset" class="btn btn-warning">
						<span class="glyphicon glyphicon-repeat"></span> 清空
					</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
