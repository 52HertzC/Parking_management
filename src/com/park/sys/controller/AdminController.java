package com.park.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.park.bean.ParkingOwner;
import com.park.bean.User;
import com.park.support.EasyUIDataGridResult;
import com.park.support.PageInfo;
import com.park.support.TaotaoResult;
import com.park.sys.service.IAdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdminService adminService;
	
	
	@RequestMapping("/tolist")
	public String list() {
		return "/parking/user_list";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIDataGridResult getUserList(String username,int page,int rows) {
		EasyUIDataGridResult result=new EasyUIDataGridResult();
		if(username==null||username=="") {
			 result = adminService.getUserList(page, rows);
		}else {
			 result = adminService.getUserList(username,page, rows);
		}
		
		return result;
	}
	@RequestMapping("/wxlist")
	@ResponseBody
	public User getUserWxList(Long sessionId) {
			User user =  adminService.getUserWxList(sessionId);
			return user;
	}
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult save(User user) {
		try {
			TaotaoResult result =  adminService.save(user);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(0, "用户信息保存失败");
		}
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public TaotaoResult edit(User user) {
		try {
			TaotaoResult result =  adminService.update(user);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(0, "用户信息更新失败");
		}
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult delete(String userId) {
		try {
			TaotaoResult result =  adminService.delete(userId);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(0, "用户信息删除失败");
		}
	}
}
