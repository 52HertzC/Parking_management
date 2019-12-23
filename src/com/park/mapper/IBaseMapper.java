package com.park.mapper;

import java.util.List;

import com.park.support.PageInfo;

public interface IBaseMapper<T> {

	 int deleteByPrimaryKey(Object chcId);
	 
	 int insertSelective(T record);
	 
	 T selectByPrimaryKey(Object chcId);
	 
	 int updateByPrimaryKeySelective(T record);
	 
	  //分页查询
	    List<T> selectByPageInfo(PageInfo<T> pageInfo);
	    
	    //查询条数的
	    int selectCountByPageInfo(PageInfo<T> pageInfo);
}
