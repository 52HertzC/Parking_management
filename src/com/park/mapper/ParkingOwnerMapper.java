package com.park.mapper;

import com.park.bean.ParkingOwner;
import com.park.bean.ParkingOwnerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParkingOwnerMapper extends IBaseMapper<ParkingOwner>{
    int countByExample(ParkingOwnerExample example);

    int deleteByExample(ParkingOwnerExample example);

    int deleteByPrimaryKey(Long ownId);

    int insert(ParkingOwner record);

    int insertSelective(ParkingOwner record);

    List<ParkingOwner> selectByExample(ParkingOwnerExample example);

    ParkingOwner selectByPrimaryKey(Long ownId);

    int updateByExampleSelective(@Param("record") ParkingOwner record, @Param("example") ParkingOwnerExample example);

    int updateByExample(@Param("record") ParkingOwner record, @Param("example") ParkingOwnerExample example);

    int updateByPrimaryKeySelective(ParkingOwner record);

    int updateByPrimaryKey(ParkingOwner record);
}