package util;

import com.alibaba.fastjson.JSON;
import entity.Book;
import entity.EmailDbContent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by reeco_000 on 2015/4/26.
 */
public class MapUtil {

    /**
     * sendcloud用
     * @param results
     * @return
     */
    public static Map<String,String> mapToContent(Map<String,Map<String,String>> results){
        Map<String,String> content = new HashMap<String, String>();
        for (Map.Entry<String, Map<String,String>> entry : results.entrySet()) {
            content.put(entry.getKey(),MapUtil.mapToString(entry.getValue()));
        }
        return content;
    }

    /**
     * sendcloud用
     * @param results
     * @return
     */
    public static String mapToString(Map<String,String> results){
        //StringBuilder stringBuilder = new StringBuilder("您的以下几本图书：");
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : results.entrySet()) {
            stringBuilder.append("<strong>[");
            stringBuilder.append(entry.getKey());
            stringBuilder.append("]</strong> 、");
        }
        stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "");
        stringBuilder.append("还有三天到期");
       // stringBuilder.append("<br />");
       // stringBuilder.append("————来自中国好同学的善意提醒");

        return stringBuilder.toString();
    }

    /**
     * mailgun用
     * @param results
     * @return
     */
    public static String mapToJSON(Map<String,Map<String,String>> results){
        Map<String,Map<String,String>> content = new HashMap<String, Map<String, String>>();
        for (Map.Entry<String, Map<String,String>> entry : results.entrySet()) {
            content.put(entry.getKey(),MapUtil.mapToString2(entry.getValue()));
        }
       // System.out.println(content);
        return JSON.toJSONString(content);
    }

    /**
     * mailgun用
     * @param results
     * @return
     */
    public static Map<String,String> mapToString2(Map<String,String> results){
        StringBuilder stringBuilder = new StringBuilder();
        Map<String,String> content = new HashMap<String, String>();
        for (Map.Entry<String, String> entry : results.entrySet()) {
            stringBuilder.append("<strong>[");
            stringBuilder.append(entry.getKey());
            stringBuilder.append("]</strong> 、");
        }
        stringBuilder.replace(stringBuilder.length()-1,stringBuilder.length(),"");
        stringBuilder.append("还有三天到期");
        content.put("books",stringBuilder.toString());
        return content;
    }

    /**
     * Map<email，邮件content>
     * @param
     * @return
     */
    public static Map<String,String> emailDbToMap(List<EmailDbContent> emailDbContents){
        Map<String,String> results = new HashMap<String, String>();

        for(EmailDbContent emailDbContent:emailDbContents){

            List<String> threeDay = emailDbContent.getThreeDay();
            List<String> zeroDay = emailDbContent.getZeroDay();
            StringBuilder stringBuilder = new StringBuilder();
            if(!threeDay.isEmpty()){
                for(String bookName:threeDay){
                    stringBuilder.append("<strong>[");
                    stringBuilder.append(bookName);
                    stringBuilder.append("]</strong>、");
                }
                stringBuilder.replace(stringBuilder.length()-1,stringBuilder.length(),"");
                stringBuilder.append("还有三天到期");
            }

            if(!zeroDay.isEmpty()){
                stringBuilder.append("||");
                for(String bookName:zeroDay){
                    stringBuilder.append("<strong>[");
                    stringBuilder.append(bookName);
                    stringBuilder.append("]</strong>、");
                }
                stringBuilder.replace(stringBuilder.length()-1,stringBuilder.length(),"");
                stringBuilder.append("今天到期");
            }
            results.put(emailDbContent.getEmail(),stringBuilder.toString());

        }
        return results;
    }

    public static String emailDbToJSON(List<EmailDbContent> emailDbContents){
        Map<String,Map<String,String>> content = new HashMap<String, Map<String, String>>();
        Map<String,String> book = new HashMap<String, String>();
        for(EmailDbContent emailDbContent:emailDbContents){
            String bookContent = listToString(emailDbContent);
            book.put("books",bookContent);
            content.put(emailDbContent.getEmail(),book);
        }
        return JSON.toJSONString(content);
    }

    public static String listToString(EmailDbContent emailDbContent){
        List<String> threeDay = emailDbContent.getThreeDay();
        List<String> zeroDay = emailDbContent.getZeroDay();
        StringBuilder stringBuilder = new StringBuilder();
        if(!threeDay.isEmpty()){
            for(String bookName:threeDay){
                stringBuilder.append("<strong>[");
                stringBuilder.append(bookName);
                stringBuilder.append("]</strong>、");
            }
            stringBuilder.replace(stringBuilder.length()-1,stringBuilder.length(),"");
            stringBuilder.append("还有三天到期");
        }

        if(!zeroDay.isEmpty()){
            stringBuilder.append("||");
            for(String bookName:zeroDay){
                stringBuilder.append("<strong>[");
                stringBuilder.append(bookName);
                stringBuilder.append("]</strong>、");
            }
            stringBuilder.replace(stringBuilder.length()-1,stringBuilder.length(),"");
            stringBuilder.append("今天到期");
        }
        return stringBuilder.toString();
    }

    public static Map<String,String> bookToMap(List<Book> books){
        Map<String,String> result = new HashMap<String, String>();
        for(Book book:books){
            result.put(book.getName(),book.getRemainDay().toString());
        }
        return result;
    }
}
