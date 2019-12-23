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

import com.park.bean.ParkingRecord;
import com.park.support.EasyUIDataGridResult;
import com.park.support.TaotaoResult;
import com.park.sys.service.IParkingRecordService;

@Controller
@RequestMapping("/record")
public class ParkingRecordController {
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
		return "/parking/record_list";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIDataGridResult getResordList(String recCarId,int page,int rows) {
		EasyUIDataGridResult result=new EasyUIDataGridResult();
		if(recCarId==null||recCarId=="") {
			 result = parkingRecordService.getRecordList(page, rows);
		}else {
			 result = parkingRecordService.getRecordList(recCarId,page, rows);
		}
		
		return result;
	}
	@RequestMapping("/carlist")
	@ResponseBody
	public EasyUIDataGridResult getResordCarList(String recCarId) {
		EasyUIDataGridResult result = parkingRecordService.getRecordCarList(recCarId);
		return result;
	}
	@RequestMapping("/dateisnull")
	@ResponseBody
	public EasyUIDataGridResult getResorddateisnull(String recCarId) {
		EasyUIDataGridResult result = parkingRecordService.getResorddateisnull(recCarId);
		return result;
	}
	
	@RequestMapping("/recId")
	@ResponseBody
	public ParkingRecord getResordIdList(Long recId) {
		ParkingRecord result = parkingRecordService.getResordIdList(recId);
		return result;
	}
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult save(ParkingRecord record) {
		try {
			TaotaoResult result =  parkingRecordService.save(record);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(0, "用户信息保存失败");
		}
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public TaotaoResult edit(ParkingRecord record) {
		try {
			TaotaoResult result =  parkingRecordService.update(record);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(0, "用户信息更新失败");
		}
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult delete(String recId) {
		try {
			TaotaoResult result =  parkingRecordService.delete(recId);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(0, "用户信息删除失败");
		}
	}
}
