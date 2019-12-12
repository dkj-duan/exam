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
<title>添加试题</title>
<link rel="stylesheet" type="text/css" href="css/addition.css" />
<script src="Js/jquery-1.12.4.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(function() {
		$(".btn").click(function() {
			location.href = "adinmInformation.jsp";
		});
	});
</script>
</head>

<body>
	<section>
	<div class="_div">

		<c:if test="${mass!=null }">
			<span>${mass }</span>
		</c:if>
		<ul>
			<span class="text">添加考试题目</span>
			<form action="${pageContext.request.contextPath }/newExam" method="post">

				<input type="hidden" name="exam" value="add">
				<li>题目内容* <textarea class="issueText" cols="10" rows="10"
						name="issueText"></textarea>
				</li>
				<li><span class="right">选择试卷:</span> <select name="paperId"
					class="issueType">
					<c:forEach var="exam" items="${pspers }">
						<option value="${exam.paperId }">${exam.paperName }</option>		
					</c:forEach>
						
				</select></li>
				<li><span class="right">本题类型:</span> <select name="issueType"
					class="issueType">
						<option value="1">单选</option>
						<option value="2">多选</option>
				</select></li>
				<li><span class="A">选项A：</span> <input type="text"
					class="answerA" name="answerA" value="" /></li>
				<li><span class="B">选项B：</span> <input type="text"
					class="answerB" name="answerB" value="" /></li>
				<li><span class="C">选项C：</span> <input type="text"
					class="answerC" name="answerC" value="" /></li>
				<li><span class="D">选项D：</span> <input type="text"
					class="answerD" name="answerD" value="" /></li>
				<li><span class="bianZhun">答案：</span> <input class="answer"
					type="text" name="answer" value="" /></li><span>（多选题答案请用","隔开）</span>
				<li><input class="submit" type="submit" value="添加" /> <input
					class="btn" type="button" value="返回" /></li>
			</form>
		</ul>
	</div>
	</section>
</body>
</html>

