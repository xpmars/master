<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="head2.jsp"></jsp:include>
<title>关于我们</title>

<script type="text/javascript" charset="UTF-8"
	src="<%=request.getContextPath()%>/js/countdown.js"></script>
</head>
<body>
	关于我们
	<p>
	<blockquote>
		<h4 id="countdown"></h4>
	</blockquote>
	<script>
	
		var now = new Date();
		
	//	alert(now.getDate());
	
	
	
	
		var clock = document.getElementById("countdown"), targetDate = new Date(
				now.getFullYear(), now.getMonth(), now.getDate()+1, 10); // 2014年2月19号上午10点  （00为1月）

		clock.innerHTML = countdown(targetDate).toString();
		setInterval(function(){  
		    clock.innerHTML = countdown(targetDate).toString();  
		  }, 1000); //设置更新间隔
	</script>
</body>
</html>