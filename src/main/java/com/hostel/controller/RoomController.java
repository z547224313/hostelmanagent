package com.hostel.controller;

import com.hostel.bean.*;
import com.hostel.service.OrderService;
import com.hostel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author zhangpeng
 * @create 2019-04-28-14:54
 */
@Controller
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/roomcheck")
    public String roomcheck(){
        //没有添加房间时跳转到管理页面
        boolean haverooms = roomService.checkroom();
        if (haverooms)
            return "roomPage";
        else
            return "setting";
    }

    @RequestMapping(value = "/room",method = RequestMethod.POST)
    @ResponseBody
    public Msg saveRoom(Room room){
        //保存所有房间
        roomService.saveRoom(room);
        return Msg.success();
    }

    @RequestMapping(value = "/room",method = RequestMethod.GET)
    @ResponseBody
    public Msg getAllRoom(){
        //查询所有房间
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        List<Room> rooms = roomService.getAllRoom();
        //每一种房型房间数求出
        for (Room room : rooms) {
            if (map.containsKey(room.getRoomType())) {
                Integer num = map.get(room.getRoomType());
                map.put(room.getRoomType(), num + 1);
            } else {
                map.put(room.getRoomType(), 1);
            }
        }
        for(Room room : rooms){
            //为每一个房间对象设置好此类型房间数量
            room.setRoomNum(map.get(room.getRoomType()));
        }
        return Msg.success().add("allroom",rooms);
    }

    @ResponseBody
    @RequestMapping(value = "/room/{roomId}",method = RequestMethod.DELETE)
    public Msg deleteRoomById(@PathVariable("roomId") Integer roomId){
        //先查询此房间有无已预定或入住信息
        Integer flag=orderService.checkDeleteRoom(roomId);
        if(flag!=0){
            return Msg.fail("删除失败，该房间仍有关联订单请删除订单后重试");
        }
        else{
            roomService.deleteRoomById(roomId);
            return Msg.success();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/roomType",method = RequestMethod.GET)
    public Msg getRoomTypeList(){
        //这个方法把数据库中room读出来进行type归类整理
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        List<Room> rooms = roomService.getAllRoom();
        List<RoomType> roomsType = new ArrayList<RoomType>();
        //每一种房型房间数求出
        for (Room room : rooms) {
            if (map.containsKey(room.getRoomType())) {
                Integer num = map.get(room.getRoomType());
                map.put(room.getRoomType(), num + 1);
            } else {
                map.put(room.getRoomType(), 1);
            }
        }
        Set<String>set =map.keySet();//所有房间类型
        for (String key:set){//设置好RoomType的房间类型和数量
            RoomType roomType = new RoomType();//单个roomType
            //System.out.println("set中"+key+map.get(key));
            roomType.setTypeName(key);
            roomType.setTypeNum(map.get(key));
            //System.out.println("将要插入的单个"+roomType.getTypeName()+roomType.getTypeNum());
            roomsType.add(roomType);
            //System.out.println(roomsType.toString());
        }

        for(Room room :rooms){
           for (RoomType roomType1:roomsType){
               //如果房间和房间类型的名字相同，那么将房间号加入这个房间类的房间号中
               if (room.getRoomType().equals(roomType1.getTypeName())){
                   roomType1.getTypeRoomNum().add(room.getRoomId());
               }
           }
        }

        /*
         * 以下内容只在产生房态主表时应用
         * */

        //1、先取order里所有值然后筛选
        List<Order> orders=orderService.getAllOrder();
        List<OrderMain> orderMains = new ArrayList<OrderMain>();
        for(Order order:orders){
            if(!order.getOrdStatus().equals("0")){
                //2、如果order的状态不是空房或退房
                //Date ordTime, Integer night, String ordStatus, Integer ordRoomId
                //把OrderTime转成string
               String date= (new SimpleDateFormat("yyyy-MM-dd").format(order.getOrdTime()));
                OrderMain orderMain = new OrderMain(date
                        ,order.getNight(),order.getOrdStatus(),order.getOrdRoomId());
                orderMains.add(orderMain);
                orderMain.setPeoName(order.getOrdPeoName());//将客人姓名传来
                orderMain.setOrdId(order.getOrdId());//将独一orderId放入

            }
        }
        return Msg.success().add("roomType",roomsType).add("orderMain",orderMains);
    }

    @ResponseBody
    @RequestMapping(value = "/checkPrice",method = RequestMethod.GET)
    public Msg checkPrice(@RequestParam(value = "title") String title){
        //这里接受的title是房间类型名-房间号格式的，房间类型名是汉字乱码，但用不到
        String[] strings = title.split("-");
        Integer roomNum = Integer.valueOf(strings[1]);
        double price=roomService.checkPrice(roomNum);
        return Msg.success().add("price",price);
    }

    @ResponseBody
    @RequestMapping(value = "/calPrice",method = RequestMethod.GET)
    public Msg calPrice(@RequestParam(value = "title") String title
            ,@RequestParam(value = "night") Integer night){
        String[] strings = title.split("-");
        Integer roomNum = Integer.valueOf(strings[1]);
        double price=roomService.checkPrice(roomNum);
        return Msg.success().add("price",price*night);
    }
    @ResponseBody
    @RequestMapping(value = "/roomx",method = RequestMethod.POST)
    public Msg updateRoom(@RequestParam(value = "roomType") String roomType
            , @RequestParam(value = "roomPrice") String roomPrice
            , @RequestParam(value = "roomId") Integer roomId){
        Integer flag=orderService.checkDeleteRoom(roomId);
        BigDecimal bd=new BigDecimal(roomPrice);
        Room room = new Room();
        room.setRoomId(roomId);
        room.setRoomType(roomType);
        room.setRoomPrice(bd);
        if(flag!=0){
            return Msg.fail("编辑失败，此房间仍有相关联订单，请修改订单后重试");
        }
        else {
            roomService.updateRoom(room);
            return Msg.success();
        }
    }
}
