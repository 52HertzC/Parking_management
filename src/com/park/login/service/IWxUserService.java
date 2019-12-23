package com.park.login.service;

import java.util.List;

import com.park.bean.WxUser;
import com.park.support.EasyUIDataGridResult;
import com.park.support.TaotaoResult;

public interface IWxUserService {

	EasyUIDataGridResult WxUserService(String openid);

	TaotaoResult save(WxUser wxUser);

	TaotaoResult update(WxUser wxUser);

}
