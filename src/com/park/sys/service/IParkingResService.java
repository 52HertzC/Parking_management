package com.park.sys.service;

import com.park.bean.ParkingRes;
import com.park.support.EasyUIDataGridResult;
import com.park.support.TaotaoResult;

public interface IParkingResService {

	EasyUIDataGridResult getResListWx();

	TaotaoResult save(ParkingRes res);

	EasyUIDataGridResult getResCarIdListWx(String resCarId);

	TaotaoResult delete(Long id);

	TaotaoResult cariddelete(String resCarId);

}
