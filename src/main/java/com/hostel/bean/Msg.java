package com.hostel.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangpeng
 * @create 2019-04-28-14:52
 */
public class Msg {
    //状态码 -0成功， -200失败
    private int code;
    //提示信息
    private String msg;

    //用户返回给浏览器的数据
    private Map<String,Object> extend = new HashMap<String, Object>();

    public static Msg success(){
        Msg result = new Msg();
        result.setCode(0);
        result.setMsg("成功!");
        return result;
    }

    public static Msg fail(String msg){
        Msg result = new Msg();
        result.setCode(200);
        result.setMsg(msg);
        return result;
    }
    //链式操作返回this，实现msg.success().add(key,value);操作
    public Msg add(String key,Object value){
        this.getExtend().put(key,value);//通过getExtend取到本身msg的extend（map类型）成员，然后用MAP.PUT函数添加
        return this;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }


}