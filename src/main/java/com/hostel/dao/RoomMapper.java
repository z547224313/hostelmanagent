package com.hostel.dao;

import com.hostel.bean.Room;
import com.hostel.bean.RoomExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoomMapper {
    Integer checkNull();
    long countByExample(RoomExample example);

    int deleteByExample(RoomExample example);

    int deleteByPrimaryKey(Integer roomId);

    int insert(Room record);

    int insertSelective(Room record);

    List<Room> selectByExample(RoomExample example);

    Room selectByPrimaryKey(Integer roomId);

    int updateByExampleSelective(@Param("record") Room record, @Param("example") RoomExample example);

    int updateByExample(@Param("record") Room record, @Param("example") RoomExample example);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);

    double selectPriceByPrimaryKey(Integer roomId);

    String getRoomTypeByPrimaryKey(Integer ordRoomId);

}