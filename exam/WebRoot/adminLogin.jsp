<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8" />
<title>教师</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/registration.css" />
<script src="${pageContext.request.contextPath }/Js/jquery-1.12.4.js"
	type="text/javascript" charset="utf-8"></script>

<script type="text/javascript" charset="utf-8">
	$(function() {
		$(".register-name").blur(function() {
			if ($(this).val() == "") {
				$("._span").html("请输入用户名");
				$("._span").css({
					"font-size" : "10px",
					"color" : "red"
				});
			} else {
				$("._span").html("");

			}

		});
		$(".register-pwd").blur(function() {
			if ($(this).val() == "") {
				$(".span").html("请输入密码");
				$(".span").css({
					"font-size" : "10px",
					"color" : "red"
				});
			} else {
				$(".span").html("");

			}
		});
	});
</script>
</head>

<body>

	<div class="registration">
				<div class="logo">
					<span>蓝鸟云课堂</span> <span class="name"><a href="login.jsp">学员登录</a></span> <span
						class="_name"><a  href="anminRegister.jsp">教师注册</a></span>
				</div>
		</div>
	<article class="login-guide-main">

	<div class="register-form">
		<h1>教师登录</h1>
		<form action="${pageContext.request.contextPath }/admin"
			autocomplete="off" id="registerfrom" autocomplete="off">
			<input type="hidden" value="login" name="judge"> <input
				type="hidden" value="stu" name="admin">
			<div class="div-wrap">

				<input type="text" name="name" class="register-name"
					placeholder="请输入用户名" autocomplete="off" required="required"
					value=<c:if test="${adLogin!=null }">
								${adLogin.adminName}
							</c:if>><span
					class="_span"></span>
				<p class="iconfont icon-jinggao"></p>
				<i></i>
			</div>
			<div class="pwd-login-to div-wrap">
				<input type="password" name="pwd" class="register-pwd"
					placeholder="请输入密码" autocomplete="off" required="required"><span
					class="span"></span>
				<p class="iconfont icon-jinggao"></p>
				<i></i>
			</div>
			<div class="slider">
				<div id="captcha"></div>
				<p class="iconfont icon-jinggao"></p>
			</div>
			<div class="toggle-div">
				<p class="code-login">
					<a href="javascript:void(0);">密码码登录</a>
				</p>
				<p class="forget-pwd">
					<a href="/findpass">忘记密码</a>
				</p>
			</div>
			<div class="loginst">
				<input type="submit" class="login-submit" value="登录" />
			</div>
		</form>
	</div>
	</article>
	<footer>
	<p>第四组@@@&nbsp;哈哈哈哈哈哈哈哈</p>
	</footer>
</body>
</html>
