package com.hostel.bean;

import java.util.Date;

public class Order {
    private Integer ordId;

    private String ordPeoName;

    private String ordPeoPhone;

    private Date ordTime;

    private Integer night;

    private String ordStatus;

    private Long ordFee;

    private Integer ordRoomId;

    public Integer getOrdId() {
        return ordId;
    }

    public void setOrdId(Integer ordId) {
        this.ordId = ordId;
    }

    public String getOrdPeoName() {
        return ordPeoName;
    }

    public void setOrdPeoName(String ordPeoName) {
        this.ordPeoName = ordPeoName == null ? null : ordPeoName.trim();
    }

    public String getOrdPeoPhone() {
        return ordPeoPhone;
    }

    public void setOrdPeoPhone(String ordPeoPhone) {
        this.ordPeoPhone = ordPeoPhone == null ? null : ordPeoPhone.trim();
    }

    public Date getOrdTime() {
        return ordTime;
    }

    public void setOrdTime(Date ordTime) {
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
        this.ordStatus = ordStatus == null ? null : ordStatus.trim();
    }

    public Long getOrdFee() {
        return ordFee;
    }

    public void setOrdFee(Long ordFee) {
        this.ordFee = ordFee;
    }

    public Integer getOrdRoomId() {
        return ordRoomId;
    }

    public void setOrdRoomId(Integer ordRoomId) {
        this.ordRoomId = ordRoomId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ordId=" + ordId +
                ", ordPeoName='" + ordPeoName + '\'' +
                ", ordPeoPhone='" + ordPeoPhone + '\'' +
                ", ordTime=" + ordTime +
                ", night=" + night +
                ", ordStatus='" + ordStatus + '\'' +
                ", ordFee=" + ordFee +
                ", ordRoomId=" + ordRoomId +
                '}';
    }
}