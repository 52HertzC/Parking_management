package com.park.parking.service.ServiceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.park.base.service.serviceImpl.BaseServiceImpl;
import com.park.bean.ParkingStall;
import com.park.mapper.ParkingStallMapper;
import com.park.parking.service.IManagermentService;

@Service
public class ManagermentImpl extends BaseServiceImpl<ParkingStall> implements IManagermentService{

	private ParkingStallMapper parkingStallMapper;
	
	@Resource
	public void setMapper(ParkingStallMapper mapper) {
		super.setBaseMapper(mapper);
		this.parkingStallMapper=mapper;
	}
}
