package com.park.sys.service;

import com.park.bean.ParkingManage;
import com.park.support.EasyUIDataGridResult;
import com.park.support.TaotaoResult;

public interface IParkingManageService{

	EasyUIDataGridResult getManageList(int page, int rows);

	TaotaoResult save(ParkingManage manage);

	TaotaoResult update(ParkingManage manage);

	TaotaoResult delete(String id);

	void updateByManageCarId(String recCarId);

	EasyUIDataGridResult getManageListWx();

	EasyUIDataGridResult getManageAreaListWx(String manageArea);

	EasyUIDataGridResult getManageCarIdListWx(String manageCarId);
	//Ä£ºý²éÑ¯
	EasyUIDataGridResult getManageList(String manageStaId, int page, int rows);

	EasyUIDataGridResult getManageLists(String manageCarId, int page, int rows);

	EasyUIDataGridResult getManageIsNullListWx();

	TaotaoResult updateStaId(ParkingManage manage);



}
