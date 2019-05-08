import com.hostel.bean.Room;
import com.hostel.bean.RoomType;
import com.hostel.service.RoomService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author zhangpeng
 * @create 2019-04-30-10:27
 */
@Controller
public class TypeTest {
    @Autowired
    private static RoomService roomService;

    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        List<Room> rooms = roomService.getAllRoom();
        List<RoomType> roomsType = new ArrayList<RoomType>();
        RoomType roomType = new RoomType();//单个roomType
        //每一种房型房间数求出
        for (Room room : rooms) {
            if (map.containsKey(room.getRoomType())) {
                Integer num = map.get(room.getRoomType());
                map.put(room.getRoomType(), num + 1);
            } else {
                map.put(room.getRoomType(), 1);
            }
        }
        Set<String> set =map.keySet();//所有房间类型
        for (String key:set){//设置好RoomType的房间类型和数量
            roomType.setTypeName(key);
            roomType.setTypeNum(map.get(key));
            roomsType.add(roomType);
        }

        for(Room room :rooms){
            for (RoomType roomType1:roomsType){
                System.out.println(room.getRoomType());
                System.out.println(roomType1.getTypeName());
                //如果房间和房间类型的名字相同，那么将房间号加入这个房间类的房间号中
                if (room.getRoomType().equals(roomType1.getTypeName())){
                    roomType1.getTypeRoomNum().add(room.getRoomId());
                }
            }
        }
    }
}
