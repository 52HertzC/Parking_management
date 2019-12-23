package com.park.sys.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.park.bean.ParkingOwner;
import com.park.support.EasyUIDataGridResult;
import com.park.support.TaotaoResult;
import com.park.sys.service.IParkingOwnerService;

@Controller
@RequestMapping("/owner")
public class ParkingOwnerController {
	@Autowired
	private IParkingOwnerService parkingOwnerService;
	
	  @org.springframework.web.bind.annotation.InitBinder
	    public void InitBinder(WebDataBinder binder){
	        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        dateFormat.setLenient(true);
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    }
	@RequestMapping("/tolist")
	public String list() {
		return "/parking/parking_list";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIDataGridResult getOwnerList(String carId,int page,int rows) {
		EasyUIDataGridResult result=new EasyUIDataGridResult();
		if(carId==null||carId=="") {
			result = parkingOwnerService.getOwnerList(page, rows);
		}else {
			result = parkingOwnerService.getOwnerList(carId,page, rows);
		}
		 
		return result;
	}
	@RequestMapping("/wxlist")
	@ResponseBody
	public EasyUIDataGridResult getOwnerWxList(String carId) {
		EasyUIDataGridResult result =  parkingOwnerService.getOwnerWxList(carId);
			return result;
	}
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult save(ParkingOwner owner) {
		try {
			TaotaoResult result =  parkingOwnerService.save(owner);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(0, "用户信息保存失败");
		}
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public TaotaoResult edit(ParkingOwner owner) {
		try {
			TaotaoResult result =  parkingOwnerService.update(owner);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(0, "用户信息更新失败");
		}
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult delete(String ownId) {
		try {
			TaotaoResult result =  parkingOwnerService.delete(ownId);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(0, "用户信息删除失败");
		}
	}
}
