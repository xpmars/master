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
<title>用户登录</title>

</head>
  <body>

    <div class="container">

      <form class="form-signin" role="form">
        <h2 class="form-signin-heading">用户登录</h2>
        <label for="name">用户名：</label>
        <input type="text" class="form-control" placeholder="Username/Email address" required autofocus><br>
        <label for="name">密码：</label>
        <input type="password" class="form-control" placeholder="Password" required>
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember me
        </label>
        <a class="btn btn-primary" type="submit">登录</a>
        <a class="btn btn-warning" href="#">忘记密码？</a>
      </form>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>
