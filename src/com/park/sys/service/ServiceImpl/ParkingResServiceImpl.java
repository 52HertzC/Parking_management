package com.park.sys.service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.park.bean.ParkingRes;
import com.park.bean.ParkingResExample;
import com.park.mapper.ParkingResMapper;
import com.park.support.EasyUIDataGridResult;
import com.park.support.TaotaoResult;
import com.park.sys.service.IParkingResService;

@Service
public class ParkingResServiceImpl implements IParkingResService {

	@Autowired
	private ParkingResMapper parkingResMapper;
	@Override
	
	public EasyUIDataGridResult getResListWx() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				List<ParkingRes> lists= parkingResMapper.selectByExample(null);
				PageInfo<ParkingRes> pageInfo = new PageInfo<>(lists);
				EasyUIDataGridResult dataGrid = new EasyUIDataGridResult();
				dataGrid.setTotal((int) pageInfo.getTotal());
				dataGrid.setRows(lists);
				return dataGrid;
	}
	@Override
	public TaotaoResult save(ParkingRes res) {
		// TODO Auto-generated method stub
		parkingResMapper.insert(res);
		return TaotaoResult.ok();
	}
	@Override
	public EasyUIDataGridResult getResCarIdListWx(String resCarId) {
		// TODO Auto-generated method stub
		ParkingResExample example=new ParkingResExample();
		example.createCriteria().andResCarIdEqualTo(resCarId);
		List<ParkingRes> lists= parkingResMapper.selectByExample(example);
		PageInfo<ParkingRes> pageInfo = new PageInfo<>(lists);
		EasyUIDataGridResult dataGrid = new EasyUIDataGridResult();
		dataGrid.setTotal((int) pageInfo.getTotal());
		dataGrid.setRows(lists);
		return dataGrid;
	}
	@Override
	public TaotaoResult delete(Long id) {
		// TODO Auto-generated method stub
		parkingResMapper.deleteByPrimaryKey(id);
		return TaotaoResult.ok();
	}
	@Override
	public TaotaoResult cariddelete(String resCarId) {
		// TODO Auto-generated method stub
		 parkingResMapper.deletebyrescarid(resCarId);
		return TaotaoResult.ok();
	}

}
