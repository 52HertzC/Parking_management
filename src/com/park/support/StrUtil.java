package com.park.support;



public class StrUtil {

	public static String createId() {
		//当前的毫秒数生成客户的id，来保证不同
		return "KH"+System.currentTimeMillis();
	}
}
