<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<jsp:include page="head2.jsp"></jsp:include>
<title>用户登录</title>

<script type="text/javascript">
var orderArr = new Array();//定义订单数组
var henchMan = null;//定义订单跟随者(Email)
var orderUser = '<s:property value="%{#session.email}" />';//定义订单使用者
var henchManEmail = null;//定义订单跟随者Email
	$(function() {
		$.ajax({  //加载henchman列表
            //要用post方式      
            type: "post",     
            //方法所在页面和方法名      
            url: "<%=request.getContextPath()%>/user/user_getBenchmanList.action",
					dataType : "json",

					success : function(data) {

						henchManEmail = '<s:property value="%{#session.henchman}" />';//定义订单跟随者
						
						$('#henchmanList').empty();
						$('#henchmanList').append("<li><a href='#'>自定义追随者</a></li><li class='divider'></li>");
						$.each(
							data.userList,
							function(i, value) {
								
								var $htmlLi = $("<li><a id="+value.email+" href='#'>"
										+ value.username
										+ "</a></li>"); //创建DOM对象		
								$('#henchmanList').append($htmlLi); //将$htmlLi追加到$ul元素的li列表
								
								if(henchManEmail == value.email){
									$('#henchamanInput').val(value.username);
									henchMan = henchManEmail;
								}
							})

					},
					error : function(err) {
						alert("系统异常");
					}
				});
		
		
		
		
		$("#subBtn").attr('disabled',true);//设置disabled属性为false，按钮可用
		var week = new Date().getDay();
		var wid = "w" + week;
		$('#' + wid).addClass("active");
		$("#tbody tr")
				.dblclick(
						function() {
							$("#count").show();
							$("#count").alert();
							var id = $(this).find('td').eq(1).text();
							orderArr.push(id);
							var num = 0;
							for(var i=0;i<orderArr.length;i++){
								if(orderArr[i]==id){
									num++;
								}
							}
							if(num==1){
								var $htmlLi = $("<li class='list-group-item'><span id="+ id +" class='badge'>"
										+ num + "</span>" + $(this).find('td').eq(2).text() + "</li>"); //创建DOM对象		
								$('#orderList').append($htmlLi); //将$htmlLi追加到$ul元素的li列表
							}else{
								$('#'+id).html(num);
								//更新DOM对象
							}
							var countPrice = parseFloat($("#countPrice").html()) + parseFloat($(this).find('td').eq(4).text());
							$("#countPrice").html(countPrice);
							$("#subBtn").attr('disabled',false);//设置disabled属性为false，按钮可用
						});
		
	});
	function clearli(){
		$("#subBtn").attr('disabled',true);//设置disabled属性为false，按钮可用
		orderArr.splice(0,orderArr.length);  
		$('#orderList').empty();
		$("#countPrice").html(0);
		$("#count").hide();
	}
	function submitOrder(){
		var orderStr = orderArr.toString();
     	$.ajax({  
            //要用post方式      
            type: "post",     
            //方法所在页面和方法名      
            url: "<%=request.getContextPath()%>/order/order_submit.action",
			data : {
				'orderStr' : orderStr,
				'orderUser' : orderUser,
				'henchMan' : henchMan,
				
			},
			dataType : "json",

			//返回json
		    success:function(data){	
		   	var d = eval("("+data+")");//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
				//返回的数据用data.d获取内容
				location.href="<%=request.getContextPath()%>/common/team_success.jsp?rvcvd="+d.email;      
		     },
		     error:function(){
		    	 location.href="<%=request.getContextPath()%>/common/error.jsp";
		     },
		});
	}
	
	

	//事件绑定 
	$(document).on("click", "li a", function() {
		henchMan = $(this).attr("id");
		var username = $(this).text();
		$('#henchamanInput').val(username);
	});
</script>

</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-3 column">
				<div class="row clearfix">
					<div class="col-md-12 column">
						<div class="bs-callout bs-callout-danger">

							<h3 id="countTip">距本次点餐结束：</h3>
							<p>
							<h4 id="countdown"></h4>

<script>
	var now = new Date();
	var hour1 = 10;//第一次点餐结束时间为10:30
	var minute1 = 30;
	var hour2 = 16;//第二次点餐结束时间为16:30
	var minute2 = 30;
	var date = now.getDate();
	var hour = null;
	var minute = null;
	var time1 = new Date(now.getFullYear(), now.getMonth(), date,hour1,minute1,0);
	var time2 = new Date(now.getFullYear(), now.getMonth(), date,hour2,minute2,0);
	$('#countdown').show();
	
	if(now <= time1){
		$('#countTip').empty();
		$('#countTip').html("距离上午点餐结束：");
		hour = hour1;
		minute = minute1;
	}else if(now > time1 && now <= time2){
		$('#countTip').empty();
		$('#countTip').html("距离下午点餐结束：");
		hour = hour2;
		minute = minute2;
	}else if(now > time2){
		$('#countTip').empty();
		$('#countTip').html("今天组队点餐已经结束...");
	}
	if (now.getHours() > 10 && now.getHours() <= 16) {
		var hour = 16;
		var minute = 30;
	}else if(now.getHours() > 16){
		$('#countdown').hidden();
	}
	
	var clock = document.getElementById("countdown"), 
	targetDate = new Date(now.getFullYear(), now.getMonth(), date, hour,minute,0); // 2014年2月19号上午10点  （00为1月）
	clock.innerHTML = countdown(targetDate).toString();
	setInterval(function() {
		clock.innerHTML = countdown(targetDate).toString();
	}, 1000); //设置更新间隔
