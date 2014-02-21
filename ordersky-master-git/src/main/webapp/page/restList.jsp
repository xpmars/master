<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<jsp:include page="../common/head.jsp"></jsp:include>
<title>餐厅列表</title>


</head>
<script type="text/javascript">

</script>
<body>
	<center>
		<h2>餐厅列表</h2>

<s:url id="remoteurl" action="rest_queryAllRest" namespace="/rest"/>
<sjg:grid
    	id="gridtable"
    	caption="Restaurant-List"
    	dataType="json"
    	href="%{#}"
    	pager="true"
    	gridModel="gridModel"
    	rowList="10,15,20"
    	rowNum="15"
    	rownumbers="true">
    	<sjg:gridColumn name="id" index="id" title="ID" formatter="integer" sortable="false"/>
    	<sjg:gridColumn name="restRame" index="restRame" title="RestRame" sortable="false"/>
    	<sjg:gridColumn name="score" index="score" title="Score" sortable="true"/>
    </sjg:grid>

	</center>
</body>
</html>