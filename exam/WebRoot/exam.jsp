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
<title>蓝鸟云课堂</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/exam.css" />
<script src=" ${pageContext.request.contextPath }/Js/jquery-1.12.4.js"></script>

<script type="text/javascript">
		//计时器
		var intDiff = parseInt(1800);//倒计时总秒数量
		function timer(intDiff) {
			window.setInterval(function() {
				var minute = 0, second = 0;//时间默认值        
				if (intDiff > 0) {
					minute = Math.floor(intDiff / 60);
					second = Math.floor(intDiff) - (minute * 60);
				}
				if (minute <= 9)
					minute = '0' + minute;
				if (second <= 9)
					second = '0' + second;
				$('#minute').html('<s></s>' + '倒计时:' + minute + '分');
				$('#second').html('<s></s>' + second + '秒');
				intDiff--;
				if (intDiff <= 0) {
					clearInterval(timer); //定时器清除；
					$("input").attr("disabled","disabled");
				}
			}, 1000);
		}
		$(function() {
			timer(intDiff);
		});

		function xx(event) {
			var radioObj = event.currentTarget; // 事件源---哪个控件  name_3
			var index = $(radioObj).attr("class").split("_")[1];
			$("#td" + index).css("background", "#00C356");
		}

		$(function() {
			for (var i = 1; i <= 20; i++) {
				var $radio = $("input[class=true_" + i + "]");
				$radio.on("click", xx);
			}

			$("ul div:even").css({
				"background" : "#F2F2F2"
			});
			$("ul div:odd").css({
				"background" : "#FFFFFF"
			});
			
			$(".btn").click(function () {
				var a = confirm("确认返回吗?(返回后所有题不会被保存)");
				if (a) {
					location.href = "${pageContext.request.contextPath }/stuInformation.jsp";
				}
			});

		});
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
	<div class="table">
		<span id="td1"><a href="#div1">1</a></span> <span id="td2"><a
			href="#div2">2</a></span> <span id="td3"><a href="#div3">3</a></span> <span
			id="td4"><a href="#div4">4</a></span> <span id="td5"><a
			href="#div5">5</a></span> <span id="td6"><a href="#div6">6</a></span> <span
			id="td7"><a href="#div7">7</a></span> <span id="td8"><a
			href="#div8">8</a></span> <span id="td9"><a href="#div9">9</a></span> <span
			id="td10"><a href="#div10">10</a></span> <span id="td11"><a
			href="#div11">11</a></span> <span id="td12"><a href="#div12">12</a></span> <span
			id="td13"><a href="#div13">13</a></span> <span id="td14"><a
			href="#div14">14</a></span> <span id="td15"><a href="#div15">15</a></span> <span
			id="td16"><a href="#div16">16</a></span> <span id="td17"><a
			href="#div17">17</a></span> <span id="td18"><a href="#div18">18</a></span> <span
			id="td19"><a href="#div19">19</a></span> <span id="td20"><a
			href="#div20">20</a></span>
	</div>

	<h1>随机考试</h1>
	<div class="tele" >
	<h3>随机20道题,每道题5分,包括单选和多选,共30分钟</h3>
	</div>
	
	<div class="zhu">
		<form  id="form"  action=" ${pageContext.request.contextPath }/dati" method="post">
			<c:forEach items="${examList }" var="exam" varStatus="status">
				<ul>
					<div>
						<li class="issueText" id="div${status.index + 1 }"><span
							class="index">${status.index + 1 }.</span>${exam.issueText }</li> <input
							type="hidden" name="issueId${status.index }"
							value="${exam.issueId }" />
						<c:if test="${exam.issueType==1 }">
							<li class="li"><span>A. </span><input type="radio"
								class="true_${status.index+1}" name="xuanZe${status.index }"
								value="a"> <span>${exam.answerA }</span></li>
							<li class="li"><span>B. </span><input type="radio"
								class="true_${status.index+1}" name="xuanZe${status.index }"
								value="b"> <span>${exam.answerB }</span></li>
							<li class="li"><span>C. </span><input type="radio"
								class="true_${status.index+1}" name="xuanZe${status.index }"
								value="c"> <span>${exam.answerC }</span></li>
							<li class="li"><span>D. </span><input type="radio"
								class="true_${status.index+1}" name="xuanZe${status.index }"
								value="d"> <span>${exam.answerD }</span></li>
						</c:if>
						<c:if test="${exam.issueType==2 }">
							<li class="li"><span>A. </span><input type="checkbox"
								class="true_${status.index+1}" name="xuanZe${status.index }"
								value="a"> <span>${exam.answerA }</span></li>
							<li class="li"><span>B. </span><input type="checkbox"
								class="true_${status.index+1}" name="xuanZe${status.index }"
								value="b"> <span>${exam.answerB }</span></li>
							<li class="li"><span>C. </span><input type="checkbox"
								class="true_${status.index+1}" name="xuanZe${status.index }"
								value="c"> <span>${exam.answerC }</span></li>
							<li class="li"><span>D. </span><input type="checkbox"
								class="true_${status.index+1}" name="xuanZe${status.index }"
								value="d"> <span>${exam.answerD }</span></li>
						</c:if>
					</div>
				</ul>
			</c:forEach>
			<input type="submit" id="btnCommit" value="提交" /> <input class="btn"
				type="button" value="返回" />
		</form>
	</div>
	<div class="timer">
		<strong id="minute">倒计时:0分</strong> <strong id="second">0秒</strong>
	</div>
	
	
</body>
</html>

