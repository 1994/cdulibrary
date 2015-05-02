package dao;

import entity.BookDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by reeco_000 on 2015/4/18.
 */
@Repository
public class BookDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Required
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //查询所有未还的书
    public List<BookDb> getToReturn(){
        String SQL = "";
        return null;
    }


}
