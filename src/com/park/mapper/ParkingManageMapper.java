package com.park.mapper;

import com.park.bean.ParkingManage;
import com.park.bean.ParkingManageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParkingManageMapper {
    int countByExample(ParkingManageExample example);

    int deleteByExample(ParkingManageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ParkingManage record);

    int insertSelective(ParkingManage record);

    List<ParkingManage> selectByExample(ParkingManageExample example);

    ParkingManage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ParkingManage record, @Param("example") ParkingManageExample example);

    int updateByExample(@Param("record") ParkingManage record, @Param("example") ParkingManageExample example);

    int updateByPrimaryKeySelective(ParkingManage record);

    int updateByPrimaryKey(ParkingManage record);
    
    //查询两个表
    List<ParkingManage> selectByManageAndRecord();
    int updateByManageCarId(String manageCarId);
    
    List<ParkingManage> selectLikeManage(@Param("manageArea") String manageArea);
    //查询车牌号不为空
    List<ParkingManage> selectManageisnull();
}