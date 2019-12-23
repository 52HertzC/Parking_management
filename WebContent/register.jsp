<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>西域游停车后台 - 注册</title>
    <meta name="keywords" content="西域游停车后台">
    <meta name="description" content="西域游停车后台啊哈啊">

    <link rel="shortcut icon" href="favicon.ico"> 
	<link href="css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min.css?v=4.0.0" rel="stylesheet">
    <!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
     <script type="text/javascript" src="easyui/jquery.min.js"></script>
      <script type="text/javascript" src="easyui/easyloader.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>
                
                <h1 class="logo-name"><img src="img/logo-lin.png"></h1>

            </div>
            <h3>欢迎使用 西域游停车后台</h3>

            <form class="m-t" id="fm" method="post" >
                <div class="form-group">
                    <input type="text" name="username" class="form-control" placeholder="用户名" required="">
                </div>
                <div class="form-group">
                    <input type="password" name="password" class="form-control" placeholder="密码" required="">
                </div>
                 <div class="form-group">
                    <input type="hidden" name="userRoleId" value="1" class="form-control" placeholder="用户名" required="">
                </div>
                 <div class="form-group">
                    <input type="text" name="userCarId" class="form-control" placeholder="车牌号" required="">
                </div>
                <a  onclick="saveUser()" class="btn btn-primary block full-width m-b">注 册</a>
 				</form>

                <p class="text-muted text-center"> <a href="#"><small>忘记密码了？</small></a> | <a href="login.jsp">返回登录界面</a>
                </p>

           
        </div>
    </div>
    <script src="js/bootstrap.min.js?v=3.3.5"></script>   

</body>
<script type="text/javascript">
function saveUser(){
	$('#fm').form('submit',{
		url: 'user/save.action',
		success: function(result){
			var result = eval('('+result+')');
			if (result.status == 200){
				alert('注册成功!');
				window.location.href="login.jsp";
			} else {
				alert('注册失败!');
				window.location.href="register.jsp";
			}
		}
	});
}
</script>
</html>