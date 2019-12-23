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
import com.park.bean.ParkingRes;
import com.park.support.EasyUIDataGridResult;
import com.park.support.TaotaoResult;
import com.park.sys.service.IParkingResService;

@Controller
@RequestMapping("/res")
public class ParkingResController {

	@Autowired
	private IParkingResService parkingResService;
	
	 @org.springframework.web.bind.annotation.InitBinder
	    public void InitBinder(WebDataBinder binder){
	        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        dateFormat.setLenient(true);
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    }
	//查询所有数据
	@RequestMapping("/wxlist")
	@ResponseBody
	public EasyUIDataGridResult getResListWx() {
		EasyUIDataGridResult result = parkingResService.getResListWx();
		return result;
	}
	//通过车牌号查询
	@RequestMapping("/wxcarlist")
	@ResponseBody
	public EasyUIDataGridResult getResCarIdListWx(String resCarId) {
		EasyUIDataGridResult result = parkingResService.getResCarIdListWx(resCarId);
		return result;
	}
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult save(ParkingRes res) {
		try {
			TaotaoResult result =  parkingResService.save(res);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(0, "用户信息保存失败");
		}
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult delete(Long id) {
		try {
			TaotaoResult result =  parkingResService.delete(id);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(0, "用户信息删除失败");
		}
	}
	@RequestMapping("/cariddelete")
	@ResponseBody
	public TaotaoResult cariddelete(String resCarId) {
		try {
			TaotaoResult result =  parkingResService.cariddelete(resCarId);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(0, "用户信息删除失败");
		}
	}
}
