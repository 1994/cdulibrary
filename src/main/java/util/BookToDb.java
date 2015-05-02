package util;

import entity.Book;
import entity.BookDb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reeco_000 on 2015/4/19.
 */
public class BookToDb {

    public static List<BookDb> convert(List<Book>books){
        List<BookDb> bookDbs = new ArrayList<BookDb>();
        for(Book book:books){
            BookDb bookDb = new BookDb();
            bookDb.setUsername(book.getUsername());
            bookDb.setCode(book.getCode());
            bookDb.setName(book.getName());
            bookDb.setRemainDay(book.getRemainDay());

            if(book.getRemainDay()==3||book.getRemainDay()==0){
                bookDb.setStatus(1);
            }
            else
            bookDb.setStatus(0);
            bookDbs.add(bookDb);
        }

        return bookDbs;
    }
}
