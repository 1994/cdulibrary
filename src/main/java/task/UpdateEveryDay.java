package task;

import dao.BookDbDAO;
import dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import service.UserHttpService;
import util.BookToDb;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by reeco_000 on 2015/4/25.
 */
@Component
public class UpdateEveryDay {

    private UserHttpService userHttpService;

    private BookDbDAO bookDbDAO;

    private UserDAO userDAO;

    private Map<String, String> users = new HashMap<String, String>();

    @Autowired
    public void setUserHttpService(UserHttpService userHttpService) {
        this.userHttpService = userHttpService;
    }

    @Autowired
    public void setBookDbDAO(BookDbDAO bookDbDAO) {
        this.bookDbDAO = bookDbDAO;
    }

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public  void updateBooks() {

        users.clear();
        users = userDAO.getAllUser();
        Iterator iter = users.entrySet().iterator();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            bookDbDAO.addBookBatch(BookToDb.convert(userHttpService.getBooks(entry.getKey().toString(), entry.getValue().toString())));
        }
    }


    //@Scheduled(fixedRate = 1000*60*1)
    @Scheduled(cron = "0 0 1 * * *")
    public void task(){
        updateBooks();
    }
}
