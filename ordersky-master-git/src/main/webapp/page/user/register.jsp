<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<jsp:include page="../../common/head.jsp"></jsp:include>
<title>用户注册</title>

</head>
<body>

	<div class="container">

		<form class="form-signin" role="form">
			<div class="form-group">
				<h1 class="form-signin-heading">用户注册</h1><br>

				<label for="username">用户名：</label>
				<input type="text" class="form-control"
					placeholder="User name/Email address" required autofocus><br>
				<label for="telephone">手机：</label>			
				<input
					type="text" class="form-control" placeholder="Telephone" required
					autofocus><br>
				<label for="password">密码：</label>				
				<input type="password" class="form-control"
					placeholder="Password" required> 
				<input type="password" class="form-control"
					placeholder="Re-Password" required> 

				<button class="btn btn-primary" type="submit">注册</button>
				<button class="btn btn-warning" type="reset">重置</button>
			</div>
		</form>

	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	

</body>
</html>
