package email;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by reeco_000 on 2015/4/26.
 */
@Component
public class EmailGun {

    private  String URL;

    private  String API_KEY;

    private  Map<String ,Object> queryMap;

//    private  String template = "您的以下几本图书：%recipient.books%,请尽快归还。——来自中国好同学的善意提醒";
    private  String template =
        "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\" \"http://www.w3.org/TR/REC-html40/loose.dtd\">\n" +
        "<!-- Inliner Build Version 4380b7741bb759d6cb997545f3add21ad48f010b --><html><body><table bgcolor=\"#efefef\" class=\"body-wrap\" style=\"font-size: 100%; font-family: 'Avenir Next', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; line-height: 1.65; width: 100% !important; height: 100%; -webkit-font-smoothing: antialiased; -webkit-text-size-adjust: none; background: #efefef; margin: 0; padding: 0;\"><tbody>\n" +
        "<tr style=\"font-size: 100%; font-family: 'Avenir Next', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; line-height: 1.65; margin: 0; padding: 0;\">\n" +
        "<td class=\"container\" style=\"font-size: 100%; font-family: 'Avenir Next', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; line-height: 1.65; display: block !important; clear: both !important; max-width: 580px !important; margin: 0 auto; padding: 0;\">\n" +
        "<!-- Message start -->\n" +
        "\t\t\t<table style=\"font-size: 100%; font-family: 'Avenir Next', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; line-height: 1.65; width: 100% !important; border-collapse: collapse; margin: 0; padding: 0;\"><tbody>\n" +
        "<tr style=\"font-size: 100%; font-family: 'Avenir Next', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; line-height: 1.65; margin: 0; padding: 0;\">\n" +
        "<td align=\"center\" bgcolor=\"#71bc37\" class=\"masthead\" style=\"font-size: 100%; font-family: 'Avenir Next', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; line-height: 1.65; color: white; background: #71bc37; margin: 0; padding: 80px 0;\">\n" +
        "\t\t\t\t\t\t<h1 style=\"font-size: 32px; font-family: 'Avenir Next', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; line-height: 1.25; max-width: 90%; text-transform: uppercase; margin: 0 auto; padding: 0;\">Note</h1>\n" +
        "\t\t\t\t\t\t</td>\n" +
        "\t\t\t\t\t</tr>\n" +
        "<tr style=\"font-size: 100%; font-family: 'Avenir Next', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; line-height: 1.65; margin: 0; padding: 0;\">\n" +
        "<td bgcolor=\"white\" class=\"content\" style=\"font-size: 100%; font-family: 'Avenir Next', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; line-height: 1.65; background: white; margin: 0; padding: 30px 35px;\">\n" +
        "\t\t\t\t\t\t<h2 style=\"font-size: 28px; font-family: 'Avenir Next', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; line-height: 1.25; margin: 0 0 20px; padding: 0;\">Hi &#20146;&#29233;&#30340;&#21516;&#23398;:</h2>\n" +
        "\n" +
        "\t\t\t\t\t\t<p style=\"font-size: 16px; font-family: 'Avenir Next', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; line-height: 1.65; font-weight: normal; margin: 0 0 20px; padding: 0;\">&#24744;&#30340;&#20197;&#19979;&#20960;&#26412;&#22270;&#20070;&#65306;%recipient.books%&#65292;&#35831;&#21450;&#26102;&#24402;&#36824;&#65281;</p>\n" +
        "\t\t\t\t\t\t</td>\n" +
        "\t\t\t\t\t</tr>\n" +
        "</tbody></table>\n" +
        "</td>\n" +
        "\t\t</tr>\n" +
        "<tr style=\"font-size: 100%; font-family: 'Avenir Next', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; line-height: 1.65; margin: 0; padding: 0;\">\n" +
        "<td class=\"container\" style=\"font-size: 100%; font-family: 'Avenir Next', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; line-height: 1.65; display: block !important; clear: both !important; max-width: 580px !important; margin: 0 auto; padding: 0;\">\n" +
        "<!-- Message start -->\n" +
        "\t\t\t<table style=\"font-size: 100%; font-family: 'Avenir Next', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; line-height: 1.65; width: 100% !important; border-collapse: collapse; margin: 0; padding: 0;\"><tbody><tr style=\"font-size: 100%; font-family: 'Avenir Next', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; line-height: 1.65; margin: 0; padding: 0;\">\n" +
        "<td align=\"center\" bgcolor=\"white\" class=\"content footer\" style=\"font-size: 100%; font-family: 'Avenir Next', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; line-height: 1.65; background: white none; margin: 0; padding: 30px 35px;\">\n" +
        "\t\t\t\t\t\t<p align=\"center\" style=\"font-size: 14px; font-family: 'Avenir Next', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; line-height: 1.65; font-weight: normal; color: #888; text-align: center; margin: 0; padding: 0;\"><a href=\"mailto:\" style=\"font-size: 100%; font-family: 'Avenir Next', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; line-height: 1.65; color: #888; text-decoration: none; font-weight: bold; margin: 0; padding: 0;\">contact@reeco.science</a> | <a href=\"http://reecoblog.info\" style=\"font-size: 100%; font-family: 'Avenir Next', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; line-height: 1.65; color: #888; text-decoration: none; font-weight: bold; margin: 0; padding: 0;\">My Blog</a></p>\n" +
        "\t\t\t\t\t\t</td>\n" +
        "\t\t\t\t\t</tr></tbody></table>\n" +
        "</td>\n" +
        "\t\t</tr>\n" +
        "</tbody></table></body></html>\n";


    @Value("${mailgun_URL}")
    public void setURL(String URL) {
        this.URL = URL;
    }

    @Value("${mailgun_API_KEY}")
    public void setAPI_KEY(String API_KEY) {
        this.API_KEY = API_KEY;
    }

    @Resource(name = "mailgun_formData")
    public void setQueryMap(Map<String, Object> queryMap) {
        this.queryMap = queryMap;
    }

    /**
     * 批量发送
     * @param JSONOContent
     * @param mailists
     */
    public void batchSendByHTTP(String JSONOContent,List<String> mailists){
       // System.out.println(JSONOContent);
        queryMap.put("html",template);
        queryMap.put("recipient-variables", JSONOContent);
        for(String mail:mailists){
            queryMap.put(new String("to"), mail);
        }
        HttpResponse response = HttpRequest
                .post(URL)
                .basicAuthentication("api",API_KEY)
                .form(queryMap)
                .send();
        System.out.println(response);
    }

    public void sendByHTTP(String to,String content){
        queryMap.put("to",to);
        queryMap.put("html",content);
        HttpResponse response = HttpRequest
                .post(URL)
                .basicAuthentication("api",API_KEY)
                .form(queryMap)
                .send();
        System.out.println(response);
    }
}
