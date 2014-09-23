<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script type="text/javascript">
   	$.contextPath = "<%=request.getContextPath()%>";
</script>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<jsp:include page="head2.jsp"></jsp:include>

<script type="text/javascript">
$(function() {
    
   
});
</script>

<title>用户登录</title>

<script type="text/javascript">
$(function() {
	
   
});
</script>
</head>
<body>

			
	<div class="container">
		<form class="form-signin" action="<%=request.getContextPath()%>/user/user_login.action"
			method="post">
			
			<h2 class="form-signin-heading">
				<div class="bs-callout bs-callout-danger">用户登录</div>
			</h2>
			<br>

			<div class="error-note"
				style="background: #fae8ca; font-size: 14px; color: #c00; margin: 10px; height: 30px; line-height: 30px; text-align: center;">
				登录失败，请检查你的输入
			</div>

			<label for="name">邮箱：</label>
			<input name="user.email" type="text" class="form-control" placeholder="Email" required> 
			<label for="name">密码：</label>
			<input name="user.password" type="password" class="form-control" placeholder="Password" required> 
			<label class="checkbox">
				<input type="checkbox" value="remember-me"> Remember me
			</label> 
			<button type="submit" class="btn btn-success">登陆</button>
			<a class="btn btn-warning" href="#">忘记密码？</a> 
			<a href="<%=request.getContextPath()%>/common/register.jsp" class="btn btn-info">新用户注册</a>
		</form>

	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
</body>
</html>
