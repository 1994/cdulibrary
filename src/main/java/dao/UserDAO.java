package dao;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by reeco_000 on 2015/4/18.
 */
@Repository
public class UserDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Required
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //查询这个邮箱是否已经被注册
    public Boolean isEmail(String email){
        Boolean flag = false;
        String SQL = "SELECT id FROM db_user WHERE email = ?";
        try{
            Integer check = jdbcTemplate.queryForObject(SQL, Integer.class, email);
            if (check!=0)
                flag = true;
        } catch (Exception e){
            return flag;
        }

        return flag;
    }

    //查询这个用户是否被注册
    public Boolean isAdd(String username){
        Boolean flag = false;
        String SQL = "SELECT id FROM db_user WHERE username = ?";
        try{
            Integer check = jdbcTemplate.queryForObject(SQL, Integer.class, username);
            if (check!=0)
                flag = true;
        } catch (Exception e){
            return flag;
        }

        return flag;
    }

    //添加用户
    public Boolean addUser(User u){
        Boolean flag = false;
        String SQL = "INSERT INTO db_user(username,password,email,flag,test_email) VALUES(?,?,?,?,?)";
//        System.out.println(u.getUsername());
//        System.out.println(u.getPassword());
//        System.out.println(u.getEmail());
//        System.out.println(u.getFlag());
//        System.out.println(u.getTest_email());
        Integer check = jdbcTemplate.update(SQL, u.getUsername(), u.getPassword(), u.getEmail(), u.getFlag(), u.getTest_email());
        if(check>0)
            flag = true;
        return flag;
    }

    public Map<String, String> getAllUser() {
        String SQL = "SELECT username,password FROM db_user";
        Map<String, String> map = new HashMap<String, String>();
        try {
            List<Map<String, Object>> mapList = jdbcTemplate.queryForList(SQL);

            for (Map m : mapList) {
                map.put((String) m.get("username"), (String) m.get("password"));
            }
        }catch (Exception e){
            return null;
        }

        return map;
    }

}
