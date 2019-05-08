package com.hostel.service;

import com.hostel.bean.Order;
import com.hostel.dao.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author zhangpeng
 * @create 2019-04-29-15:40
 */
@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;
    public void saveOrder(Order order) {
        orderMapper.insertSelective(order);
    }

    public List<Order> getAllOrder() {
        return orderMapper.selectByExample(null);
    }

    public Order orderBtn(Integer orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    public void updateStatus(Order order) {
        orderMapper.updateByPrimaryKeySelective(order);
    }

    public void editOrder(Order order) {
        orderMapper.updateByPrimaryKeySelective(order);
    }

    public void deleteOrder(Integer orderId) {
        orderMapper.deleteByPrimaryKey(orderId);
    }

    public Integer checkDeleteRoom(Integer roomId) {
        return orderMapper.checkDeleteRoom(roomId);
    }

    public double selectPriceByDate(Date time) {
        try {
            return orderMapper.selectPriceByDate(time);
        } catch (Exception e) {
            return 0;
        }
    }

    public Integer selectNightByDate(Date time) {
        try {
            return  orderMapper.selectNightByDate(time);
        } catch (Exception e) {
            System.out.println(time);
            return 999999999;
        }
    }
}
