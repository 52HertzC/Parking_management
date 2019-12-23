package com.park.parking.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.park.bean.ParkingStall;
import com.park.parking.service.IManagermentService;
import com.park.support.PageInfo;

@Controller
@RequestMapping("/managerment")
public class ManagermentConroller {

	@Resource
	private IManagermentService managermentService;
	
	@RequestMapping("/list")
	public String list(PageInfo<ParkingStall> pageInfo,ParkingStall parkingStall,Model model) {

		return "parking/managerment/list";
	}
}
