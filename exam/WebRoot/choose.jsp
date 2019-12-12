<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="utf-8" />
		<!--
        	作者：星河
        	时间：2019-09-12
        	描述：登录页面
        -->
		<title>登录引导</title>
		<!-- 引入css -->
		<link rel="stylesheet"  type="text/css" href="${pageContext.request.contextPath }/css/login.css" />
	</head>
	<body>
		<!-- 头部   -->
		<header>
			<div class="registration">
				<div class="logo">
					<span>蓝鸟云课堂</span> <span class="name"><a href="login.jsp">登录</a></span> <span
						class="_name"><a  href="register.jsp">注册</a></span>
				</div>
			</div>

		</header>
		
		<!-- 主要部分  -->
		<div class="main">
			
			<!-- 我是学生  -->
			<div class="studen">
				<img src="img/xueyuan.png"/>
				<span class="text1">我是学生</span>
				<div class="gologin">
								<a href="login.jsp">去登录</a>
			</div>
			</div>
			
			<!-- 我是教师  -->
			<div class="teacher">
				<img src="img/peilian.png"/>
				<span class="ttext1">我是教师</span>
				<div class="tgologin">
								<a href="adminLogin.jsp">去登录</a>
			</div>
			</div>
			
		</div>
		
	</body>
</html>

