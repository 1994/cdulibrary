package dao;

import entity.BookDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reeco_000 on 2015/4/19.
 */
@Repository
public class BookDbDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Required
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Boolean updateBook(BookDb bookDb){
        String SQL = "UPDATE db_book SET remainDay = ? WHERE username = ? and code = ?";
        Integer check = jdbcTemplate.update(SQL, bookDb.getRemainDay(), bookDb.getUsername(), bookDb.getCode());
        if(check>0)
            return true;
        return false;
    }

    //批量插入书
    public void addBookBatch(List<BookDb> bookDbList){
        System.out.println("运行了");
        String SQL = "INSERT INTO db_book VALUES(?,?,?,?,?)";
        List<Object[]> batchArgs = new ArrayList<Object[]>();
        for(BookDb bookDb:bookDbList){
            Object[] args = {bookDb.getCode(),bookDb.getUsername(),bookDb.getName(),bookDb.getRemainDay(),bookDb.getStatus()};
            batchArgs.add(args);
        }
        jdbcTemplate.batchUpdate(SQL, batchArgs);
    }


}
