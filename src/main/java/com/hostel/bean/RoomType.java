package com.hostel.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangpeng
 * @create 2019-04-30-9:55
 */
public class RoomType {
    private String typeName;
    private Integer typeNum;
    private List<Integer> typeRoomNum;

    public RoomType() {
        typeRoomNum=new ArrayList<Integer>();
    }

    public List<Integer> getTypeRoomNum() {
        return typeRoomNum;
    }

    public void setTypeRoomNum(List<Integer> typeRoomNum) {
        this.typeRoomNum = typeRoomNum;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getTypeNum() {
        return typeNum;
    }

    public void setTypeNum(Integer typeNum) {
        this.typeNum = typeNum;
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "typeName='" + typeName + '\'' +
                ", typeNum=" + typeNum +
                '}';
    }
}
