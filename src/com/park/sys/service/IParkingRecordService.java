package com.park.sys.service;

import com.park.bean.ParkingRecord;
import com.park.support.EasyUIDataGridResult;
import com.park.support.TaotaoResult;

public interface IParkingRecordService{

	EasyUIDataGridResult getRecordList(int page, int rows);

	TaotaoResult save(ParkingRecord owner);

	TaotaoResult update(ParkingRecord owner);

	TaotaoResult delete(String ownId);

	EasyUIDataGridResult getRecordCarList(String recCarId);

	ParkingRecord getResordIdList(Long recId);

	EasyUIDataGridResult getResorddateisnull(String recCarId);
	//Ä£ºý²éÑ¯
	EasyUIDataGridResult getRecordList(String recCarId, int page, int rows);

}
