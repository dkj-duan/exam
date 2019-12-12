<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<title>教师注册页面</title>
<script src="${pageContext.request.contextPath }/Js/jquery-1.12.4.js"
	type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="css/register.css" />
<script type="text/javascript">
	$(function() {
		//加载动画
		$(".table")
				.hover(
						function() {
							$(this)
									.css(
											{
												"box-shadow" : "rgba(229,229,231,0.5) -3px 3px,rgba(229,229,231,0.5) 3px -3px",
												"transform" : "translatey(-5px)",
												"transition" : "all 1.2s "
											});
						}, function() {
							$(this).css({
								"box-shadow" : "",
								"transform" : "translate(0px)"
							});
						});

		//验证用户名
		$(".stuName").blur(
				function() {
					var $stuName = $(this).val();
					if ($stuName != "") {
						$("#stuName").html("");
						$(".sub").removeAttr("disabled");
					} else {
						$("#stuName").html(
								"<span class='tiShi'>*用户名不能为空</span>");
						$(".sub").attr({
							"disabled" : "disabled "
						});
						return;
					}
					//异步查询用户名是否可用
					var $name = $(".stuName").val();
					$.post("${pageContext.request.contextPath}/judge", "name="
							+ $name + "&ju=admin", function(date) {
						if (date.boolean) {
							$("#stuName").html(date.span);
							$(".sub").removeAttr("disabled");
						} else {
							$("#stuName").html(date.span);
							$(".sub").attr({
								"disabled" : "disabled "
							});
						}
					}, "JSON");
				});
		//验证密码
		var reg = /^[A-Za-z0-9]\w{5,15}$/;
		$(".pwd").blur(function() {
			var $pwd = $(this).val();
			if ($pwd == "") {
				$("#pwdSpan").html("<span class='tiShi'>*密码不能为空</span>");
				$(".sub").attr({
					"disabled" : "disabled "
				});
			} else if (reg.test($pwd)) {
				$("#pwdSpan").html("");
				$(".sub").removeAttr("disabled");
			} else {
				$("#pwdSpan").html("<span class='tiShi'>*密码格式不正确</span>");
				$(".sub").attr({
					"disabled" : "disabled "
				});
			}
		});
		//判断身份证号不能为空
		$(".cardId").blur(function() {
			var $cardId = $(this).val();
			if ($cardId != "") {
				$("#cardId").html("");
				$(".sub").removeAttr("disabled");
			} else {
				$("#cardId").html("<span class='tiShi'>*身份证不能为空</span>");
				$(".sub").attr({
					"disabled" : "disabled "
				});
			}
		});
		//判断手机号不能为空
		$(".phone").blur(function() {
			var $phone = $(this).val();
			if ($phone != "") {
				$("#phone").html("");
				$(".sub").removeAttr("disabled");
			} else {
				$("#phone").html("<span class='tiShi'>*手机号不能为空</span>");
				$(".sub").attr({
					"disabled" : "disabled "
				});
			}
		});
		//判断邮箱是否为空
		$(".email").blur(function() {
			var $email = $(this).val();
			if ($email != "") {
				$("#email").html("");
				$(".sub").removeAttr("disabled");
			} else {
				$("#email").html("<span class='tiShi'>*邮箱不能为空</span>");
				$(".sub").attr({
					"disabled" : "disabled "
				});
			}
		});
	});
</script>


</head>

<body>
	<header class="header">

		<div class="registration">
				<div class="logo">
					<span>蓝鸟云课堂</span> <span class="name"><a href="adminLogin.jsp">登录</a></span> <span
						class="_name"><a  href="anminRegister.jsp">注册</a></span>
				</div>
		</div>
	<div class="table">
		<span class="textSpan">请填写注册信息</span>
		<ul>

			<form class="myForm"
				action="${pageContext.request.contextPath }/admin" method="post">
				<input type="hidden" value="register" name="judge">
				<li class="li1">用户名：<input type="text" class="stuName"
					name="name" placeholder="请输入用户名" required="required" value="" /> <span
					id="stuName"></span>
				</li>
				<li class="li2">密码：<input class="pwd" type="password"
					placeholder="请输入密码" required="required" name="pwd" value="" /> <span
					id="pwdSpan"></span>
				</li>
				<li class="li3">身份证号：<input class="cardId" type="text"
					placeholder="请输入身份证号" required="required" name="cardId" value="" />
					<span id="cardId"></span>
				</li>
				<li class="li4">手机号：<input class="phone" type="text"
					placeholder="请输入手机号" required="required" name="phone" value="" />
					<span id="phone"></span>
				</li>
				<li class="li5">邮箱：<input class="email" type="email"
					placeholder="请输入邮箱" required="required" name="email" value="" /> <span
					id="email"></span>
				</li>
				<li class="li6"><input class="sub" type="submit" value="GO!!!" />
				</li>
			</form>
		</ul>
	</div>
	</header>
</body>
</html>
