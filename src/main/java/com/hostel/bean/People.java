package com.hostel.bean;

import java.math.BigDecimal;

public class People {
    private String peoName;

    private String peoPhone;

    private BigDecimal consume;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPeoName() {
        return peoName;
    }

    public void setPeoName(String peoName) {
        this.peoName = peoName == null ? null : peoName.trim();
    }

    public String getPeoPhone() {
        return peoPhone;
    }

    public void setPeoPhone(String peoPhone) {
        this.peoPhone = peoPhone == null ? null : peoPhone.trim();
    }

    public BigDecimal getConsume() {
        return consume;
    }

    public void setConsume(BigDecimal consume) {
        this.consume = consume;
    }
}