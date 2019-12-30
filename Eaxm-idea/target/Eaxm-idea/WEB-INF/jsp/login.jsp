<%--
  Created by IntelliJ IDEA.
  User: 彭依凝
  Date: 2019/12/16
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <title>在线考试</title>
    <link rel="shortcut icon" type="image/x-icon" href="Index/style/images/favicon.ico">
    <meta name="x5-orientation" content="portrait">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
</head>
<body class="page_index">
<input type="hidden" id="hidIndustry" value=""/>
<div class="agreement-container">
    <div class="top-header">
    </div>
    <div i="content" class="ui-dialog-content">
        <div class="rl-modal-header">
            <h1 id="tabheader"><span t="register" onclick="doChangeTab('register')">注册</span>  <a id="btnsignininfo" class="tabheader-signin" style="color:#1C87D5;" target="_blank" href="login.html">我有账号，去登录</a></h1>
        </div>

        <div id="fail" class="rl-modal-body" style="padding:30px 30px;display:none;">
            <div class="clearfix">
                <div class="l-left-wrap">
                    <div class="rlf-group" style="text-align: center">
                        <img src="../Index/Style/images/fail.png" style="width:100px;height:100px;"><br>
                        <br>
                        <p class="rlf-tip-wrap"><span style="font-size: 16px; color:#000;" id="failmsg">注册失败</span></p>
                        <br />
                        <div id="div2" style="font-size:13px;">注意：如果您是考生，请联系您的老师获取账号</div>
                    </div>
                    <div class="rlf-group clearfix" style="text-align:center">
                        <p class="rlf-tip-wrap " id="P2"></p>
                    </div>
                </div>
            </div>
        </div>
        <div id="register" class="rl-modal-body" style="padding:30px 30px;">


            <form method="post" action="${pageContext.request.contextPath}/student/login">
            <div class="rlf-group">
                <input id="txtName" class="rlf-input rlf-input-nick" type="text" placeholder="请输入用户名称" autocomplete="off" data-validate="nick" name="stuName">
                <p class="rlf-tip-wrap"><span style="display: none; color: rgb(170, 173, 173);">请输入用户名称，2-18位中英文、数字或下划线</span></p>
            </div>
            <div class="rlf-group">
                <input id="txPassword" class="rlf-input rlf-input-nick" type="password" placeholder="请输入密码" autocomplete="off" data-validate="nick" name="stuPwd">
                <p class="rlf-tip-wrap"><span style="display: none; color: rgb(170, 173, 173);">请输入密码</span></p>
            </div>
<%--            <div class="rlf-group">--%>
<%--                <input id="txtPhone" class="rlf-input rlf-input-nick" type="text" placeholder="请输入手机号码" autocomplete="off" data-validate="nick">--%>
<%--                <p class="rlf-tip-wrap"><span style="display: none; color: rgb(170, 173, 173);">请输入11位手机号码</span></p>--%>
<%--            </div>--%>

           <input type="submit" class="rlf-btn-blue btn-full r" id="signup-btn" style="color: #fff;width:100%; text-decoration: none" value="注册" ></input>
            <div style="font-size: 12px; margin-top: 20px;"><a id="btnagreement" style="text-decoration: none;color:#339add" target="_blank" href="../agreement.html">《考试云使用条款与隐私保护》</a>    </div>
        </div>
        </form>
        <div id="Div1" class="rl-model-footer" style="background: #fff">
            <div style="color: #c2c2c2; font-size: 12px; font-family: 'Courier New';text-align:center">Copyright © 2019 <a id="aBottom" style="text-decoration: none;color:#c2c2c2" href="/">考试云</a> </div>
        </div>
    </div>
</div>
</body>
</html>
