package service;

import entity.Book;
import http.MyBrowser;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import jodd.util.StringPool;
import org.springframework.stereotype.Service;
import util.Analysis;

import java.util.List;

/**
 * Created by reeco_000 on 2015/4/18.
 */

@Service
public class UserHttpService {

    private final String URL_LOGIN = "http://202.115.80.170:8080/reader/redr_verify.php";

    private final String URL_LIST = "http://202.115.80.170:8080/reader/book_lst.php";

    private HttpRequest httpRequest;

    private HttpResponse httpResponse;



    public Boolean login(String username,String password){

        Boolean flag = false;

        httpRequest = HttpRequest
                .post(URL_LOGIN)
                .charset(StringPool.UTF_8)
                .accept(StringPool.UTF_8)
                .form("number", username)
                .form("passwd", password)
                .form("select", "cert_no")
                .form("returnUrl", "")
                .queryEncoding(StringPool.UTF_8);

        httpResponse = httpRequest.send();

        String statusPhrase = httpResponse.statusPhrase();

        Integer statusCode = httpResponse.statusCode();

        System.out.println(statusCode);
        if(statusCode==302&&statusPhrase.equals("Found")){
            flag = true;
        }
        return flag;
    }

    public List<Book> getBooks(String username,String password){

        MyBrowser myBrowser = new MyBrowser();

        httpRequest = HttpRequest
                .post(URL_LOGIN)
                .charset(StringPool.UTF_8)
                .accept(StringPool.UTF_8)
                .form("number", username)
                .form("passwd", password)
                .form("select", "cert_no")
                .form("returnUrl", "")
                .queryEncoding(StringPool.UTF_8);


        myBrowser.sendRequest(httpRequest);
        httpRequest = HttpRequest.get(URL_LIST);

        myBrowser.sendRequest(httpRequest);

        return Analysis.parse(myBrowser.getPage(),username);
    }

}
