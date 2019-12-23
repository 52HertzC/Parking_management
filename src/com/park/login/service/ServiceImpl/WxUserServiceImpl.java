package com.park.login.service.ServiceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.park.bean.User;
import com.park.bean.WxUser;
import com.park.bean.WxUserExample;
import com.park.login.service.IWxUserService;
import com.park.mapper.WxUserMapper;
import com.park.support.EasyUIDataGridResult;
import com.park.support.TaotaoResult;
@Service
public class WxUserServiceImpl implements IWxUserService {

	@Autowired
	private WxUserMapper wxUserMapper;
	
	public EasyUIDataGridResult WxUserService(String openid) {
		// TODO Auto-generated method stub
		WxUserExample example= new WxUserExample();
		example.createCriteria().andOpenidEqualTo(openid);
		List<WxUser> user= wxUserMapper.selectByExample(example);
		PageInfo<WxUser> pageInfo = new PageInfo<>(user);
		EasyUIDataGridResult dataGrid = new EasyUIDataGridResult();
		dataGrid.setTotal((int) pageInfo.getTotal());
		dataGrid.setRows(user);
		return dataGrid;
	}

	@Override
	public TaotaoResult save(WxUser wxUser) {
		// TODO Auto-generated method stub
		wxUserMapper.insert(wxUser);
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult update(WxUser wxUser) {
		// TODO Auto-generated method stub
		wxUserMapper.updateByPrimaryKey(wxUser);
		return TaotaoResult.ok();
	}

}
