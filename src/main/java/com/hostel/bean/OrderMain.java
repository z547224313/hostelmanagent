package com.hostel.bean;

/**
 * @author zhangpeng
 * @create 2019-05-02-21:15
 */
public class OrderMain {
    /*
     *此类存放在生成主表时候用的Order元素：订单日期，几晚，订单状态，下订单的roomId
     *
     * */
    private String ordTime;

    private Integer night;

    private String ordStatus;

    private Integer ordRoomId;

    private String endTime;

    private String orderFee;

    private Integer ordId;

    private String peoName;

    private String peoPhone;

    private String room;

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getOrderFee() {
        return orderFee;
    }

    public void setOrderFee(String orderFee) {
        this.orderFee = orderFee;
    }

    public String getPeoPhone() {
        return peoPhone;
    }

    public void setPeoPhone(String peoPhone) {
        this.peoPhone = peoPhone;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getOrdId() {
        return ordId;
    }

    public void setOrdId(Integer ordId) {
        this.ordId = ordId;
    }


    public String getPeoName() {
        return peoName;
    }

    public void setPeoName(String peoName) {
        this.peoName = peoName;
    }


    public OrderMain(String ordTime, Integer night, String ordStatus, Integer ordRoomId) {
        this.ordTime = ordTime;
        this.night = night;
        this.ordStatus = ordStatus;
        this.ordRoomId = ordRoomId;
    }

    public OrderMain(){

    }

    public String getOrdTime() {
        return ordTime;
    }

    public void setOrdTime(String ordTime) {
        this.ordTime = ordTime;
    }

    public Integer getNight() {
        return night;
    }

    public void setNight(Integer night) {
        this.night = night;
    }

    public String getOrdStatus() {
        return ordStatus;
    }

    public void setOrdStatus(String ordStatus) {
        this.ordStatus = ordStatus;
    }

    public Integer getOrdRoomId() {
        return ordRoomId;
    }

    public void setOrdRoomId(Integer ordRoomId) {
        this.ordRoomId = ordRoomId;
    }
}
