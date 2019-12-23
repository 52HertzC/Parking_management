package com.park.sys.service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.park.bean.ParkingManage;
import com.park.bean.ParkingManageExample;
import com.park.mapper.ParkingManageMapper;
import com.park.support.EasyUIDataGridResult;
import com.park.support.TaotaoResult;
import com.park.sys.service.IParkingManageService;

@Service
public class ParkingManageServiceImpl implements IParkingManageService{
	
	@Autowired
	private ParkingManageMapper parkingManageMapper;
	

	@Override
	public EasyUIDataGridResult getManageList(int page, int rows) {
		// TODO Auto-generated method stub
		ParkingManageExample example=new ParkingManageExample();	
		//使用pageHelper设置查询条件
		PageHelper.startPage(page, rows);
		List<ParkingManage> lists= parkingManageMapper.selectByExample(example);
		PageInfo<ParkingManage> pageInfo = new PageInfo<>(lists);
		EasyUIDataGridResult dataGrid = new EasyUIDataGridResult();
		dataGrid.setTotal((int) pageInfo.getTotal());
		dataGrid.setRows(lists);
		return dataGrid;
	}

	@Override
	public TaotaoResult save(ParkingManage manage) {
		// TODO Auto-generated method stub
		parkingManageMapper.insert(manage);
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult update(ParkingManage manage) {
		// TODO Auto-generated method stub
		parkingManageMapper.updateByPrimaryKeySelective(manage);
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult delete(String id) {
		// TODO Auto-generated method stub
		String[] str=id.split(",");
		for (String string : str) {
			parkingManageMapper.deleteByPrimaryKey(Long.parseLong(string));
		}
		return TaotaoResult.ok();
	}

	@Override
	public void updateByManageCarId(String recCarId) {
		// TODO Auto-generated method stub
		parkingManageMapper.updateByManageCarId(recCarId);
	}

	@Override
	public EasyUIDataGridResult getManageListWx() {
		// TODO Auto-generated method stub
		List<ParkingManage> lists= parkingManageMapper.selectByExample(null);
		PageInfo<ParkingManage> pageInfo = new PageInfo<>(lists);
		EasyUIDataGridResult dataGrid = new EasyUIDataGridResult();
		dataGrid.setTotal((int) pageInfo.getTotal());
		dataGrid.setRows(lists);
		return dataGrid;
	}

	@Override
	public EasyUIDataGridResult getManageAreaListWx(String manageArea) {
		// TODO Auto-generated method stub
		List<ParkingManage> lists= parkingManageMapper.selectLikeManage(manageArea);
		PageInfo<ParkingManage> pageInfo = new PageInfo<>(lists);
		EasyUIDataGridResult dataGrid = new EasyUIDataGridResult();
		dataGrid.setTotal((int) pageInfo.getTotal());
		dataGrid.setRows(lists);
		return dataGrid;
	}

	@Override
	public EasyUIDataGridResult getManageCarIdListWx(String manageCarId) {
		// TODO Auto-generated method stub
		ParkingManageExample example=new ParkingManageExample();
		example.createCriteria().andManageCarIdEqualTo(manageCarId);
		List<ParkingManage> lists= parkingManageMapper.selectByExample(example);
		PageInfo<ParkingManage> pageInfo = new PageInfo<>(lists);
		EasyUIDataGridResult dataGrid = new EasyUIDataGridResult();
		dataGrid.setTotal((int) pageInfo.getTotal());
		dataGrid.setRows(lists);
		return dataGrid;
	}

	@Override
	public EasyUIDataGridResult getManageList(String manageStaId, int page, int rows) {
		// TODO Auto-generated method stub
		ParkingManageExample example=new ParkingManageExample();
		example.createCriteria().andManageStaIdLike("%"+manageStaId+"%");
		PageHelper.startPage(page, rows);
		List<ParkingManage> lists= parkingManageMapper.selectByExample(example);
		PageInfo<ParkingManage> pageInfo = new PageInfo<>(lists);
		EasyUIDataGridResult dataGrid = new EasyUIDataGridResult();
		dataGrid.setTotal((int) pageInfo.getTotal());
		dataGrid.setRows(lists);
		return dataGrid;
	}

	@Override
	public EasyUIDataGridResult getManageLists(String manageCarId, int page, int rows) {
		// TODO Auto-generated method stub
		ParkingManageExample example=new ParkingManageExample();
		example.createCriteria().andManageCarIdLike("%"+manageCarId+"%");
		PageHelper.startPage(page, rows);
		List<ParkingManage> lists= parkingManageMapper.selectByExample(example);
		PageInfo<ParkingManage> pageInfo = new PageInfo<>(lists);
		EasyUIDataGridResult dataGrid = new EasyUIDataGridResult();
		dataGrid.setTotal((int) pageInfo.getTotal());
		dataGrid.setRows(lists);
		return dataGrid;
	}

	@Override
	public EasyUIDataGridResult getManageIsNullListWx() {
		// TODO Auto-generated method stub
		List<ParkingManage> lists= parkingManageMapper.selectManageisnull();
		PageInfo<ParkingManage> pageInfo = new PageInfo<>(lists);
		EasyUIDataGridResult dataGrid = new EasyUIDataGridResult();
		dataGrid.setTotal((int) pageInfo.getTotal());
		dataGrid.setRows(lists);
		return dataGrid;
	}

	@Override
	public TaotaoResult updateStaId(ParkingManage manage) {
		// TODO Auto-generated method stub
		ParkingManageExample example=new ParkingManageExample();
		example.createCriteria().andManageStaIdEqualTo(manage.getManageStaId());
		parkingManageMapper.updateByExampleSelective(manage, example);
		return TaotaoResult.ok();
	}

}
