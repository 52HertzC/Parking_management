package com.park.sys.controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.park.bean.ParkingManage;
import com.park.support.EasyUIDataGridResult;
import com.park.support.TaotaoResult;
import com.park.sys.service.IParkingManageService;

@Controller
@RequestMapping("/manage")
public class ParkingManageController {
	@Autowired
	private IParkingManageService parkingManageService;
	
	  @org.springframework.web.bind.annotation.InitBinder
	    public void InitBinder(WebDataBinder binder){
	        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        dateFormat.setLenient(true);
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    }
	@RequestMapping("/tolist")
	public String list() {
		return "/parking/parking_manage";
	}
	//查询parking_manage表所有数据，无分页
	@RequestMapping("/wxlist")
	@ResponseBody
	public EasyUIDataGridResult getManageListWx() {
		EasyUIDataGridResult result = parkingManageService.getManageListWx();
		return result;
	}
	//查询parking_manage表中车牌号为空
		@RequestMapping("/wxlists")
		@ResponseBody
		public EasyUIDataGridResult getManageIsNullListWx() {
			EasyUIDataGridResult result = parkingManageService.getManageIsNullListWx();
			return result;
		}
	//查询parking_manage表不同区的数据
	@RequestMapping("/wxlike")
	@ResponseBody
	public EasyUIDataGridResult getManageAreaListWx(String manageArea) {
		EasyUIDataGridResult result = parkingManageService.getManageAreaListWx(manageArea);
		return result;
	}
	@RequestMapping("/wxcarlist")
	@ResponseBody
	public EasyUIDataGridResult getManageCarIdListWx(String manageCarId) {
		EasyUIDataGridResult result = parkingManageService.getManageCarIdListWx(manageCarId);
		return result;
	}
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIDataGridResult getManageList(String manageStaId,int page,int rows) {
		EasyUIDataGridResult result=new EasyUIDataGridResult();
		if(manageStaId==null||manageStaId=="") {
			result = parkingManageService.getManageList(page, rows);
		}else {
			result = parkingManageService.getManageList(manageStaId,page, rows);
		}
	 
		return result;
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult save(ParkingManage manage) {
		try {
			TaotaoResult result =  parkingManageService.save(manage);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(0, "用户信息保存失败");
		}
	}

	@RequestMapping("/edit")
	@ResponseBody
	public TaotaoResult edit(ParkingManage manage) {
		try {
			TaotaoResult result =  parkingManageService.update(manage);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(0, "用户信息更新失败");
		}
	}
	//通过staid修改数据
	@RequestMapping("/editstaid")
	@ResponseBody
	public TaotaoResult editStaId(ParkingManage manage) {
		try {
			TaotaoResult result =  parkingManageService.updateStaId(manage);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(0, "用户信息更新失败");
		}
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult delete(String id) {
		try {
			TaotaoResult result =  parkingManageService.delete(id);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(0, "用户信息删除失败");
		}
	}
}
