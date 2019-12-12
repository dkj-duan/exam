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
					location.href = "${pageContext.request.contextPath }/stuInformation.jsp";
				}
			});
		});
	 function newExam() {
			location.href = "${pageContext.request.contextPath }/exam?exam=cha";
	}
	</script>
</head>
<body>
	<header>
	<div class="registration">
		<div class="logo">
			<span>蓝鸟云课堂</span> <span class="name">${stu.stuName }</span> <span
				class="_name">欢迎：</span>
		</div>
	</div>
	</header>

	<h1>错题查看</h1>
	<div class="tele" >
	<h3>考试错题查看页面,做错的题目都会记录在该页面</h3>
	</div>
	
	<div class="zhu">
			<c:forEach items="${cuoTi }" var="exam" varStatus="status">
				<ul>
					<div>
						<li class="issueText" id="div${status.index + 1 }"><span
							class="index">${status.index + 1 }.</span>${exam.issueText }</li> <input
							type="hidden" name="issueId${status.index }"
							value="${exam.issueId }" />
						<c:if test="${exam.issueType==1 }">
							<li class="li"><span>A. </span><input  disabled="disabled"
								<c:if test="${daAn.get(status.index).answer=='a' }">
									checked="checked"
								</c:if>
							type="radio"	
								class="true_${status.index+1}" name="xuanZe${status.index }"
								value="a"> <span>${exam.answerA }</span></li>
							<li class="li"><span>B. </span><input  disabled="disabled"
								<c:if test="${daAn.get(status.index).answer=='b' }">
									checked="checked"
								</c:if>
							type="radio"
								class="true_${status.index+1}" name="xuanZe${status.index }"
								value="b"> <span>${exam.answerB }</span></li>
							<li class="li"><span>C. </span><input  disabled="disabled"
								<c:if test="${daAn.get(status.index).answer=='c' }">
									checked="checked"
								</c:if>
							type="radio"
								class="true_${status.index+1}" name="xuanZe${status.index }"
								value="c"> <span>${exam.answerC }</span></li>
							<li class="li"><span>D. </span><input disabled="disabled"
								<c:if test="${daAn.get(status.index).answer=='d' }">
									checked="checked"
								</c:if>
							 type="radio"
								class="true_${status.index+1}" name="xuanZe${status.index }"
								value="d"> <span>${exam.answerD }</span></li>
								<span class="true">正确答案：${daAn.get(status.index).answer }</span>
								<span class="false">你的答案：${stuCuoTi.get(status.index) }</span>
						</c:if>
						<c:if test="${exam.issueType==2 }">
							<li class="li"><span>A. </span><input disabled="disabled"
								<c:if test="${fn:contains(daAn.get(status.index).answer, 'a')}">
    									checked="checked"
								</c:if>  
								type="checkbox"
								class="true_${status.index+1}" name="xuanZe${status.index }"
								value="a"> <span>${exam.answerA }</span></li>
							<li class="li"><span>B. </span><input disabled="disabled"
								<c:if test="${fn:contains(daAn.get(status.index).answer, 'b')}">
    									checked="checked"
								</c:if> 
							 type="checkbox"
								class="true_${status.index+1}" name="xuanZe${status.index }"
								value="b"> <span>${exam.answerB }</span></li>
							<li class="li"><span>C. </span><input  disabled="disabled"
								<c:if test="${fn:contains(daAn.get(status.index).answer, 'c')}">
    									checked="checked"
								</c:if> 
							type="checkbox"
								class="true_${status.index+1}" name="xuanZe${status.index }"
								value="c"> <span>${exam.answerC }</span></li>
							<li class="li"><span>D. </span><input disabled="disabled"
								<c:if test="${fn:contains(daAn.get(status.index).answer, 'd')}">
    									checked="checked"
								</c:if> 
							
							 type="checkbox"
								class="true_${status.index+1}" name="xuanZe${status.index }"
								value="d"> <span>${exam.answerD }</span></li>
								<span class="true">正确答案：${daAn.get(status.index).answer }</span>
								<span class="false">你的答案：${stuCuoTi.get(status.index) }</span>
						</c:if>
					</div>
				</ul>
			</c:forEach>
			<input type="button" id="btnCommit" value="再来一套"  onclick="newExam()"/> <input class="btn"
				type="button" value="返回" />
	</div>

</body>
</html>