</script>
			</div>
					</div>
				</div>
				<div class="list-group" id="rest">
					<a href="#" class="list-group-item active"><span class="glyphicon glyphicon-tags"></span>&nbsp;&nbsp;&nbsp;&nbsp;每周菜单</a>
					<a href="#" class="list-group-item" id="w1"><span class="badge">Mon</span>家乐缘</a> <a href="#"
						class="list-group-item" id="w2"><span class="badge">Tues</span>都城</a> <a href="#"
						class="list-group-item" id="w3"><span class="badge">Wed</span>湘忆木桶饭</a> <a href="#"
						class="list-group-item" id="w4"><span class="badge">Thur</span>悦香鸡</a> <a href="#"
						class="list-group-item" id="w5"><span class="badge">Fri</span>家乐缘</a> <a href="#"
						class="list-group-item" id="w6"><span class="badge">Sat</span>麦当劳</a> <a href="#"
						class="list-group-item" id="w0"><span class="badge">Sun</span>真功夫</a>
				</div>
				<div class="navbar-bottom">
					<address>
						<strong>Twitter, Inc.</strong><br /> 795 Folsom Ave, Suite 600<br /> San Francisco, CA 94107<br />
						<abbr title="Phone">P:</abbr> (123) 456-7890
					</address>
				</div>
			</div>
			<div class="col-md-7 column">
				<div class="panel panel-heading">
					<div class="row clearfix">
						<div class="col-md-4 column">
							<img alt="140x140" src="http://lorempixel.com/140/140/food/" />
						</div>
						<div class="col-md-8 column">
							<h3 class="name" class="text-info">
								<a class="value" href="#"> 家乐缘 </a>
							</h3>
							<div class="text-danger" title="87534766/87534789">
								<span class="glyphicon glyphicon-earphone"></span> <abbr title="Phone">87534766/&#8203;87534789</abbr>
							</div>
						</div>
					</div>
					<table class="table table-hover" id="dishTable">
						<thead>
							<tr>
								<th>#</th>
								<th>Dishes</th>
								<th>Time Interval</th>
								<th>Price</th>
							</tr>
						</thead>
						<tbody id="tbody">
							<s:iterator value="dishList" id="dish" status="d">
								<s:if test="%{#d.index%4==0}">
									<tr class="active">
								</s:if>
								<s:if test="%{#d.index%4==1}">
									<tr class="warning">
								</s:if>
								<s:if test="%{#d.index%4==2}">
									<tr class="success">
								</s:if>
								<s:if test="%{#d.index%4==3}">
									<tr class="danger">
								</s:if>
								<td id="index"><s:property value="#d.index+1"></s:property></td>
								<td id="id" style="display: none"><s:property value="#dish.id"></s:property></td>
								<td id="dishName"><s:property value="#dish.dishName"></s:property></td>
								<td id="interval"><s:property value="#dish.interval"></s:property></td>
								<td id="price"><s:property value="#dish.price"></s:property></td>
							</s:iterator>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col-md-2 column">
				<h3>
					<span class="label label-primary">我的订单</span>
				</h3>
				<br>
				<ul class="list-group" id="orderList">
				</ul>
				<div class="row clearfix">
					<div class="col-md-12 column">
						<div id="count" class="alert alert-info fade in" style="display: none">
							共计：<span id="countPrice">0</span>
						</div>
					</div>
				</div>
				<form class="navbar-form navbar-right" role="form">
					<div class="input-group">
						<div class="input-group-btn">
							<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"
								onclick="loadBenchmanList()">
								跟随 <span class="caret"></span>
							</button>

							<ul id="henchmanList" class="dropdown-menu">

							</ul>
						</div>
						<!-- /btn-group -->
						<input id="henchamanInput" type="text" class="form-control">

					</div>
					<!-- /input-group -->
					<p></p>
					<a type="submit" class="btn btn-success" id="subBtn" onclick="submitOrder()"><span
						class="glyphicon glyphicon-ok"></span> 提交 </a> <a id="clear" type="reset" class="btn btn-warning"
						onclick="clearli()"> <span class="glyphicon glyphicon-repeat"></span> 清空
					</a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
