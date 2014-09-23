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
<script type="text/javascript" src="<%=request.getContextPath()%>/js/validate/jquery.validate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/validate/jquery.metadata.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/validate/message_cn.js"></script>
<script type="text/javascript" charset="UTF-8" src="<%=request.getContextPath()%>/js/bootstrap3-validation.js"></script>
<script type="text/javascript" charset="UTF-8" src="<%=request.getContextPath()%>/js/alert.js"></script>
<script type="text/javascript" charset="UTF-8" src="<%=request.getContextPath()%>/js/modal.js"></script>
<script type="text/javascript">

	$(function() {
		$("#form").validation();
		$('input[type="radio"]:checked').parent('label').addClass('active');
		
		$("#fooder").checked=true;
		$("#email").blur(function() {
			var myreg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;//邮箱的正则表达式
		       
			var inputValue = $("#email").val();
			if(!inputValue && inputValue == "" && inputValue == null)//只处验证和上面一样  
	        {  
	            $("#emailTip").html("<font color='red'>邮箱不能为空</font>");  
	            $("#btn-submit").attr('disabled',true);//设置disabled属性为false，按钮可用
	        } 
			else if(!myreg.test(inputValue))
			{
				$("#emailTip").html("<font color='red'>邮箱格式不正确</font>");  
	            $("#btn-submit").attr('disabled',true);//设置disabled属性为false，按钮可用
			}
	        else  
	        {  
	        	$.ajax({  
	                //要用post方式      
	                type: "post",     
	                //方法所在页面和方法名      
	                url: "<%=request.getContextPath()%>/user/user_findRep.action",
											data : {
												'user.email' : inputValue
											},
											dataType : "json",

											success : function(data) {
												if (data.message == 'emailSuccess') {
													//返回的数据用data.d获取内容
													$("#emailTip")
															.html(
																	"<font color='green'>该邮箱可用</font>");
													$("#btn-submit").attr(
															'disabled', false);//设置disabled属性为false，按钮可用
												}
												if (data.message == "emailError") {
													$("#emailTip")
															.html(
																	"<font color='red'>用户名重复</font>");
													$("#btn-submit")
															.removeAttr(
																	"disabled");
													//$("#btn-submit").attr('disabled',true);//设置disabled属性为false，按钮可用
												}

											},
											error : function(err) {
												alert("系统异常");
											}
										});
							}

						});

		$("#password2").blur(function() {
			if ($(this).val() == $("#password").val()) {
				$("#passwordTip").hide();
				$("#btn-submit").attr('disabled', false);//设置disabled属性为false，按钮可用
			} else {
				$("#passwordTip").show();
				$("#passwordTip").html("<font color='red'>两密码不一致</font>");
				$("#btn-submit").attr('disabled', true);//设置disabled属性为false，按钮可用
			}
		});

		 function jump(count) {    
             window.setTimeout(function(){    
                 count--;    
                 if(count > 0) {    
                     $("#num").html(count);    
                     jump(count);    
                 } else {    
                     location.href="<%=request.getContextPath()%>/index.jsp";    
                 }    
             }, 1000);    
         }    
         
		
		
		//返回值，来判断是否注册成功
		var msg = "${message}";
		if (msg == "success") {
			$("#successalert").show();
			$("#successalert").alert();
			jump(3);  
			
		} else if(msg == "mailError"){
			$("#erroralert").find("p").first().html("邮箱不能为空");
			$("#erroralert").show();
			$("#erroralert").alert();
		} else if(msg == "telError"){
			$("#erroralert").find("p").first().html("电话不能为空");
			$("#erroralert").show();
			$("#erroralert").alert();
		} else if(msg == "pswError"){
			$("#erroralert").find("p").first().html("密码输入有误");
			$("#erroralert").show();
			$("#erroralert").alert();
		} else if (msg == "error") {
			$("#erroralert").show();
			$("#erroralert").alert();
		}

	});
</script>

<title>用户注册</title>
</head>

<body>
	<div class="container">
		<div id="successalert" class="alert alert-info fade in" style="display: none">
			<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
			<h2>Oh 注册成功!</h2>
			<p>欢迎加入，3秒后进入点餐之旅......还剩<span id="num">3</span>秒  </p>
			<p>
				<a type="button" class="btn btn-info" href="<%=request.getContextPath()%>/index.jsp">好饿...</a>
			</p>

		</div>
		<div id="erroralert" class="alert alert-danger fade in" style="display: none">
			<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
			<h2>OMG,注册失败!</h2>
			
			<h3><p>Change this and that and try again. Duis mollis, est non commodo luctus, nisi erat
				porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet
				fermentum.</p>
			</h3>
			<p>
				<button type="button" class="btn btn-danger">Take this action</button>
				<button type="button" class="btn btn-default">Or do this</button>
			</p>
		</div>

		<form id="form" class="form-signin" action="<%=request.getContextPath()%>/user/user_reg.action"
			method="post">
			<div class="form-group">
				<h2 class="form-signin-heading">
					<div class="bs-callout bs-callout-info">用户注册</div>
				</h2>
				<br> <label for="email">邮箱：</label> <input id="email" name="user.email" type="text"
					class="form-control" placeholder="输入您的邮箱，必填"  onkeydown='if(event.keyCode==13) return false;' required>
				<div>	<span id="emailTip" class=""></span></div>
				<br> <label for="username">用户名：</label> <input id="username" name="user.username"
					type="text" class="form-control" placeholder="请输入用户名"><br> <label for="telephone">手机：</label>
				<input id="telephone" name="user.telephone" type="text" class="form-control"
					placeholder="输入您的手机号，必填" check-type="number required"><br> <label for="password">密码：</label>
				<input id="password" name="user.password" type="password" class="form-control"
					check-type="required" minlength="6" placeholder="请输入密码，必填"> <input id="password2"
					name="user.password2" type="password" class="form-control" check-type="required" minlength="6"
					placeholder="请再次输入，必填">
				<div>
					<span id="passwordTip">
				</div>
				<br> <label for="role">类型：</label>
				<div class="btn-group" data-toggle="buttons">
					<label class="btn btn-default"> 
						<input type="radio" name="user.usertype"
						id="user.usertype" value="吃货" checked> 吃货
					</label>
					 <label class="btn btn-default"> 
					 	<input type="radio" name="user.usertype"
						id="user.usertype" value="订饭官"> 订饭官
					</label> 
					<label class="btn btn-default"> 
						<input type="radio" name="user.usertype"
						id="user.usertype" value="商家"> 商家
					</label>
				</div>
				<br> <br>
				<button id="btn-submit" class="btn btn-primary" type="submit">注册</button>
				<button class="btn btn-info" type="reset">重置</button>
				<a class="btn btn-warning" type="reset" id="button3">忘记密码？</a>
			</div>
		</form>

	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->


</body>
</html>
