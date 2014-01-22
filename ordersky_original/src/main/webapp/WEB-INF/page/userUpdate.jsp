<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>修改用户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   

  </head>
  
  <body>
    <center>
    	<h1>修改用户</h1>
    	<s:form action="user_update" namespace="/user" method="post">
    		<s:hidden name="user.id"></s:hidden>
    		<s:textfield label="用户名" name="user.username"></s:textfield>
    		<s:password label="密码" name="user.password"></s:password>
    		<s:submit value="提交"></s:submit>
    	</s:form>
    </center>
  </body>
</html>