<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>蓝鸟云课堂</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="${pageContext.request.contextPath }/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jquery-easyui-1.4.1/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jquery-easyui-1.4.1/themes/icon.css">

<script type="text/javascript">
  $(function(){
	Init();//打开页面就去查询了
 });
 
  //我去查询所有用户信息了
 function Init(){
  $('#excel').datagrid({
		    type : 'post',
			url : '${pageContext.request.contextPath }/UserJsonServlet',
	    	loadMsg : '数据加载中,请稍等!!!!!!!!',
			nowrap : false,
			striped : true,
			fit : true,
			pagination:true,
			columns : [[
						 {field :'checkbox',checkbox:true},
			             {field : 'issueId',title : '考题编号',width : 100,align:'center'}, 
			             {field : 'issueText',title : '考试内容',width : 120,align:'center'}, 
			             {field : 'issueType',title : '考试类型',width : 100,align:'center'}, 
			             {field : 'score',title : '考题分数',width : 120,align:'center'}, 
			             {field : 'answerA',title : '答案A',width : 150,align:'center'}, 
			             {field : 'answerB',title : '答案B',width : 150,align:'center'}, 
			             {field : 'answerC',title : '答案C',width : 150,align:'center'}, 
			             {field : 'answerD',title : '答案D',width : 280,align:'center'},
			             {field : 'answer',title : '考试答案',width : 280,align:'center'}
			             ]],
			             toolbar: [{
			            	width:'50',
			         		iconCls: 'icon-undo',
			         		handler: function(){ExcelImport();}
			         	},'-',{
			         		width:'50',
			         		iconCls: 'icon-redo',
			         		handler: function(){ExcelExport();}
			         	}]
		});
 }
 
	/*Excel导入  */
	function ExcelImport() {
		alert("导入excel!")
		var url="./ExcelImportServlet";
		window.open(url);
	}

	/*Excel导出  */
    function ExcelExport(){
      alert("导出excel!")
      var url="./ExcelExportServlet";
      window.open(url);
}
	
	
	
	$(function() {
		$(".btn").click(function() {
			location.href = "adinmInformation.jsp";
		});
	});
</script>
</head>

<div align="center">
	<div class="easyui-panel" title="Excel导入导出示例"
		style="width: 930px; height: 350px; background: #fafafa;"
		data-options="border:false">
		<table id="excel"></table>
	</div> <input class="btn" type="button" value="返回" />
</div>

</body>
</html>
