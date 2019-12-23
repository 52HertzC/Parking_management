package com.park.sys.service.ServiceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.park.base.service.serviceImpl.BaseServiceImpl;
import com.park.bean.ParkingManage;
import com.park.bean.ParkingOwner;
import com.park.bean.ParkingRecord;
import com.park.bean.ParkingRecordExample;
import com.park.bean.ParkingRecordExample.Criteria;
import com.park.mapper.ParkingOwnerMapper;
import com.park.mapper.ParkingRecordMapper;
import com.park.support.EasyUIDataGridResult;
import com.park.support.TaotaoResult;
import com.park.sys.service.IParkingOwnerService;
import com.park.sys.service.IParkingRecordService;

@Service
public class ParkingRecordServiceImpl implements IParkingRecordService{
	
	@Autowired
	private ParkingRecordMapper parkingRecordMapper;
	

	@Override
	public EasyUIDataGridResult getRecordList(int page, int rows) {
		// TODO Auto-generated method stub
		ParkingRecordExample example = new ParkingRecordExample();
		//使用pageHelper设置查询条件
		PageHelper.startPage(page, rows);
		List<ParkingRecord> lists= parkingRecordMapper.selectByExample(example);
		PageInfo<ParkingRecord> pageInfo = new PageInfo<>(lists);
		EasyUIDataGridResult dataGrid = new EasyUIDataGridResult();
		dataGrid.setTotal((int) pageInfo.getTotal());
		dataGrid.setRows(lists);
		return dataGrid;
	}

	@Override
	public TaotaoResult save(ParkingRecord record) {
		// TODO Auto-generated method stub
		parkingRecordMapper.insert(record);
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult update(ParkingRecord record) {
		// TODO Auto-generated method stub
		parkingRecordMapper.updateByPrimaryKey(record);
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult delete(String recId) {
		// TODO Auto-generated method stub
		String[] str=recId.split(",");
		for (String string : str) {
			parkingRecordMapper.deleteByPrimaryKey(Long.parseLong(string));
		}
		return TaotaoResult.ok();
	}

	@Override
	public EasyUIDataGridResult getRecordCarList(String recCarId) {
		// TODO Auto-generated method stub
		List<ParkingRecord> lists= parkingRecordMapper.selectLikeRecord(recCarId);
		PageInfo<ParkingRecord> pageInfo = new PageInfo<>(lists);
		EasyUIDataGridResult dataGrid = new EasyUIDataGridResult();
		dataGrid.setTotal((int) pageInfo.getTotal());
		dataGrid.setRows(lists);
		return dataGrid;
	}

	@Override
	public ParkingRecord getResordIdList(Long recId) {
		// TODO Auto-generated method stub
		ParkingRecord parkingRecord= parkingRecordMapper.selectByPrimaryKey(recId);

		return parkingRecord;
	}

	@Override
	public EasyUIDataGridResult getResorddateisnull(String recCarId) {
		// TODO Auto-generated method stub
		List<ParkingRecord> lists= parkingRecordMapper.selectRecordIsN(recCarId);
		PageInfo<ParkingRecord> pageInfo = new PageInfo<>(lists);
		EasyUIDataGridResult dataGrid = new EasyUIDataGridResult();
		dataGrid.setTotal((int) pageInfo.getTotal());
		dataGrid.setRows(lists);
		return dataGrid;
	}

	@Override
	public EasyUIDataGridResult getRecordList(String recCarId, int page, int rows) {
		ParkingRecordExample example = new ParkingRecordExample();
		Criteria recordCriteria=example.createCriteria();
		recordCriteria.andRecCarIdLike("%"+recCarId+"%");
		//使用pageHelper设置查询条件
		PageHelper.startPage(page, rows);
		List<ParkingRecord> lists= parkingRecordMapper.selectByExample(example);
		PageInfo<ParkingRecord> pageInfo = new PageInfo<>(lists);
		EasyUIDataGridResult dataGrid = new EasyUIDataGridResult();
		dataGrid.setTotal((int) pageInfo.getTotal());
		dataGrid.setRows(lists);
		return dataGrid;
	}

}
