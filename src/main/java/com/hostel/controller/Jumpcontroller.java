package com.hostel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangpeng
 * @create 2019-04-28-14:43
 */
@Controller
public class Jumpcontroller {
    @RequestMapping("setting")
    public String setting(){return "setting";}
    @RequestMapping("roomPage")
    public String roomPage(){return "roomPage";}
    @RequestMapping("orderPage")
    public String orderPage(){return "orderPage";}
    @RequestMapping("peoplePage")
    public String peoplePage(){return "peoplePage";}
    @RequestMapping("earningPage")
    public String earningPage(){return "earningPage";}
}
