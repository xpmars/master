<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="head.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body style="background:  white;">
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand"
					href="<%=request.getContextPath()%>/index.jsp"><span class="glyphicon glyphicon-send"></span><span
					style="font-size: 30px; margin-left: 0px; font-weight: bold;"> 航信点餐</span></a>

				<ul class="nav navbar-nav">
					<li class="dropdown">
					<li class="dropdown"><a href="javascript:void(0)"
						class="dropdown-toggle" data-toggle="dropdown">更多<b
							class="caret"></b></a>
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
								<li class="dropdown">${session.username},伙伴喊你订餐了~</li>
							</s:if>
							<s:if test="%{#session.type=='商家'}">
								<li class="dropdown">${session.type},有人叫外卖了!</li>
							</s:if>
						</ul>
					</div>



					<form class="navbar-form navbar-right" role="form"
						action="<%=request.getContextPath()%>/user/user_logout.action"
						method="post">
						<div class="btn-group">
							<button class="btn btn-info  dropdown-toggle" type="button"
								data-toggle="dropdown"><span class="glyphicon glyphicon-tag"></span>
								设置 <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" role="menu">
								<li class=""><a href="#" target="_blank"><span class="glyphicon glyphicon-send"></span> 账号设置</a></li>
								<li class=""><a href="#" target="_blank"> 充值中心</a></li>
							</ul>
							<button type="submit" class="btn btn-warning"><span class="glyphicon glyphicon-log-out"></span> 登出</button>
						</div>
					</form>
				</s:if>




				<s:else>
					<form class="navbar-form navbar-right" role="form"
						action="<%=request.getContextPath()%>/user/user_login.action"
						method="post">

						<div class="form-group">
							<input type="text" name="user.email" placeholder="Email"
								class="form-control">
						</div>
						<div class="form-group">
							<input type="password" name="user.password"
								placeholder="Password" class="form-control">
						</div>
						<button type="submit" class="btn btn-success">登陆</button>
						<a href="<%=request.getContextPath()%>/common/register.jsp"
							class="btn btn-primary">注册</a>
					</form>
				</s:else>
			</div>

			<!--/.navbar-collapse -->

		</div>
	</div>

</body>
</html>