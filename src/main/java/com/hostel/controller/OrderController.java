package com.hostel.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hostel.bean.*;
import com.hostel.service.OrderService;
import com.hostel.service.RoomService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zhangpeng
 * @create 2019-04-29-15:39
 */
@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    RoomService roomService;

    @RequestMapping(value = "/date",method = RequestMethod.POST)
    @ResponseBody
    public Msg handDate(@RequestParam(value = "time") String time) throws Exception {
        //String md = time.substring(5,10);
        DateFormat df = new SimpleDateFormat("yy-MM-dd");
        Date dd = df.parse(time);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dd);
        List<String> dateList =new ArrayList<String>();
        for(int i=0;i<30;++i){
            dateList.add(df.format(calendar.getTime()));
            calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
        }
        return Msg.success().add("dateList",dateList);
    }

    @RequestMapping(value = "/order",method = RequestMethod.POST)
    @ResponseBody
    public Msg saveOrder(@RequestParam(value = "peoName") String peoName
            ,@RequestParam(value = "peoPhone") String peoPhone
            ,@RequestParam(value = "order_time") String order_time
            ,@RequestParam(value = "night") Integer night
            ,@RequestParam(value = "room_num") String room_num
            ,@RequestParam(value = "ord_fee") Long ord_fee
            ,@RequestParam(value = "ord_status") String ord_status) throws ParseException {
            String[] strings = room_num.split("-");
            Integer roomId = Integer.valueOf(strings[1]);
            DateFormat df = new SimpleDateFormat("yy-MM-dd");
            Date dd = df.parse(order_time);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dd);
            //上面是数据处理
            Order order = new Order();//产生订单对象
            order.setOrdPeoName(peoName);
            order.setOrdPeoPhone(peoPhone);
            order.setNight(night);
            order.setOrdFee(ord_fee);
            order.setOrdRoomId(roomId);
            order.setOrdTime(dd);
            order.setOrdStatus(ord_status);
            orderService.saveOrder(order);//保存订单
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "/orderBtn",method = RequestMethod.GET)
    public Msg orderBtn(@RequestParam(value = "orderId") Integer orderId){
        Order order=orderService.orderBtn(orderId);
        Date begin = order.getOrdTime();//入住日期
        Integer night = order.getNight();//持续时间
        DateFormat df = new SimpleDateFormat("yy-MM-dd");
        String beginTime = df.format(begin);
        String endTime = getEndTime(begin,night);

        return Msg.success().add("peoName",order.getOrdPeoName()).add("peoPhone",order.getOrdPeoPhone())
                .add("beginTime",beginTime).add("endTime",endTime);
    }
    @ResponseBody
    @RequestMapping(value = "/status",method = RequestMethod.POST)
    public Msg updateStatus(@RequestParam(value = "orderId") Integer orderId,
                            @RequestParam(value = "status") String status){
        Order order = new Order();
        order.setOrdId(orderId);
        order.setOrdStatus(status);
        orderService.updateStatus(order);
        return Msg.success();
    }
    @ResponseBody
    @RequestMapping(value = "/orderx",method = RequestMethod.GET)
    public Msg getAll(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        List<Order> allOrder = orderService.getAllOrder();
        DateFormat df = new SimpleDateFormat("yy-MM-dd");
        List<OrderMain> orderMains = new ArrayList<OrderMain>();
        for (Order order:allOrder){
            OrderMain orderMain = new OrderMain();
            orderMain.setOrdTime(df.format(order.getOrdTime()));//设置预定时间
            orderMain.setEndTime(getEndTime(order.getOrdTime(),order.getNight()));//设置结束时间
            orderMain.setPeoName(order.getOrdPeoName());
            orderMain.setOrderFee(String.valueOf(order.getOrdFee()));
            orderMain.setOrdStatus(getStatus(order.getOrdStatus()));
            orderMain.setPeoPhone(order.getOrdPeoPhone());
            orderMain.setRoom(roomService.getRoomTypeByPrimaryKey(order.getOrdRoomId())+"-"+order.getOrdRoomId());//设置房间类型
            orderMain.setOrdId(order.getOrdId());
            orderMains.add(orderMain);
        }
        return Msg.success().add("orderMain",orderMains);
    }

    private String getEndTime(Date begin, Integer night){
        DateFormat df = new SimpleDateFormat("yy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(begin);
        calendar.add(Calendar.DAY_OF_MONTH, night);//加出结束时间
        return df.format(calendar.getTime());
    }

    private String getStatus(String status){
        if(status.equals("1")){
            return "已预定";
        }
        if(status.equals("2")){
            return "已入住";
        }
        if(status.equals("3")){
            return "已退房";
        }
        return "错误";
    }

    @ResponseBody
    @RequestMapping(value = "orderx",method = RequestMethod.POST)
    public Msg editOrder(@RequestParam(value = "orderId") Integer orderId,
                         @RequestParam(value = "peoName") String peoName,
                         @RequestParam(value = "peoPhone") String peoPhone){
        Order order = new Order();
        order.setOrdId(orderId);
        order.setOrdPeoName(peoName);
        order.setOrdPeoPhone(peoPhone);
        orderService.editOrder(order);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "deleteOrder",method = RequestMethod.POST)
    public Msg deleteOrder(@RequestParam(value = "orderId") Integer orderId){
        orderService.deleteOrder(orderId);
        return Msg.success();
    }
    @ResponseBody
    @RequestMapping(value = "/statistic",method = RequestMethod.GET)
    public Msg statistic (){
        List<Order> orders = new ArrayList<Order>();
        orders = orderService.getAllOrder();
        double incomes = 0;
        Integer allNight=0;
        int ADR = 0; //平均房价
        for (Order order:orders){
            allNight=allNight+order.getNight();
            incomes = order.getOrdFee()+incomes;
        }
        List<Room> rooms=roomService.getAllRoom();
        ADR=(int)incomes/allNight;
        return Msg.success().add("allNight",allNight).add("income",incomes).add("ADR",ADR);
    }

    @RequestMapping(value = "/incomeChart",method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String, Object> incomeChart(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //得到今天的日期
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -30);//减出结束时间
        HashMap<String,Object> msg = new HashMap<String, Object>();
        List<String> Days=new ArrayList<String>();
        List<Double> Prices=new ArrayList<Double>();
        for(int i=0;i<30;i++){
           Double price= orderService.selectPriceByDate(calendar.getTime());
           String thisDay = df.format(calendar.getTime());
           if(price==null){
               price= (double) 0;
           }
            Days.add(thisDay);
            Prices.add(price);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        msg.put("Date",Days);
        msg.put("Price",Prices);

        return msg;
    }
    @RequestMapping(value = "/ADRChart",method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String, Object> ADRChart(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //得到今天的日期
        Calendar calendar = Calendar.getInstance();
        List<Room> rooms = roomService.getAllRoom();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -30);//减出结束时间
        HashMap<String,Object> msg = new HashMap<String, Object>();
        List<String> Days=new ArrayList<String>();
        List<Double> Prices=new ArrayList<Double>();
        for(int i=0;i<30;i++){
            Double price= orderService.selectPriceByDate(calendar.getTime());
            String thisDay = df.format(calendar.getTime());
            Integer dayNight = orderService.selectNightByDate(calendar.getTime());
            if(price==null){
                price= (double) 0;
            }
            if(dayNight==null)
                price=0.0;
            else
                price=price/dayNight;

            Days.add(thisDay);
            Prices.add(price);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        msg.put("Date",Days);
        msg.put("Price",Prices);

        return msg;
    }
}
