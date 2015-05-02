package util;

import entity.Book;
import jodd.datetime.JDateTime;

/**
 * Created by reeco_000 on 2015/4/18.
 */
public class BookInjection {


    public static Book init(Book book,Integer type,String content){
       // Book book = new Book();
        type = type - (type/8)*8;

        switch (type){
            case 0:
                book.setCode(content);
                break;
            case 1:
                book.setName(content);
                break;
            case 2:
                book.setBorrowData(new JDateTime(content));
                break;
            case 3:
                book.setReturnData(new JDateTime(content.trim()));
                break;
            case 4:
                book.setFlag(Integer.parseInt(content));
                break;
            case 5:
                book.setPlace(content);
                break;
            case 6:
                book.setFlagButton(content);
                break;
        }
        return book;
    }

}
