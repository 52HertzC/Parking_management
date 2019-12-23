package com.park.login.service;

import com.park.base.service.IBaseService;
import com.park.bean.User;
import com.park.support.TaotaoResult;

public interface IUserService {
	
	User login(User user);
	
	User selectLogin(User user);
	
	TaotaoResult save(User user);

	TaotaoResult update(User user);

}
