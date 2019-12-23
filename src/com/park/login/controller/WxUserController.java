package com.park.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.park.bean.User;
import com.park.bean.WxUser;
import com.park.login.service.IWxUserService;
import com.park.support.EasyUIDataGridResult;
import com.park.support.TaotaoResult;

@Controller
@RequestMapping("/wxuser")
public class WxUserController {

	@Autowired
	private IWxUserService wxUserService;
	
	@RequestMapping("/list")
	@ResponseBody
	public EasyUIDataGridResult getWxUserList(String openid) {
		EasyUIDataGridResult result =  wxUserService.WxUserService(openid);
		return result;
}
	
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult save(WxUser wxUser) {
		try {
			TaotaoResult result =  wxUserService.save(wxUser);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(0, "用户信息保存失败");
		}
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public TaotaoResult edit(WxUser wxUser) {
		try {
			TaotaoResult result =  wxUserService.update(wxUser);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(0, "用户信息更新失败");
		}
	}
	
}
