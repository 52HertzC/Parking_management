package com.park.login.service.ServiceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.park.base.service.serviceImpl.BaseServiceImpl;
import com.park.bean.User;
import com.park.bean.UserExample;
import com.park.bean.UserExample.Criteria;
import com.park.login.service.IUserService;
import com.park.mapper.UserMapper;
import com.park.support.TaotaoResult;

@Service
public class UserServiceImpl  implements IUserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userMapper.selectUser(user);
	}
	public User selectLogin(User user) {
		// TODO Auto-generated method stub
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(user.getUsername());
		criteria.andPasswordEqualTo(user.getPassword());
		List<User> userList =  userMapper.selectByExample(example);
		if(userList.size()>0) {
			return userList.get(0);
		}
		return null;
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
	
	
}
