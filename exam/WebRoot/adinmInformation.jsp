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
<html lang="zh">
<head>
<meta charset="UTF-8">
<title>蓝鸟云课堂</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/Information.css" />
<script src="${pageContext.request.contextPath }/Js/jquery-1.12.4.js"
	type="text/javascript" charset="utf-8"></script>
<script src="http://cdn.bootcss.com/jquery/1.11.0/jquery.min.js"
	type="text/javascript"></script>
<script>
	window.jQuery
			|| document.write('<script src="js/jquery-1.12.4.js"><\/script>');
</script>
<script type="text/javascript">
	$(function() {

		var imgL = $(".pic img").size();
		var deg = 360 / imgL;
		var roY = 0, roX = -10;
		var xN = 0, yN = 0;
		var play = null;

		$(".pic img").each(function(i) {
			$(this).css({
				"transform" : "rotateY(" + i * deg + "deg) translateZ(300px)"
			});
			$(this).attr('ondragstart', 'return false');
		});

		$(document)
				.mousedown(
						function(ev) {
							var x_ = ev.clientX;
							var y_ = ev.clientY;
							clearInterval(play);
							console.log('我按下了');
							$(this)
									.bind(
											'mousemove',
											function(ev) {
												/*获取当前鼠标的坐标*/
												var x = ev.clientX;
												var y = ev.clientY;
												/*两次坐标之间的距离*/
												xN = x - x_;
												yN = y - y_;

												roY += xN * 0.2;
												roX -= yN * 0.1;
												console.log('移动');
												//$('body').append('<div style="width:5px;height:5px;position:absolute;top:'+y+'px;left:'+x+'px;background-color:red"></div>');

												$('.pic')
														.css(
																{
																	transform : 'perspective(800px) rotateX('
																			+ roX
																			+ 'deg) rotateY('
																			+ roY
																			+ 'deg)'
																});
												/*之前的鼠标坐标*/
												x_ = ev.clientX;
												y_ = ev.clientY;

											});
						})
				.mouseup(
						function() {
							$(this).unbind('mousemove');
							var play = setInterval(
									function() {

										xN *= 0.95;
										yN *= 0.95;
										if (Math.abs(xN) < 1
												&& Math.abs(yN) < 1) {
											clearInterval(play);
										}
										roY += xN * 0.2;
										roX -= yN * 0.1;
										$('.pic')
												.css(
														{
															transform : 'perspective(800px) rotateX('
																	+ roX
																	+ 'deg) rotateY('
																	+ roY
																	+ 'deg)'
														});

									}, 30);

						});

	});
</script>
<script type="text/javascript">
	$(function() {

		$(".tidy").hide();
		$(".score").hide();
		$("._header").show();
		$(".content").hide();
		$(".one")
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
		$(".two")
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
		$(".san")
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
		$(".shouye,.shouye").click(function() {
			$(".content").hide();
			$(".score").hide();
			$("._header").show();
			$(".tidy").hide();
		});
		$(".tiKu,._tiKu").click(function() {
			$(".content").show();
			$(".score").hide();
			$("._header").hide();
			$(".tidy").hide();
		});
		$(".kaoShi,._kaoShi").click(
				function() {
					$(".score").hide();
					$(".content").hide();
					$("._header").hide();
					$(".tidy").show();
					$.post("${pageContext.request.contextPath }/paper",
							"discern=query", function(list) {
								console.info(list);
								if (list != null) {
									var shijuanUL = $("#shijuanUL");
									shijuanUL.empty();
									for (var i = 0; i < list.length; i++) {
										var obj = list[i];
										var liObj = $("<li></li>");
										var $a = $("<a></a>").html(obj.paperName);
										$a.attr("href","${pageContext.request.contextPath}/careful?paperID="+obj.paperId+"&paperName="+obj.paperName);
										liObj.append($a);
										shijuanUL.append(liObj);
									}
								}

							}, "JSON");
				});
		$(".selectStudentScore,._score").click(function() {
			$(".score").show();
			$(".content").hide();
			$("._header").hide();
			$(".tidy").hide();
			$.post(
					"${pageContext.request.contextPath }/paper",
					"discern=query",
					function(list){
						var se = $(".paperName");
						//移除所有元素
						se.empty();
						var op =  $("<option/>").text(
						"随机试卷").val("随机试卷");
						se.append(op);
						for(var i = 0;i<list.length; i++){
							var obj = list[i];
							var liObj = $("<option/>").text(
									obj.paperName).val(obj.paperName);
							se.append(liObj);
						}
					},
					"JSON"
				);
		});
		$(".exit")
				.click(
						function() {
							if (confirm("确认退出吗?")) {
								location.href = "${pageContext.request.contextPath }/adminLogin.jsp";
							}
						});

		$(".submit").click(
				function() {
					var $paperName = $(".wenBen").val();
					if ($paperName.trim()!="") {
					$.post("${pageContext.request.contextPath }/paper",
							"discern=add&paperName=" + $paperName, function(
									list) {
								if (list != null) {
									var shijuanUL = $("#shijuanUL");
									shijuanUL.empty();
									for (var i = 0; i < list.length; i++) {
										var obj = list[i];
										var liObj = $("<li></li>");
										var $a = $("<a></a>").html(obj.paperName);
										$a.attr("href","${pageContext.request.contextPath}/careful?paperID="+obj.paperId+"&paperName="+obj.paperName);
										liObj.append($a);
										shijuanUL.append(liObj);
									}
									$(".wenBen").val("");
								}
							}, "JSON");
					}else{
						alert("试卷名不能为空");	
					}
				});
		
		
		$(".btnse").click(function(){
			var $stuName = $(".stuName").val();
			var $paperName = $(".paperName").val();
			if ($stuName.trim()!="") {
			$.post(
					"${pageContext.request.contextPath }/percent",
					"stuName="+$stuName+"&paperName="+$paperName,
					function(map){
						var se = $("#table");
						//移除所有元素
						se.empty();
						var $td1 = $("<li>考生姓名</li>");
						var $td2 = $("<li>试卷名称</li>");
						var $td5 = $("<li>合格率</li>");
						se.append($td1).append($td2).append($td5);
							var $br = $("<br/>");
							var $td1 = $("<li></li>")
							.text($stuName);
							var $td2 = $("<li></li>")
							.text($paperName);
							var $td3 = $("<li></li>")
							.text(map);
							se.append($br).append($td1).append($td2).append($td3);
					},
					"text"
				);
			}else{
				alert("学生姓名不能为空");
			}
		});
		
	});
