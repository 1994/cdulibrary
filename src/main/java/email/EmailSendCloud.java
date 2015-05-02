package email;


import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by reeco_000 on 2015/4/20.
 */
@Component
public class EmailSendCloud {

    private  String URL;

    private  String template_URL;

    private  Map<String ,Object> queryMap = new HashMap<String, Object>();

    @Value("${sendcloud_URL}")
    public void setURL(String URL) {
        this.URL = URL;
    }

    @Value("${sendcloud_TEMPLATE}")
    public void setTemplate_URL(String template_URL) {
        this.template_URL = template_URL;
    }

    @Resource(name = "sendcloud_formData")
    public void setQueryMap(Map<String, Object> queryMap) {
        this.queryMap = queryMap;
    }

    public  void send(String to_email,String content){
        System.out.println(content);
        queryMap.put("to",to_email);
        queryMap.put("html",content);
        HttpResponse response = HttpRequest
                .post(URL)
                .form(queryMap)
                .send();
        System.out.println(response);
    }

    public  void batchSend(String JSONObject){

        queryMap.put("template_invoke_name","book");
        queryMap.put("substitution_vars",JSONObject);

        System.out.println(queryMap);
        System.out.println(template_URL);
        HttpResponse response = HttpRequest
                .post(template_URL)
                .form(queryMap)
                .send();
        System.out.println(response);
    }

}
