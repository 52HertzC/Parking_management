package com.park.sys.service;

import com.park.base.service.IBaseService;
import com.park.bean.User;
import com.park.support.EasyUIDataGridResult;
import com.park.support.TaotaoResult;

public interface IAdminService extends IBaseService<User>{

	EasyUIDataGridResult getUserList(int page, int rows);

	TaotaoResult save(User user);

	TaotaoResult update(User user);

	TaotaoResult delete(String userId);

	User getUserWxList(Long sessionId);

	EasyUIDataGridResult getUserList(String username, int page, int rows);

}
