<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>

<title>航信点餐系统</title>
<sj:head jqueryui="true" compressed="false" defaultIndicator="myDefaultIndicator" 
   	jquerytheme="flick"	locale="zh-CN" defaultLoadingText="Please wait ..."/>  
<script type="text/javascript">
   	$.contextPath = "<%=request.getContextPath()%>";
</script>

<!-- 最新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css">
<!-- Custom styles for this template -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/signin.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/docs.css">
<link href="<%=request.getContextPath()%>/css/navbar-fixed-top.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/carousel.css" rel="stylesheet">
<script type="text/javascript" charset="UTF-8" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript" charset="UTF-8" src="<%=request.getContextPath()%>/js/jquery-ui.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="<%=request.getContextPath()%>/js/json2.js"></script>
<script type="text/javascript" charset="UTF-8" src="<%=request.getContextPath()%>/js/holder.js"></script>
<script type="text/javascript" charset="UTF-8" src="<%=request.getContextPath()%>/js/highlight.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="<%=request.getContextPath()%>/js/collapse.js"></script>
<script type="text/javascript" charset="UTF-8" src="<%=request.getContextPath()%>/js/transition.js"></script>
<script type="text/javascript" charset="UTF-8" src="<%=request.getContextPath()%>/js/countdown.js"></script>
<script type="text/javascript">
	$(function() {
		$("#pageloading").hide();
	});
	
</script>