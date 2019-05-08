package com.hostel.service;

import com.hostel.bean.Room;
import com.hostel.dao.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangpeng
 * @create 2019-04-28-14:55
 */
@Service
public class RoomService {
    @Autowired
    private RoomMapper roomMapper;

    public boolean checkroom() {
        Integer num = roomMapper.checkNull();
        return num != 0;
    }

    public void saveRoom(Room room) {
        roomMapper.insert(room);
    }

    public List<Room> getAllRoom() {
        return roomMapper.selectByExample(null);
    }

    public void deleteRoomById(Integer roomId) {
        roomMapper.deleteByPrimaryKey(roomId);
    }

    public double checkPrice(Integer roomNum) {
        return roomMapper.selectPriceByPrimaryKey(roomNum);
    }

    public String getRoomTypeByPrimaryKey(Integer ordRoomId) {
        return roomMapper.getRoomTypeByPrimaryKey(ordRoomId);
    }

    public void updateRoom(Room room) {
        roomMapper.updateByPrimaryKeySelective(room);
    }


}
