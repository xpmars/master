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
<link href="css/jumbotron.css" rel="stylesheet">
<jsp:include page="head2.jsp"></jsp:include>
<title>用户登录</title>

<script type="text/javascript">
	$(function() {

	});
</script>

</head>
<body style="background:  white;">
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-3 column">
				<div class="row clearfix">
					<div class="col-md-12 column">
						<blockquote>
							<h3 class="text-danger">h3. Lorem ipsum dolor sit amet.</h3>
							<br>
						</blockquote>
					</div>
				</div>


				<div class="panel-group" id="accordion">
				  <div class="panel panel-default">
				    <div class="panel-heading">
				      <h4 class="panel-title">
				        <a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
				          Collapsible Group Item #1
				        </a>
				      </h4>
				    </div>
				    <div id="collapseOne" class="panel-collapse collapse in">
				      <div class="panel-body">
				      	<address>
							<strong>Twitter, Inc.</strong><br /> 795 Folsom Ave, Suite 600<br />
							San Francisco, CA 94107<br /> <abbr title="Phone">P:</abbr> (123)
							456-7890
						</address>
				      </div>
				    </div>
				  </div>
				  <div class="panel panel-default">
				    <div class="panel-heading">
				      <h4 class="panel-title">
				        <a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
				          Collapsible Group Item #2
				        </a>
				      </h4>
				    </div>
				    <div id="collapseTwo" class="panel-collapse collapse">
				      <div class="panel-body">
				        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
				      </div>
				    </div>
				  </div>
				  <div class="panel panel-default">
				    <div class="panel-heading">
				      <h4 class="panel-title">
				        <a data-toggle="collapse" data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
				          Collapsible Group Item #3
				        </a>
				      </h4>
				    </div>
				    <div id="collapseThree" class="panel-collapse collapse">
				      <div class="panel-body">
				        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
				      </div>
				    </div>
				  </div>
				</div>
			</div>
			<div class="col-md-7 column">
				<div class="row clearfix">
					<div class="col-md-4 column">
						<img alt="140x140" src="http://lorempixel.com/140/140/food/" />
					</div>
					<div class="col-md-8 column">
						<h3>h3. Lorem ipsum dolor sit amet.</h3>
					</div>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>Product</th>
							<th>Payment Taken</th>
							<th>Status</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>0</td>
							<td>TB - Monthly</td>
							<td>01/04/2012</td>
							<td>Default</td>
						</tr>
						<tr class="active">
							<td>1</td>
							<td>TB - Monthly</td>
							<td>01/04/2012</td>
							<td>Approved</td>
						</tr>
						<tr class="success">
							<td>2</td>
							<td>TB - Monthly</td>
							<td>02/04/2012</td>
							<td>Declined</td>
						</tr>
						<tr class="warning">
							<td>3</td>
							<td>TB - Monthly</td>
							<td>03/04/2012</td>
							<td>Pending</td>
						</tr>
						<tr class="danger">
							<td>4</td>
							<td>TB - Monthly</td>
							<td>04/04/2012</td>
							<td>Call in to confirm</td>
						</tr>
					</tbody>
				</table>

			</div>
			<div class="col-md-2 column">
				<h3>
					<span class="label label-primary">我的订单</span>
				</h3>
				<br>
				<ul class="list-group">
					<li class="list-group-item"><span class="badge">11</span> 魚香肉丝
					</li>
					<li class="list-group-item"><span class="badge">2</span> 三杯鸡</li>
				</ul>
				<form class="navbar-form navbar-right" role="form"
					action="<%=request.getContextPath()%>/user/user_order.action"
					method="post">
					<div class="input-group">
						<div class="input-group-btn">
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown">
								跟随 <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
							</ul>
						</div>
						<!-- /btn-group -->
						<input type="text" class="form-control">
					</div>
					<!-- /input-group -->
					<p></p>
					<button type="submit" class="btn btn-success">
						<span class="glyphicon glyphicon-ok"></span> 提交
					</button>
					<button type="reset" class="btn btn-warning">
						<span class="glyphicon glyphicon-repeat"></span> 清空
					</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
