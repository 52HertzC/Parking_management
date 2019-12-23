package com.park.login.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.park.bean.User;
import com.park.login.service.IUserService;
import com.park.support.TaotaoResult;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private IUserService userService;
	
	@RequestMapping("/login.action")
	public String login(@RequestParam String username,@RequestParam String password,HttpServletRequest request) {
	
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		User user1 = userService.login(user);
		HttpSession session=request.getSession();
		if(user1!=null) {
			session.setAttribute("user", user1);
			return "redirect:/index.jsp";
		}
		return "redirect:/login.jsp";
	}
	
	@RequestMapping("/wxLogin")
	@ResponseBody
	public String wxLogin(User user) {
		 user = userService.selectLogin(user);
		if(user!=null) {
            String sessionId = user.getUserId().toString();
            String sessionCarId=user.getUserCarId();
            System.out.println(user.getUserId());
			return "ok"+sessionCarId+sessionId;
		}
		return "fail";
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult save(User user) {
		try {
			TaotaoResult result =  userService.save(user);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return TaotaoResult.build(0, "用户信息保存失败");
		}
	}
}
