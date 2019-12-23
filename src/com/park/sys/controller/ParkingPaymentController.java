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
import com.park.bean.ParkingRecord;
import com.park.support.EasyUIDataGridResult;
import com.park.support.TaotaoResult;
import com.park.sys.service.IParkingManageService;
import com.park.sys.service.IParkingRecordService;

@Controller
@RequestMapping("/payment")
public class ParkingPaymentController {
	@Autowired
	private IParkingManageService parkingManageService;
	
	@Autowired
	private IParkingRecordService parkingRecordService;
	
	  @org.springframework.web.bind.annotation.InitBinder
	    public void InitBinder(WebDataBinder binder){
	        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        dateFormat.setLenient(true);
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    }
	  
	@RequestMapping("/tolist")
	public String list() {
		return "/parking/parking_payment";
	}
	@RequestMapping("/toAdd")
	public String add() {
		return "/parking/payment";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIDataGridResult getManageList(String manageCarId,int page,int rows) {
		EasyUIDataGridResult result =new EasyUIDataGridResult();
		if(manageCarId==""||manageCarId==null) {
			result = parkingManageService.getManageList(page, rows);
		}else {
			result = parkingManageService.getManageLists(manageCarId,page, rows);
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
	
	@RequestMapping("/saveRecord")
	@ResponseBody
	public TaotaoResult saveRecord(ParkingRecord record,ParkingManage manage) {
		try {
			
			TaotaoResult result =  parkingRecordService.save(record);
			parkingManageService.update(manage);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(0, "用户信息保存失败");
		}
	}
	
	@RequestMapping("/updateRecord")
	@ResponseBody
	public TaotaoResult updateManage(ParkingRecord record) {
		try {
			
			TaotaoResult result =  parkingRecordService.update(record);
			parkingManageService.updateByManageCarId(record.getRecCarId());
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
