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
<jsp:include page="/common/head.jsp"></jsp:include>
<title>用户登录</title>

<script type="text/javascript">
	$(function() {

	});
</script>

</head>
<body style="background:  white;">
	<div class="navbar navbar-inverse navbar-fixed-top" type="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href=""><span class="glyphicon glyphicon-send"></span><span
					style="font-size: 30px; margin-left: 0px; font-weight: bold;"> 航信点餐</span></a>

				<ul class="nav navbar-nav">
					<li class="dropdown">
					<li class="dropdown"><a href="javascript:void(0)" class="dropdown-toggle"
						data-toggle="dropdown">更多<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li class=""><a href="#" target="_blank">1</a></li>
							<li class=""><a href="#" target="_blank">2</a></li>
							<li class=""><a href="#" target="_blank">3</a></li>
						</ul></li>
					<li><a href="<%=request.getContextPath()%>/common/suggest.jsp">提出建议</a></li>
					<li><a href="<%=request.getContextPath()%>/common/about.jsp">关于我们</a></li>
				</ul>
			</div>



			<div class="navbar-collapse navbar-right">

				<s:if test="%{#session.email!=null}">


					<div class="navbar-brand">
						<ul class="nav navbar-nav">
							<s:if test="%{#session.type=='吃货'}">
								<li class="dropdown">${session.email},今天吃啥呢？</li>
							</s:if>
							<s:if test="%{#session.type=='订饭官'}">
								<li class="dropdown">${session.email},伙伴喊你订餐了~</li>
							</s:if>
							<s:if test="%{#session.type=='商家'}">
								<li class="dropdown">${session.email},有人叫外卖了!</li>
							</s:if>
						</ul>
					</div>



					<form class="navbar-form navbar-right" type="form"
						action="<%=request.getContextPath()%>/user/user_logout.action" method="post">
						<div class="btn-group">
							<button class="btn btn-info  dropdown-toggle" type="button" data-toggle="dropdown">
								设置 <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" type="menu">
								<li class=""><a href="#" target="_blank"><span class="glyphicon glyphicon-user"></span> 账号设置</a></li>
								<li class=""><a href="#" target="_blank">充值中心</a></li>
							</ul>
							<button type="submit" class="btn btn-warning">登出</button>
						</div>
					</form>
				</s:if>




				<s:else>
					<form class="navbar-form navbar-right" type="form"
						action="<%=request.getContextPath()%>/user/user_login.action" method="post">

						<div class="form-group">
							<input type="text" name="user.email" placeholder="Email" class="form-control">
						</div>
						<div class="form-group">
							<input type="password" name="user.password" placeholder="Password" class="form-control">
						</div>
						<button type="submit" class="btn btn-success">登陆</button>
						<a href="<%=request.getContextPath()%>/common/register.jsp" class="btn btn-primary">注册</a>
					</form>
				</s:else>
			</div>

			<!--/.navbar-collapse -->
		</div>
	</div>

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
		<div class="container">
			<h1>Hello, world!</h1>
			<p>This is a template for a simple marketing or informational website. It includes a large
				callout called a jumbotron and three supporting pieces of content. Use it as a starting point to
				create something more unique.</p>
			<p>
				<a class="btn btn-primary btn-lg" type="button">Learn more &raquo;</a>
			</p>
		</div>
	</div>

	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-md-4">
				<h2>自助点餐</h2>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus
					commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta
					sem malesuada magna mollis euismod. Donec sed odio dui.</p>
				<p>
					<a class="btn btn-default" href="<%=request.getContextPath()%>/common/solo.jsp" type="button"><span class="glyphicon glyphicon-cutlery"></span> SOLO &raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>组团点餐</h2>
				<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus
					commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta
					sem malesuada magna mollis euismod. Donec sed odio dui.</p>
				<p>
					<a class="btn btn-default"
						href="<%=request.getContextPath()%>/common/team.jsp" type="button"><span
						class="glyphicon glyphicon-chevron-right"></span> 求点餐 &raquo;
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul> 
					</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>优惠活动</h2>
				<img class="img-rounded" src="images/youhui.png" height="220" width="220" alt="Generic placeholder image" >
				<p>
				      特惠内容: 精选周边餐厅超多最受欢迎餐品<br>
				      优惠限制: 餐厅每日备料有限，售完即止！
				</p> 
				<p>
					<a class="btn btn-default" href="#" type="button"> <span
						class="glyphicon glyphicon-gift"></span> 优惠活动 &raquo;
					</a>
				</p>
			</div>
		</div>

		<hr>

		<footer>
			<p>&copy; Travelskygz 2014</p>
		</footer>
	</div>
	<!-- /container -->
</body>
</html>
