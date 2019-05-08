package com.hostel.service;

import com.hostel.bean.People;
import com.hostel.dao.PeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhangpeng
 * @create 2019-05-02-10:54
 */
@Service
public class PeopleService {
    @Autowired
    PeopleMapper peopleMapper;

    public Boolean checkPhone(String peoPhone) {
        Integer flag=peopleMapper.checkPhone(peoPhone);
        return flag != 0;
        
    }

    public void insertPeople(People people) {
        peopleMapper.insert(people);
    }

    public BigDecimal getConsume(String peoPhone) {
        return peopleMapper.selectConsumeByPhone(peoPhone);
    }

    public void updateConsumeByPhone(BigDecimal consume, String peoPhone) {
        peopleMapper.updateConsumeByPhone(consume,peoPhone);
    }

    public List<People> getAllPeople() {
        return peopleMapper.selectByExample(null);
    }

    public void updatePeopleByPrimaryKey(People people) {
        peopleMapper.updateByPrimaryKeySelective(people);
    }

    public void deletePeople(Integer id) {
        peopleMapper.deleteByPrimaryKey(id);
    }
}
