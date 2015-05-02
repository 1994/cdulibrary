package util;

import jodd.jerry.Jerry;

import java.io.IOException;
import java.util.Map;
import jodd.io.FileUtil;
import static jodd.jerry.Jerry.jerry;

/**
 * Created by reeco_000 on 2015/5/1.
 */
public class TemplateFactory {

    /**
     * 创建测试邮件
     * @param books
     */
    public static String createTest(Map<String,String> books){


        try {
            Jerry doc = jerry(FileUtil.readString(Thread.currentThread().getContextClassLoader().getResource("/templateTest").getFile()));
            for(Map.Entry<String,String> book:books.entrySet()){
                doc.$("#booksContent").append(createNode(book));
            }
            return doc.htmlAll(true);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("未找到文件");
        }

        return null;
    }

    public static String  createNode(Map.Entry<String,String> book){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<tr style=\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;\"><td style=\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; border-top-width: 1px; border-top-color: #eee; border-top-style: solid; margin: 0; padding: 5px 0;\" valign=\"top\">");
        stringBuilder.append(book.getKey());
        stringBuilder.append("</td>");
        stringBuilder.append("<td class=\"alignright\" style=\"font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; text-align: right; border-top-width: 1px; border-top-color: #eee; border-top-style: solid; margin: 0; padding: 5px 0;\" align=\"right\" valign=\"top\">");
        stringBuilder.append(book.getValue());
        stringBuilder.append("</td></tr>");
        return stringBuilder.toString();
    }

}

//<tr>
//<td>Thinking in Java</td>
//<td class="alignright">21</td>
//</tr>

//<tr style="font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; margin: 0;"><td style="font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; border-top-width: 1px; border-top-color: #eee; border-top-style: solid; margin: 0; padding: 5px 0;" valign="top">
//        Thinking inline
//</td>
//
//<td class="alignright" style="font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; box-sizing: border-box; font-size: 14px; vertical-align: top; text-align: right; border-top-width: 1px; border-top-color: #eee; border-top-style: solid; margin: 0; padding: 5px 0;" align="right" valign="top">14</td>
//</tr>