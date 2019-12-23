<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>西域游缴费</title>
    <meta name="keywords" content="西域游缴费">
    <meta name="description" content="西域游缴费">
    <link rel="shortcut icon" href="favicon.ico"> 
	<link href="../css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="../css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="../css/animate.min.css" rel="stylesheet">
    <link href="../css/style.min.css?v=4.0.0" rel="stylesheet"><base target="_blank">
    <!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
      <script type="text/javascript" src="../easyui/date.js"></script>
</head>

<body class="gray-bg">

    
    <script src="../easyui/jquery.min.js?v=2.1.4"></script>
    <script src="../js/bootstrap.min.js?v=3.3.5"></script>   
    <div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
								<div class="ftitle">用户信息</div>
								<form id="fm" method="post" novalidate>
								<div class="fitem">
										<label>编 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp号: 编号自动生成</label>
										<input name="recId" type="hidden">
									</div>
									<div class="fitem">
										<label>车 &nbsp牌 &nbsp号:</label>
										<input name="recCarId" class="easyui-validatebox" required="true">
									</div>
									<div class="fitem">
										<label>车 &nbsp位 &nbsp号:</label>
										<input name="carStaId" class="easyui-validatebox" required="true">
									</div>
									<div class="fitem">
										<label>进入日期:</label>
										<input name="recEntryDate" class="easyui-validatebox" required="true">
									</div>
									<div class="fitem">
										<label>离开日期:</label>
										<input name="recLeaveDate" class="easyui-validatebox" >
									</div>
									<div class="fitem">
										<label>停车时间:</label>
										<input name="recTime" class="easyui-validatebox" >
									</div>
									<div class="fitem">
										<label>收费标准:</label>
										<input name="recCharge" class="easyui-validatebox" required="true">
									</div>
									<div class="fitem">
										<label>总 &nbsp费 &nbsp用:</label>
										<input name="recCost" class="easyui-validatebox" >
									</div>
									
								</form>
	</div>
	<div>
		<a class="btn btn-primary" href="#" role="button">保 存</a>
		<a href="javascript:void(0)" onclick="removePanel()">取消</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">保存</a>
	</div>
</body>
</html>
	

							
							
								
							