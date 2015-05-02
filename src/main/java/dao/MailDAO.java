package dao;

import entity.EmailDbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by reeco_000 on 2015/4/26.
 */

@Repository
public class MailDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Required
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     *
     * @param type 0为查询mailist0这张表，1为查询mailist3这张表
     * @return
     */
    public List<String> getAllMail(Integer type){
        String SQL = "SELECT DISTINCT email FROM ";
        switch (type){
            case 0:
                SQL=SQL+"db_mailist0";
                break;
            case 1:
                SQL=SQL+"db_mailist3";
                break;
            default:
                return null;
        }
        return  jdbcTemplate.queryForList(SQL,String.class);
    }

    public Map<String,String> getContent(Integer type,String email){
        String SQL = "SELECT DISTINCT name,remainDay FROM ";
        switch (type){
            case 0:
                SQL=SQL+"db_mailist0 WHERE email = ?";
                break;
            case 1:
                SQL=SQL+"db_mailist3 WHERE email = ?";
                break;
            default:
                return null;
        }

        List<Map<String,Object>> results = jdbcTemplate.queryForList(SQL, email);
        Map<String, String> map = new HashMap<String, String>();
        for(Map m:results){
            map.put(m.get("name").toString(),m.get("remainDay").toString());
        }

        return map;
    }

    /**
     *
     * @param type 0表示QQ，1表示其他
     * @return
     */
    public EmailDbContent getMail(Integer type,String email){
        EmailDbContent emailDbContent = new EmailDbContent();
        emailDbContent.setEmail(email);
        String tableName = (type==0)?"db_mailq":"db_mailnq";
        String SQL = "SELECT DISTINCT name FROM "+tableName+" WHERE email = ? and remainDay = ?";
        emailDbContent.setThreeDay(jdbcTemplate.queryForList(SQL,String.class,email,3));
        emailDbContent.setZeroDay(jdbcTemplate.queryForList(SQL, String.class,email,0));
        return emailDbContent;
    }

    public List<String> getMailist(Integer type){
        String tableName = (type==0)?"db_mailq":"db_mailnq";
        String SQL = "SELECT DISTINCT email FROM "+tableName;
        return  jdbcTemplate.queryForList(SQL,String.class);
    }
}
