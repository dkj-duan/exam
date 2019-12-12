<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>蓝鸟云课堂</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/exam.css" />
<script src=" ${pageContext.request.contextPath }/Js/jquery-1.12.4.js"></script>

<script type="text/javascript">
	$(function(){
			$("ul div:even").css({
				"background" : "#F2F2F2"
			});
			$("ul div:odd").css({
				"background" : "#FFFFFF"
			});
			
			$(".btn").click(function () {
				var a = confirm("确认返回吗?");
				if (a) {
					location.href = "${pageContext.request.contextPath }/adinmInformation.jsp";
				}
			});
		});
	 function newExam(id) {
		
		 if (confirm("是否删除本套试卷!")) {
			 location.href = "${pageContext.request.contextPath }/newExam?paper="+id+"&exam=del";
		}	
	}
	</script>
</head>
<body>
	<header>
	<div class="registration">
		<div class="logo">
			<span>蓝鸟云课堂</span> <span class="name">${admin.adminName }</span> <span
				class="_name">欢迎：</span>
		</div>
	</div>
	</header>

	<h1>${paperName }</h1>
	<div class="tele" >
	<h3>${paperName }  试卷详细信息  共计${count }道题目</h3>
	</div>
	
	<div class="zhu">
			<c:forEach items="${newExamlist }" var="exam" varStatus="status">
				<ul>
					<div>
						<li class="issueText" id="div${status.index + 1 }"><span
							class="index">${status.index + 1 }.</span>${exam.issueText }</li> <input
							type="hidden" name="issueId${status.index }"
							value="${exam.issueId }" />
						<c:if test="${exam.issueType==1 }">
							<li class="li"><span>单选题 </span>
								<span class="true">正确答案：${exam.answer }</span>
						</c:if>
						<c:if test="${exam.issueType==2 }">
							<li class="li"><span>多选题</span>
								<span class="true">正确答案：${exam.answer }</span>
						</c:if>
					</div>
				</ul>
			</c:forEach>
			<input type="button" id="btnCommit" value="删除"  onclick="newExam(${paperId})"/> <input class="btn"
				type="button" value="返回" />
	</div>

</body>
</html>

