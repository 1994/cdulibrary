package entity;


import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by reeco_000 on 2015/4/29.
 */
public class SendCloudTemplate {

    private List<String> to = new ArrayList<String>();

    private Map<String,List<String>> sub = new HashMap<String, List<String>>();

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public Map<String, List<String>> getSub() {
        return sub;
    }

    public void setSub(Map<String, List<String>> sub) {
        this.sub = sub;
    }

    public static void main(String[] args) {
        SendCloudTemplate sendCloudTemplate = new SendCloudTemplate();
        sendCloudTemplate.getTo().add("123@qq.com");
        sendCloudTemplate.getTo().add("234@qq.com");
        List<String> content1 = new ArrayList<String>();
        content1.add("ben");
        content1.add("joe");

        List<String> content2 = new ArrayList<String>();
        content2.add("123");
        content2.add("654");
        sendCloudTemplate.getSub().put("%name%", content1);
        sendCloudTemplate.getSub().put("%money%",content2);

        System.out.println(JSON.toJSON(sendCloudTemplate).toString());
    }
}
