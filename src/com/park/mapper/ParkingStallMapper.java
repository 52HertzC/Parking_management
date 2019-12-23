package com.park.mapper;

import com.park.bean.ParkingStall;
import com.park.bean.ParkingStallExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParkingStallMapper extends IBaseMapper<ParkingStall>{
    int countByExample(ParkingStallExample example);

    int deleteByExample(ParkingStallExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ParkingStall record);

    int insertSelective(ParkingStall record);

    List<ParkingStall> selectByExample(ParkingStallExample example);

    ParkingStall selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ParkingStall record, @Param("example") ParkingStallExample example);

    int updateByExample(@Param("record") ParkingStall record, @Param("example") ParkingStallExample example);

    int updateByPrimaryKeySelective(ParkingStall record);

    int updateByPrimaryKey(ParkingStall record);
}