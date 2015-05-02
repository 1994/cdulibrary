package util;

import entity.Book;
import jodd.jerry.Jerry;
import jodd.jerry.JerryFunction;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by reeco_000 on 2015/4/18.
 */
public class Analysis {

    private static final String CLASSNAME = ".whitetext";

    private static final List<Book> books = new ArrayList<Book>();

    public static List<Book> parse(String page, final String username){
        books.clear();
        Jerry doc = Jerry.jerry(page);

      //  final List<Book> books = new ArrayList<Book>();
        doc.$(CLASSNAME).each(new JerryFunction() {
            Book book = new Book(username);

            @Override
            public boolean onNode(Jerry $this, int index) {
                if (index % 8 == 0) {
                    book = new Book(username);
                    books.add(book);
                }
                BookInjection.init(book, index, $this.text());
                return true;
            }
        });


        return books;
    }
}
