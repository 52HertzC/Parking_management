package com.park.base.service;

import com.park.support.PageInfo;

public interface IBaseService<T> {

	//添加
	void saveEntity(T entity);
	//修改
	void updateEntity(T entity);
	//删除
	void deleteByPrimaryKey(Object id);
	//查询
	T selectEntity(Object id);
	//用PageInfo分页查询
	PageInfo<T> selectByPageInfo(PageInfo<T> pageInfo);
}
