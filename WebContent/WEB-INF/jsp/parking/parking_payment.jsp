<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>西域游管理平台</title>
    <link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../easyui/themes/color.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/xyy.css">
	<script type="text/javascript" src="../easyui/date.js"></script>
    <script type="text/javascript" src="../easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../easyui/easyloader.js"></script>
    <script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript">
		var url;
		function newUser(){
			$('#dlg').dialog('open').dialog('setTitle','新增用户');
			$('#fm').form('clear');
			url = 'save.action';
		}
		
		function editUser(){
			var row = $('#dg').datagrid('getSelections');
			if (row.length==1){
				$('#dlg').dialog('open').dialog('setTitle','编辑用户');
				$('#fm').form('load',row[0]);
				url = 'edit.action';
			}else if(row.length>1){
				$.messager.alert('提示','每次只能编辑一条数据，请重新选择!');
			}else{
				$.messager.alert('提示','请选择要编辑的数据!');
			}
		}
		function saveUser(){
			$('#fm').form('submit',{
				url: url,
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.status == 200){
						$.messager.alert('提示','保存成功!');
						$('#dlg').dialog('close');		// close the dialog
						$('#dg').datagrid('reload');	// reload the user data
					} else {
						$.messager.show({
							title: 'Error',
							msg: result.msg
						});
					}
				}
			});
		}
		function removeUser(){
			var row = $('#dg').datagrid('getSelections');
		
			if (row){
				$.messager.confirm('提示','确定要删除这条数据吗?',function(r){
					if (r){ 
						var parmIds = "";
	                    $.each(row, function (i, rows) {
	                        parmIds += rows.id + ",";
	                    });
	                    parmIds = parmIds.substring(0, parmIds.length - 1);
						$.post('delete.action',{id:parmIds},function(result){
							if (result.status == 200){
								$.messager.alert('提示','删除成功!');
								$("#dg").datagrid("clearSelections");
								$('#dg').datagrid('reload');	// reload the user data
							} else {
								$.messager.show({	// show error message
									title: 'Error',
									msg: result.msg
								});
							}
						},'json');
					}
				});
			}else{
				$.messager.alert('提示','请选择要删除的数据!');
			}
		}

	
		
		function newManage(){
			
			var row = $('#dg').datagrid('getSelected');
			
			if(row==null){
				$.messager.alert('提示','请选择要缴费的车辆!');
				return;
			}
			if(row.parkingRecord==null){
				$.messager.alert('提示','该车位没有车辆，请重新选择缴费车辆!');
				return;
			}
			var date=formatDateBoxFull(row.parkingRecord.recEntryDate);
			if (row){
				$('#jf').dialog('open').dialog('setTitle','缴费');
				$('#recEntryDate').datetimebox('setValue',date);
				var start=$('#recEntryDate').datetimebox('getValue');
				console.log(start)
				$('#jffm').form('load',row.parkingRecord);
				
			}else if(row.length>1){
				$.messager.alert('提示','每次只能选择一辆车缴费，请重新选择!');
			}else{
				$.messager.alert('提示','请选择要缴费的车辆!');
			}
		}
		

		function newCount(){
			var row = $('#dg').datagrid('getSelected');
			var date=formatDateBoxFull(row.parkingRecord.recEntryDate);
			$('#recEntryDate').datetimebox('setValue',date);
			var start=$('#recEntryDate').datetimebox('getValue');	
			var end=$('#recLeaveDate').datetimebox('getValue');
		   var startTimes = new Date(start).getTime();
			var endTimes = new Date(end).getTime();
			 var diff = endTimes - startTimes;    
			  var hour = Math.ceil((diff / 86400000)*24);     
			  var all = hour*2;
			  $('#recTime').val(hour);
			  var aa= $('#recTime').val();
			  $('#recCost').val(all);
			  var bb= $('#recCost').val();
		}
		
		function saveManage(){
			
			$('#jffm').form('submit',{
				url: 'updateRecord.action',
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.status == 200){
						$.messager.alert('提示','缴费成功!');
						$('#jf').dialog('close');	// close the dialog
						$("#dg").datagrid("clearSelections");
						$('#dg').datagrid('reload');	// reload the user data
						
					} else {
						$.messager.show({
							title: 'Error',
							msg: result.msg
						});
					}
				}
			});
		}
		
		function newStop(){
			
			var row = $('#dg').datagrid('getSelected');
			if(row==null){
				$.messager.alert('提示','请选择要停的车位!');
				return;
			}
			if(row.parkingRecord!=null){
				$.messager.alert('提示','该车位已有车辆，请重新选择车位停车!');
				return;
			}
			if (row){
				$('#yhtc').dialog('open').dialog('setTitle','用户停车');
				$('#mg').form('load',row);
				$('#tc').form('clear');
				url = 'saveRecord.action';	
			}else if(row.length>1){
				$.messager.alert('提示','每次只能选择一个车位，请重新选择!');
			}else{
				$.messager.alert('提示','请选择要停的车位!');
			}
		}
		
