package com.hostel.dao;

import com.hostel.bean.People;
import com.hostel.bean.PeopleExample;

import java.math.BigDecimal;
import java.util.List;

import com.hostel.bean.Room;
import org.apache.ibatis.annotations.Param;

public interface PeopleMapper {
    long countByExample(PeopleExample example);

    int deleteByExample(PeopleExample example);

    int insert(People record);

    int insertSelective(People record);

    List<People> selectByExample(PeopleExample example);

    int updateByExampleSelective(@Param("record") People record, @Param("example") PeopleExample example);

    int updateByExample(@Param("record") People record, @Param("example") PeopleExample example);

    Integer checkPhone(String peoPhone);

    BigDecimal selectConsumeByPhone(String peoPhone);

    void updateConsumeByPhone(@Param("consume") BigDecimal consume, @Param("phone") String phone);

    void updateByPrimaryKeySelective(People record);

    void deleteByPrimaryKey(Integer id);
}