package com.park.base.service.serviceImpl;

import java.util.List;


import com.park.base.service.IBaseService;
import com.park.mapper.IBaseMapper;
import com.park.support.PageInfo;

public class BaseServiceImpl<T> implements IBaseService<T>{

	
	private IBaseMapper<T> baseMapper;
	@Override
	public void saveEntity(T entity) {
		// TODO Auto-generated method stub
		baseMapper.insertSelective(entity);
	}

	@Override
	public void updateEntity(T entity) {
		// TODO Auto-generated method stub
		baseMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public PageInfo<T> selectByPageInfo(PageInfo<T> pageInfo) {
		// TODO Auto-generated method stub
		//查询总条数
		List<T> lists = baseMapper.selectByPageInfo(pageInfo);
		//条数
		int count = baseMapper.selectCountByPageInfo(pageInfo);
		//计算总页数 => 整数/整数 是个整数   5/2  5/2.0
		int totalPage = count%pageInfo.getPageSize()>0?count/pageInfo.getPageSize()+1:count/pageInfo.getPageSize();
		pageInfo.setLists(lists);
		pageInfo.setTotalCount(count);
		pageInfo.setTotalPage(totalPage);
		return pageInfo;
	}

	@Override
	public void deleteByPrimaryKey(Object id) {
		// TODO Auto-generated method stub
		baseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public T selectEntity(Object id) {
		// TODO Auto-generated method stub
		return baseMapper.selectByPrimaryKey(id);
	}

	public IBaseMapper<T> getBaseMapper() {
		return baseMapper;
	}

	public void setBaseMapper(IBaseMapper<T> baseMapper) {
		this.baseMapper = baseMapper;
	}

}
