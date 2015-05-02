package service;

import dao.BookDbDAO;
import dao.UserDAO;
import entity.Book;
import entity.BookDb;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.BookToDb;

import java.util.List;

/**
 * Created by reeco_000 on 2015/4/19.
 */

@Service
public class UserService {

    private UserDAO userDAO;

    private BookDbDAO bookDbDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Autowired
    public void setBookDbDAO(BookDbDAO bookDbDAO) {
        this.bookDbDAO = bookDbDAO;
    }
    public Boolean addUser(User u,List<Book> books){
        Boolean temp = userDAO.addUser(u);
        List<BookDb> bookDbs = BookToDb.convert(books);
        bookDbDAO.addBookBatch(bookDbs);
        return temp;
    }


    public Boolean isEmail(String email){
        return userDAO.isEmail(email);
    }

    public Boolean isExist(String username){
        return userDAO.isAdd(username);
    }
}
