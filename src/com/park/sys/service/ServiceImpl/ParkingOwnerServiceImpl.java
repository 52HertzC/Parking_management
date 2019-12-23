package com.park.sys.service.ServiceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.park.base.service.serviceImpl.BaseServiceImpl;
import com.park.bean.ParkingOwner;
import com.park.bean.ParkingOwnerExample;
import com.park.bean.ParkingOwnerExample.Criteria;
import com.park.mapper.ParkingOwnerMapper;
import com.park.support.EasyUIDataGridResult;
import com.park.support.TaotaoResult;
import com.park.sys.service.IParkingOwnerService;

@Service
public class ParkingOwnerServiceImpl extends BaseServiceImpl<ParkingOwner> implements IParkingOwnerService{
	
	@Autowired
	private ParkingOwnerMapper parkingOwnerMapper;
	

	@Override
	public EasyUIDataGridResult getOwnerList(int page, int rows) {
		// TODO Auto-generated method stub
		ParkingOwnerExample example = new ParkingOwnerExample();
		//使用pageHelper设置查询条件
		PageHelper.startPage(page, rows);
		List<ParkingOwner> lists= parkingOwnerMapper.selectByExample(example);
		PageInfo<ParkingOwner> pageInfo = new PageInfo<>(lists);
		EasyUIDataGridResult dataGrid = new EasyUIDataGridResult();
		dataGrid.setTotal((int) pageInfo.getTotal());
		dataGrid.setRows(lists);
		return dataGrid;
	}

	@Override
	public TaotaoResult save(ParkingOwner owner) {
		// TODO Auto-generated method stub
		parkingOwnerMapper.insert(owner);
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult update(ParkingOwner owner) {
		// TODO Auto-generated method stub
		parkingOwnerMapper.updateByPrimaryKey(owner);
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult delete(String ownId) {
		// TODO Auto-generated method stub
		String[] str=ownId.split(",");
		for (String string : str) {
			parkingOwnerMapper.deleteByPrimaryKey(Long.parseLong(string));
		}
		return TaotaoResult.ok();
	}

	@Override
	public EasyUIDataGridResult getOwnerList(String carId, int page, int rows) {
		// TODO Auto-generated method stub
		ParkingOwnerExample example = new ParkingOwnerExample();
		Criteria ownerCriteria=example.createCriteria();
		ownerCriteria.andCarIdLike("%"+carId+"%");
		//使用pageHelper设置查询条件
		PageHelper.startPage(page, rows);
		List<ParkingOwner> lists= parkingOwnerMapper.selectByExample(example);
		PageInfo<ParkingOwner> pageInfo = new PageInfo<>(lists);
		EasyUIDataGridResult dataGrid = new EasyUIDataGridResult();
		dataGrid.setTotal((int) pageInfo.getTotal());
		dataGrid.setRows(lists);
		return dataGrid;
	}

	@Override
	public EasyUIDataGridResult getOwnerWxList(String carId) {
		// TODO Auto-generated method stub
		ParkingOwnerExample example = new ParkingOwnerExample();
		Criteria ownerCriteria=example.createCriteria();
		ownerCriteria.andCarIdEqualTo(carId);
		List<ParkingOwner> lists=parkingOwnerMapper.selectByExample(example);
		PageInfo<ParkingOwner> pageInfo = new PageInfo<>(lists);
		EasyUIDataGridResult dataGrid = new EasyUIDataGridResult();
		dataGrid.setTotal((int) pageInfo.getTotal());
		dataGrid.setRows(lists);
		return dataGrid;
	}
}
