<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="head2.jsp"></jsp:include>
<title>关于我们</title>

<script type="text/javascript" charset="UTF-8" src="<%=request.getContextPath()%>/js/countdown.js"></script>
</head>
<body>
关于我们
<p>
<blockquote>
<strong>Countdown until midnight</strong>
<h4 id="midnight-countdown"></h4>
</blockquote>  
<script>
  var clock1 = document.getElementById("midnight-countdown")
  , tdy = new Date();
  clock1.innerHTML = countdown(new Date(tdy.getFullYear(), tdy.getMonth(), tdy.getDate() + 1) ).toString();
  setInterval(function(){
    clock1.innerHTML = countdown(new Date(tdy.getFullYear(), tdy.getMonth(), tdy.getDate() + 1) ).toString();
  }, 1000);
</script> 
</body>
</html>