package com.park.sys.service.ServiceImpl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.park.base.service.serviceImpl.BaseServiceImpl;
import com.park.bean.User;
import com.park.bean.UserExample;
import com.park.bean.UserExample.Criteria;
import com.park.mapper.UserMapper;
import com.park.support.EasyUIDataGridResult;
import com.park.support.TaotaoResult;
import com.park.sys.service.IAdminService;
@Service
public class AdminServiceImpl extends BaseServiceImpl<User> implements IAdminService{

	@Autowired
	private UserMapper userMapper;
	

	@Override
	public EasyUIDataGridResult getUserList(int page, int rows) {
		UserExample example = new UserExample();
		//使用pageHelper设置查询条件
		PageHelper.startPage(page, rows);
		List<User> lists= userMapper.selectByExample(example);
		PageInfo<User> pageInfo = new PageInfo<>(lists);
		EasyUIDataGridResult dataGrid = new EasyUIDataGridResult();
		dataGrid.setTotal((int) pageInfo.getTotal());
		dataGrid.setRows(lists);
		return dataGrid;
	}


	@Override
	public TaotaoResult save(User user) {
		// TODO Auto-generated method stub
		userMapper.insert(user);
		return TaotaoResult.ok();
	}


	@Override
	public TaotaoResult update(User user) {
		// TODO Auto-generated method stub
		userMapper.updateByPrimaryKey(user);
		return TaotaoResult.ok();
	}


	@Override
	public TaotaoResult delete(String userId) {
		// TODO Auto-generated method stub
		String[] str=userId.split(",");
		for (String string : str) {
			userMapper.deleteByPrimaryKey(Long.parseLong(string));
		}
		return TaotaoResult.ok();
	}


	@Override
	public User getUserWxList(Long sessionId) {
		// TODO Auto-generated method stub
		User user=userMapper.selectByPrimaryKey(sessionId);
		return user;
	}


	@Override
	public EasyUIDataGridResult getUserList(String username, int page, int rows) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		Criteria userCriteria=example.createCriteria();
		userCriteria.andUsernameLike("%"+username+"%");
		//使用pageHelper设置查询条件
		PageHelper.startPage(page, rows);
		List<User> lists= userMapper.selectByExample(example);
		PageInfo<User> pageInfo = new PageInfo<>(lists);
		EasyUIDataGridResult dataGrid = new EasyUIDataGridResult();
		dataGrid.setTotal((int) pageInfo.getTotal());
		dataGrid.setRows(lists);
		return dataGrid;
	}



}
