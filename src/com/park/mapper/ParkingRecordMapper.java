package com.park.mapper;

import com.park.bean.ParkingRecord;
import com.park.bean.ParkingRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParkingRecordMapper {
    int countByExample(ParkingRecordExample example);

    int deleteByExample(ParkingRecordExample example);

    int deleteByPrimaryKey(Long recId);

    int insert(ParkingRecord record);

    int insertSelective(ParkingRecord record);

    List<ParkingRecord> selectByExample(ParkingRecordExample example);

    ParkingRecord selectByPrimaryKey(Long recId);

    int updateByExampleSelective(@Param("record") ParkingRecord record, @Param("example") ParkingRecordExample example);

    int updateByExample(@Param("record") ParkingRecord record, @Param("example") ParkingRecordExample example);

    int updateByPrimaryKeySelective(ParkingRecord record);

    int updateByPrimaryKey(ParkingRecord record);

    //×Ô¶¨Òå
	List<ParkingRecord> selectLikeRecord(String recCarId);

	List<ParkingRecord> selectRecordIsN(String recCarId);
}