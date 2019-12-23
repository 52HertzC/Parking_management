package com.park.mapper;

import com.park.bean.ParkingRes;
import com.park.bean.ParkingResExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParkingResMapper {
    int countByExample(ParkingResExample example);

    int deleteByExample(ParkingResExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ParkingRes record);

    int insertSelective(ParkingRes record);

    List<ParkingRes> selectByExample(ParkingResExample example);

    ParkingRes selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ParkingRes record, @Param("example") ParkingResExample example);

    int updateByExample(@Param("record") ParkingRes record, @Param("example") ParkingResExample example);

    int updateByPrimaryKeySelective(ParkingRes record);

    int updateByPrimaryKey(ParkingRes record);
    
    //×Ô¶¨Òå
    int deletebyrescarid(String resCarId);
}