</script>

</head>
<body class="bady">
	<!--
        	作者：offline
        	时间：2019-09-21
        	描述：主页面头部在线考试标题、显示用户名
        -->
	<div class="registration">
		<div class="logo">
			<span>蓝鸟云课堂</span> <span class="name">${admin.adminName }</span> <span
				class="_name">欢迎：</span>
		</div>
	</div>

	<!--
       	作者：offline
       	时间：2019-09-21
       	描述：主页面头部导航栏
       -->
	<div class="header">
		<ul class="label">
			<li class="shouye" ><a href="#">首页</a></li>
			<li class="kaoShi"><a href="#">试卷管理</a></li>
			<li class="selectStudentScore"><a href="#">试卷合格率查询</a></li>
			<li class="tiKu"><a href="#">题库管理</a></li>
			<li class="exit" ><a href="#" >退出系统</a></li>
		</ul>
	</div>

	<!--
          	作者：offline
          	时间：2019-09-21
          	描述：题库管理页面
          -->
	<div class="_header">
		<div class="htmleaf-container">
			<div class="pic">
				<img class="_kaoShi" src="img/shijuan.png" title="试卷管理" /> <img
					class="_score" src="img/100.png" title="学生考试查询" /> <img
					class="_shouye" src="img/shouYe.png" title="首页" /> <img
					class="_tiKu" src="img/tiKu.png" title="题库管理" /> <img
					class="_kaoShi" src="img/shijuan.png" title="试卷管理" /> <img
					class="_score" src="img/100.png" title="学生考试查询" /> <img
					class="_shouye" src="img/shouYe.png" title="首页" /> <img
					class="_tiKu" src="img/tiKu.png" title="题库管理" />
				<p></p>
			</div>
		</div>
	</div>

	<div class="tidy">
		<span id="shiJuan">添加试卷</span>
		<span class="shiJuanSpan">（单击下方试卷名称查看试卷详细页面）</span>
		<form action="" method="post">
			<input class="wenBen" type="text" name="paperName" /> <input
				class="submit" type="button" value="添加试卷" />
		</form>
		
		
	
		<ul class="ul" id="shijuanUL">
		</ul>
	</div>
	<div class="content">
		<h2>题库、试卷</h2>
		<div class="one">
			<span>添加题库</span> <span>添加题目</span> <a href="addition.jsp">添加考题</a>
		</div>
		<div class="san">
			<span>试卷题目添加</span> <span>试卷题目添加</span> <a href="${pageContext.request.contextPath }/openPapers">添加考题</a>
		</div>
		<div class="two">
			<span>题库导入</span> <span>Excel批量导入</span> <a href="index.jsp">导入考题</a>
		</div>
	</div>

	<!--
         	作者：offline
         	时间：2019-09-21
         	描述:考生成绩查询页面
         -->
	<div class="score">
		<span class="labelname">考生成绩列表</span>
		<div class="select">
			<span>考生姓名:</span> <input class="stuName" type="text" /> <span>考生试卷：</span> 
				<select  class="paperName">
				</select>
				 <input type="button" class="btnse" value="查询" />
		</div>
		
			<ul  id="table" >
				
			</ul>
	</div>
</body>
</html>

