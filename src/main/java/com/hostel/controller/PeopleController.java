package com.hostel.controller;

import com.hostel.bean.Msg;
import com.hostel.bean.Order;
import com.hostel.bean.People;
import com.hostel.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author zhangpeng
 * @create 2019-05-02-10:54
 */
@Controller
public class PeopleController {
    @Autowired
    PeopleService peopleService;

    @RequestMapping(value = "/people",method = RequestMethod.POST)
    @ResponseBody
    public Msg savePeople(@RequestParam(value = "peoName") String peoName
            , @RequestParam(value = "peoPhone") String peoPhone
            , @RequestParam(value = "ord_fee") String ord_fee) {
        //保存客人信息，先检查有没有这个手机号，有了累计消费
        //没有创建新的客人
        Boolean flag=peopleService.checkPhone(peoPhone);
        //flag==true有客人 false没有
        //将String转BIGdecimal
        BigDecimal fee=new BigDecimal(ord_fee);
        //设置小数位数，第一个变量是小数位数，第二个变量是取舍方法(四舍五入)
        fee=fee.setScale(2, BigDecimal.ROUND_HALF_UP);
        if (!flag){
            //没有这个手机号存在
            People people = new People();
            people.setPeoPhone(peoPhone);
            people.setPeoName(peoName);
            people.setConsume(fee);
            peopleService.insertPeople(people);
            return Msg.success();
        }else{
            //有这个手机号
             BigDecimal consume=peopleService.getConsume(peoPhone);//获得当前手机号所消费值
             consume=consume.add(fee);
             peopleService.updateConsumeByPhone(consume,peoPhone);//再把这个手机号消费进行更新
            return Msg.success();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/people",method = RequestMethod.GET)
    public Msg getAllPeople(){
       List<People> people= peopleService.getAllPeople();
       return Msg.success().add("people",people);
    }

    @ResponseBody
    @RequestMapping(value = "/peoplex",method = RequestMethod.POST)
    public Msg updatePeople(@RequestParam(value = "peoName") String peoName
            , @RequestParam(value = "peoPhone") String peoPhone
            , @RequestParam(value = "id") String id){
        People people = new People();
        people.setId(Integer.valueOf(id));
        people.setPeoName(peoName);
        people.setPeoPhone(peoPhone);
        peopleService.updatePeopleByPrimaryKey(people);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "deletePeople",method = RequestMethod.POST)
    public Msg deleteOrder(@RequestParam(value = "id") Integer Id){
        peopleService.deletePeople(Id);
        return Msg.success();
    }
}
