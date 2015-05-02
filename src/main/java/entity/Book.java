package entity;

import jodd.datetime.JDateTime;
import util.DataConvert;

import java.io.Serializable;

/**
 * Created by reeco_000 on 2015/4/18.
 */
public class Book implements Serializable{

    public Book() {
    }

    public Book(String code, String name, JDateTime borrowData, JDateTime returnData, String place, Integer flag, String other, String flagButton) {
        this.code = code;
        this.name = name;
        this.borrowData = borrowData;
        this.returnData = returnData;
        this.place = place;
        this.flag = flag;
        this.other = other;
        this.flagButton = flagButton;
    }


    public Book(String username) {
        this.username = username;
    }

    private String username;

    private String code;

    private String name;

    private JDateTime borrowData;

    private JDateTime returnData;

    private JDateTime now;

    private String place;

    //续借
    private Integer flag;

    private String other;

    private String flagButton;

    //剩余天数
    private Integer remainDay;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JDateTime getBorrowData() {
        return borrowData;
    }

    public void setBorrowData(JDateTime borrowData) {
        this.borrowData = borrowData;
    }

    public JDateTime getReturnData() {
        return returnData;
    }

    public void setReturnData(JDateTime returnData) {
        now = new JDateTime();
        setRemainDay(DataConvert.remainDay(now,returnData));
        this.returnData = returnData;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getFlagButton() {
        return flagButton;
    }

    public void setFlagButton(String flagButton) {
        this.flagButton = flagButton;
    }

    public Integer getRemainDay() {
        return remainDay;
    }

    public void setRemainDay(Integer remainDay) {
        this.remainDay = remainDay;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
