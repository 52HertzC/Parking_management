package com.park.support;

import java.io.Serializable;
import java.util.List;

/**
 * 可以结合@ResponseBody
 * 返回{total:”2”,rows:[{“id”:”1”,”name”:”张三”},{“id”:”2”,”name”:”李四”}]}
 * 这种类型的数据
 * @author Lenovo
 *
 */
public class EasyUIDataGridResult implements Serializable{

	 private Integer total;
     
	 private List<?> rows;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	 
	 
 
}

