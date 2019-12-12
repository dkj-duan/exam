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
<title>蓝鸟云课堂考生分数</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/score.css" />
<script src="${pageContext.request.contextPath }/Js/jquery-1.12.4.js"
	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(function() {
		$("#btn").click(function(){
			location.href = "${pageContext.request.contextPath }/stuInformation.jsp";
		});
	});
	 function newExam() {
			location.href = "${pageContext.request.contextPath }/false.jsp";
			}
</script>
</head>
<body>

	<div class="score">
		<span id="text">恭喜你:</span><span id="name">${stu.stuName }</span> <br />
		<span id="score">本次考试:</span><span id="fen">${score }</span><span
			id="score">分</span> <br /> <input type="button" id="new"
			value="查看错题"  onclick="newExam()"/> <input type="button" id="btn" value="返回" />
	</div>


</body>
</html>

