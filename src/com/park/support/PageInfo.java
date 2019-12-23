package com.park.support;

import java.util.List;

/**
 * 
 * pageInfo<T>工具类

	分页的需要哪些数据？
	
	1 总条数 int totalCount
	2 每一页的条数 int pageSize 
	3 总页数 int totalPage
	4 开始条数 int start
	5 当前页  int currentPage
	
	查询的数据数据
	Private List<T> lists
	
	条件查询的时候？条件需要保存哪里？
	可以保存到类的对象的属性中。
	Private T entity;

 * @author Lenovo
 *
 */
public class PageInfo<T> {
	//总条数
	private int totalCount;
	// 每一页的条数 初始值是5
	private int pageSize = 5; 
	// 总页数
	private int totalPage;
	// 开始的条数
	private int start;
	
	//当前的页数
	private int currentPage = 1;
	
	//把查询的数据放到pageInfo中用于传输
	private List<T> lists;
	
	//保存查询条件，
	private T entity;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStart() {
		start = (currentPage-1)*pageSize;
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<T> getLists() {
		return lists;
	}

	public void setLists(List<T> lists) {
		this.lists = lists;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}
	
	
}
