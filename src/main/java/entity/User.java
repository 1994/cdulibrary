package entity;

import java.io.Serializable;

/**
 * Created by reeco_000 on 2015/4/18.
 */
public class User implements Serializable{


    private Integer id;

    private String username;

    private String password;

    private String email;

    //已激活是1，未激活为0
    private Integer flag;

    //注册完成后会收到一封测试邮件，1为已发送，0为未发送
    private Integer test_email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getTest_email() {
        return test_email;
    }

    public void setTest_email(Integer test_email) {
        this.test_email = test_email;
    }
}
