package entity;

import java.io.Serializable;

/**
 * Created by reeco_000 on 2015/4/18.
 */
public class BookDb implements Serializable{

    /**
     * 用于映射数据库中的书
     */

    private static final long serialVersionUID = 1L;

    private String username;

    private String code;

    private String name;

    private Integer remainDay;

    //0表示不需要提醒，1表示需要提醒，也就是还剩下3天或者0天
    private Integer status;

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

    public Integer getRemainDay() {
        return remainDay;
    }

    public void setRemainDay(Integer remainDay) {
        this.remainDay = remainDay;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
