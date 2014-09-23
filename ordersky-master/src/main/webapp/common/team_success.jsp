<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="head2.jsp"></jsp:include>
<script type="text/javascript" charset="UTF-8"
	src="<%=request.getContextPath()%>/js/alert.js"></script>
<script type="text/javascript" charset="UTF-8"
	src="<%=request.getContextPath()%>/js/modal.js"></script>
<title>success</title>
</head>
<body>
	<div class="container">
		<div id="successalert" class="alert alert-info fade in">
			<button type="button" class="close" data-dismiss="alert"
				aria-hidden="true">&times;</button>
			<h3>Oh 订单成功提交至<%=request.getParameter("rvcvd")%> ...</h3>
			<p>
				<a type="button" class="btn btn-info"
					href="<%=request.getContextPath()%>/index.jsp">还要点餐...？</a>
			</p>

		</div>
	</div>
</body>
</html>