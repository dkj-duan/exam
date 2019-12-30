<%--
  Created by IntelliJ IDEA.
  User: 彭依凝
  Date: 2019/12/19
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>


<head>
    <title></title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/student.css" />
    <link rel="stylesheet"
          href="${pageContext.request.contextPath }/css/normalize.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath }/css/style.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"
            type="text/javascript" charset="utf-8"></script>


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
            $(".submit").click(
                function() {
                    var jsonStr = $(".stuId").val();//获得所有表单
                    var pwd = $(".pwd").val();//获得新密码；
                    var qurRen = $(".qurRen").val();//获得确认密码;
                    if (pwd == qurRen) {
                        $.post("${pageContext.request.contextPath }/student/updatePwd",
                            "stuId=" + jsonStr + "&pwd=" + pwd,
                            function(stu) {
                                $("#span").html(stu.mess);
                                $(".pwd").val("");
                                $(".qurRen").val("");
                            }, "JSON");
                    } else {
                        $("#span").html("两次密码不一致");
                        $(".pwd").val("");
                        $(".qurRen").val("");
                    }
                });



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

            $("._header").show();
            $("._kaoShi").hide();
            $(".ChangePassword").hide();
            $(".HomePage").hide();
            $(".paper").hide();

            $(".tiKu,._tiKu").click(function() {
                $(".HomePage").hide();
                $(".ChangePassword").show();
                $("._kaoShi").hide();
                $("._header").hide();
                $(".paper").hide();
            });
            $(".shouye,._shouye").click(function() {
                $("._header").show();
                $(".paper").hide();
                $(".HomePage").hide();
                $(".ChangePassword").hide();
                $("._kaoShi").hide();
            });
            $(".find,._score").click(function() {
                $(".HomePage").show();
                $(".paper").hide();
                $(".ChangePassword").hide();
                $("._kaoShi").hide();
                $("._header").hide();
            });
            $(".kaoShi,.kaoShi_").click(function() {
                $("._header").hide();
                $(".paper").hide();
                $("._kaoShi").show();
                $(".scoreInquiry").hide();
                $(".HomePage").hide();
                $(".ChangePassword").hide();
            });
            $(".exit").click(function(){
                if (confirm("确认退出吗?")) {
                    location.href = "${pageContext.request.contextPath }/login.jsp";
                }
            });


            $(".a").click(function(){
                $("._kaoShi").hide();
                $(".paper").show();
                $("._header").hide();
                $(".scoreInquiry").hide();
                $(".HomePage").hide();
                $(".ChangePassword").hide();
                $.post(
                    "${pageContext.request.contextPath }/paper",
                    "discern=query",
                    function(list){
                        var se = $(".paperSe");
                        //移除所有元素
                        se.empty();
                        for(var i = 0;i<list.length; i++){
                            var obj = list[i];
                            var liObj = $("<option/>").text(
                                obj.paperName).val(obj.paperId);
                            se.append(liObj);
                        }
                    },
                    "JSON"
                );
            });
            $("#btns").click(function(){
                $(".paper").hide();
                $("._kaoShi").show();
                $("._header").hide();
                $(".scoreInquiry").hide();
                $(".HomePage").hide();
                $(".ChangePassword").hide();
            });
        });
    </script>
</head>
<body class="bady">
<div class="registration">
    <div class="logo">
        <span>在线考试系统</span> <span class="name">${stu.stuname}</span> <span
            class="_name">欢迎：</span>
    </div>
</div>
<div class="header">
    <ul class="label">
        <li class="shouye" ><a href="#">首页</a></li>
        <li class="kaoShi"><a href="#">在线考试</a></li>
        <li class="find"><a href="#" >成绩查询</a></li>
        <li class="tiKu"><a href="#">修改密码</a></li>
        <li class="exit"><a href="#" >退出系统</a></li>
    </ul>
</div>
<div class="_header">
    <div class="htmleaf-container">
        <div class="pic">
            <img class=" kaoShi_" src="img/shijuan.png" title="在线考试" />
            <img class="_score" src="img/100.png" title="成绩查询" />
            <img class="_shouye"  src="img/shouYe.png" title="首页" />
            <img class="_tiKu" src="img/miMa.png" title="修改密码" />
            <img class="kaoShi_" src="img/shijuan.png" title="在线考试" />
            <img class="_score"  src="img/100.png" title="成绩查询" />
            <img class="_shouye"  src="img/shouYe.png" title="首页" />
            <img class="_tiKu"  src="img/miMa.png" title="修改密码" />
        </div>
    </div>
</div>

<div class="_kaoShi">
    <div class="content">
        <span class="s">分类选择</span>
        <div class="one">
            <span>随机考试</span> <span>题库随机答题</span> <a
                href="${pageContext.request.contextPath }/exam?exam=cha">开始考试</a>
        </div>
        <div class="two">
            <span>试卷做题</span> <span>针对性做题</span> <a class="a" href="#">开始考试</a>
        </div>
    </div>
</div>
<div class="HomePage">

    <table class="table" border="1px">
        <tr>
            <th>网点名称</th>
            <th>所在城区</th>
            <th>网点地址</th>
            <th>联系电话</th>
            <th>操作</th>
        </tr>

    </table>

</div>
<div class="paper">
    <span class="s">请选择试卷</span>
    <form action="${pageContext.request.contextPath }/newExam"  method="post" >
        <select class="paperSe" name="paper">
        </select >
        <input type="button" id="btns" value="返回"/>
        <input type="submit" id="sub" value="确定"/>
    </form>

</div>
<div class="ChangePassword">
    <form id="from" action="${pageContext.request.contextPath }"
          method="post">
        <ul class="reg_ul">
            <span id="span"></span>
            <input type="hidden" class="stuId" name="stuId" value=" ${stu.stuid}" />
            <li><span>用户名：</span> <input type="text" name=""
                                         value="${stu.stuname} " placeholder="4-8位用户名" class="reg_user"
                                         disabled="disabled"> <span class="tip user_hint"></span></li>
            <li>
                <span>原密码：</span>
                <input type="password" name="" value="" placeholder="原密码" class="reg_email">
                <span class="tip email_hint"></span>
            </li>
            <li><span>新密码：</span> <input type="password" class="pwd"
                                         name="pwd" value="" placeholder="6-16位密码" class="reg_password">
                <span class="tip password_hint"></span></li>
            <li><span>确认密码：</span> <input type="password" class="qurRen"
                                          name="" value="" placeholder="确认密码" class="reg_confirm"> <span
                    class="tip confirm_hint"></span></li>
        </ul>
        <input type="button" value="修改密码" name="button" class="submit" />
    </form>
</div>


</body>
</html>