function saveRecord(){
	var recCarId=$('#recCarId').val();
	var mgid=$('#mgid').val();
	var staId=$('#staId').val();
	var area=$('#area').val();
	var ps=$('#ps').val();
	$('#manageCarId').val(recCarId);
	$('#id').val(mgid);
	$('#manageStaId').val(staId);
	$('#manageArea').val(area);
	$('#managePs').val(ps);
			$('#tc').form('submit',{
				url: url,
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.status == 200){
						$.messager.alert('提示','停车成功!');
						$('#yhtc').dialog('close');	// close the dialog
						$("#dg").datagrid("clearSelections");
						$('#dg').datagrid('reload');	// reload the user data
						
					} else {
						$.messager.show({
							title: 'Error',
							msg: result.msg
						});
					}
				}
			});
		}
function doSearch(value){
	 $('#dg').datagrid('load',{
		 manageCarId: value,
		});
	    }
	</script>
</head>
<body class="easyui-layout" style="margin:0 1px;background-color:#f5f5f5 !important;">  
    <div data-options="region:'center'" style="background:#fff;border:0;">
	    <div id="tb" class="easyui-tabs" data-options="tools:'#tab-tools',fit:true">
			<div  >
		        <div class="easyui-layout" data-options="fit:true">
					<div data-options="region:'center',border:false">
						<div data-options="region:'center',border:false" style="margin-top:20px;">
                            <table id="dg" title="用户列表" iconCls="icon-dingdan" class="easyui-datagrid" style="width:100%;height:400px;"
								data-options="idField:'id',rownumbers:false,fitColumns:true,pagination:true,singleSelect:true,collapsible:true,toolbar:'#toolbar',url:'list.action',method:'get',checkOnSelect:'true',selectOnCheck:'true'">
							<!---获取数据--->
							<thead>
								<tr>
									<th field="ck" checkbox="true"></th>
									<th data-options="field:'id',width:80">编号</th>
									<th data-options="field:'manageStaId',width:100">车位号</th>
									<th data-options="field:'manageArea',width:100">区域</th>
									<th data-options="field:'managePs',width:100">备注</th>
									<th data-options="field:'manageCarId',width:100"> 车牌号</th>
									
								</tr>
							</thead>
							<tbody>
								<tr>
									<td></td><td>001</td><td>顿饭第三季</td><td>15166925589</td><td>乌鲁木齐啦啦啦啦啦</td><td>FI-SW-01</td><td>2014-5-6</td><td>2015-5-6</td>
								</tr>
								<tr>
									<td></td><td>002</td><td>费点事</td><td>15166925589</td><td>乌鲁木齐啦啦啦啦啦</td><td>K9-DL-01</td><td>2014-5-6</td><td>2015-5-6</td>
								</tr>
								<tr>
									<td></td><td>003</td><td>二位好</td><td>15166925589</td><td>乌鲁木齐啦啦啦啦啦</td><td>RP-SN-01</td><td>2014-5-6</td><td>2015-5-6</td>
								</tr>
								<tr>
									<td></td><td>004</td><td>通过人体</td><td>15166925589</td><td>乌鲁木齐啦啦啦啦啦</td><td>RP-SN-01</td><td>2014-5-6</td><td>2015-5-6</td>
								</tr>
								<tr>
									<td></td><td>005</td><td>太热</td><td>15166925589</td><td>乌鲁木齐啦啦啦啦啦</td><td>RP-LI-02</td><td>2014-5-6</td><td>2015-5-6</td>
								</tr>
							</tbody>
							</table>
							<div id="toolbar">
								<!-- <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">新 增</a> -->
								<!-- <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编 辑</a> -->
								<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeUser()">移 除</a>
								<a href="#" class="easyui-linkbutton" plain="true">
									<span>丨选择模式: </span>
									<select onchange="$('#dg').datagrid({singleSelect:(this.value==1)})">
										<option value="1">单选</option>
										<option value="0">多选</option>
									</select>
								</a>
								<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newManage()">缴费</a>
								<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newStop()">停车</a>
							
							    <input id="ss" class="easyui-searchbox" style="width:300px"
							    data-options="searcher:doSearch,prompt:'请输入要搜索的车牌号'"></input>
							</div>
							<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
								<div class="ftitle">用户缴费</div>
								
								<form id="fm" method="post" novalidate>
								<div class="fitem">
										<label>编 &nbsp&nbsp号: 编号自动生成</label>
										<input name="id" type="hidden">
									</div>
									<div class="fitem">
										<label>车位号:</label>
										<input name="manageStaId" class="easyui-validatebox" required="true">
									</div>
									<div class="fitem">
										<label>区 &nbsp&nbsp域:</label>
										<input name="manageArea" class="easyui-validatebox"  required="true">
									</div>
									<div class="fitem">
										<label>备 &nbsp&nbsp注:</label>
										<input name="managePs" class="easyui-validatebox" required="true">
										
									</div>
									<div class="fitem">
										<label>车牌号:</label>
										<input name="manageCarId" class="easyui-validatebox" >
									</div>
								</form>
							</div>
							<div id="dlg-buttons">
								<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">保存</a>
								<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">关闭</a>
							</div>
							<!-- 停车窗口 -->
							<div id="yhtc" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
								<div class="ftitle">用户停车</div>
								<form id="mg" method="post" novalidate>
								<input name="id" id="mgid" class="easyui-validatebox" type="hidden">
										<input name="manageStaId" id="staId" class="easyui-validatebox" type="hidden" >
										<input name="manageArea" id="area" class="easyui-validatebox" type="hidden" >
										<input name="managePs" id="ps" class="easyui-validatebox" type="hidden" >
								</form>
								<form id="tc" method="post" novalidate>
								<div class="fitem">
										<label>编 &nbsp&nbsp号: 编号自动生成</label>
										<input name="userId" type="hidden">
									</div>
									<div class="fitem">
										<label>车牌号:</label>
										<input name="recCarId" id="recCarId" class="easyui-validatebox" required="true" >
										<input name="manageCarId" id="manageCarId" type="hidden"  class="easyui-validatebox"  >
										<input name="id" id="id" type="hidden"  class="easyui-validatebox" >
										<input name="manageStaId" id="manageStaId" class="easyui-validatebox" type="hidden" >
										<input name="manageArea" id="manageArea" class="easyui-validatebox" type="hidden" >
										<input name="managePs" id="managePs" class="easyui-validatebox" type="hidden" >
									</div>
									<div class="fitem">
										<label>进入日期:</label>
										<input name="recEntryDate" class="easyui-datetimebox" 
										 data-options="required:true,showSeconds:true"  style="width:160px" >
									</div>
								</form>
							</div>
							<div id="dlg-buttons">
								<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveRecord()">保存</a>
								<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">关闭</a>
							</div>
							<!--缴费窗口  -->
								<div id="jf" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
								<div class="ftitle">用户信息</div>
								<form id="jffm" method="post" novalidate>
								<div class="fitem">
										<label>编 &nbsp&nbsp号: 编号自动生成</label>
										<input name="recId" type="hidden">
									</div>
									<div class="fitem">
										<label>车 &nbsp牌 &nbsp号:</label>
										<input name="recCarId" class="easyui-validatebox" required="true" readonly="readonly">
									</div>
									<div class="fitem">
										<label>进入日期:</label>
										<input name="recEntryDate" id="recEntryDate" class="easyui-datetimebox" 
										 data-options="required:true,showSeconds:true,formatter:formatDateBoxFull"  style="width:160px" >
										
									</div>
									<div class="fitem">
										<label>离开日期:</label>
										<input  class="easyui-datetimebox" id="recLeaveDate" name="recLeaveDate" 
										 data-options="required:true,showSeconds:true" style="width:160px">
									</div>
									<div class="fitem">
										<label>停车时间:</label>
										<input name="recTime" id="recTime" class="easyui-validatebox" >小时
									</div>
									<div class="fitem">
										<label>收费标准:</label>
										<input name="recCharge"  class="easyui-validatebox" value="2" required="true">元/时
									</div>
									<div class="fitem">
										<label>总 &nbsp费 &nbsp用:</label>
										<input name="recCost" id="recCost" class="easyui-validatebox" >元
									</div>
								</form>
							</div>
							<div id="dlg-buttons">
							    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="newCount()">计算费用</a>
								<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveManage()">缴费</a>
								<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#jf').dialog('close')">关闭</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	
	</div>  
<script type="text/javascript">




//表格分页	
var pager = $('#dg').datagrid('getPager');    // get the pager of datagrid
	pager.pagination({
		showPageList:false,
		buttons:[{
			iconCls:'icon-search',
			handler:function(){
				alert('search');
			}
		},{
			iconCls:'icon-add',
			handler:function(){
				alert('add');
			}
		},{
			iconCls:'icon-edit',
			handler:function(){
				alert('edit');
			}
		}],
		onBeforeRefresh:function(){
			alert('before refresh');
			return true;
		}
	});		
</script>
</body>
</html>