package task;

import com.alibaba.fastjson.JSON;
import email.EmailGun;
import email.EmailSendCloud;
import entity.SendCloudTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import service.MaiListService;
import util.MapUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by reeco_000 on 2015/4/25.
 */

@Component
public class EmailEveryDay {

    private MaiListService maiListService;

    private EmailSendCloud emailSendCloud;

    private EmailGun emailGun;

    @Autowired
    public void setMaiListService(MaiListService maiListService) {
        this.maiListService = maiListService;
    }

    @Autowired
    public void setEmailSendCloud(EmailSendCloud emailSendCloud) {
        this.emailSendCloud = emailSendCloud;
    }

    @Autowired
    public void setEmailGun(EmailGun emailGun) {
        this.emailGun = emailGun;
    }

    public void emailThree(){
        Map<String,Map<String,String>> threeMap = maiListService.getThree();
        Map<String,String> content = MapUtil.mapToContent(threeMap);
        for (Map.Entry<String, String> entry : content.entrySet()) {
            emailSendCloud.send(entry.getKey(),entry.getValue());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 使用mailgun批量发送
     */
    public void batchSendByMailGun(){
        Map<String,Map<String,String>> threeMap = maiListService.getThree();
        List<String> mailists = maiListService.getMaiListThree();
        String JSONContent = MapUtil.mapToJSON(threeMap);
        emailGun.batchSendByHTTP(JSONContent,mailists);
    }

    public void batchSendByCloud(){
        Map<String,Map<String,String>> threeMap = maiListService.getThree();
        Map<String,String> mailContent = MapUtil.mapToContent(threeMap);
        List<String> listContent = new ArrayList<String>();
        SendCloudTemplate sendCloudTemplate = new SendCloudTemplate();
        for (Map.Entry<String, String> entry : mailContent.entrySet()) {
            sendCloudTemplate.getTo().add(entry.getKey());
            listContent.add(entry.getValue());
        }
        sendCloudTemplate.getSub().put("%books%", listContent);
        String templateJSON = JSON.toJSONString(sendCloudTemplate).toString();
        emailSendCloud.batchSend(templateJSON);
    }

    @Scheduled(cron = "0 0 8 * * *")
    public void batchSendByCloud2(){
        System.out.println("开始定时发邮件1");
        Map<String,String> results = MapUtil.emailDbToMap(maiListService.getContent(0));
        SendCloudTemplate sendCloudTemplate = new SendCloudTemplate();
        List<String> listContent = new ArrayList<String>();
        for(Map.Entry<String, String> entry:results.entrySet()){
            sendCloudTemplate.getTo().add(entry.getKey());
            listContent.add(entry.getValue());
        }
        sendCloudTemplate.getSub().put("%books%", listContent);
        emailSendCloud.batchSend(JSON.toJSONString(sendCloudTemplate).toString());
    }

    @Scheduled(cron = "0 0 8 * * *")
    public void batchSendByMailGun2(){
        System.out.println("开始定时发邮件2");
        List<String> mailists = maiListService.getMail(1);
        String JSONContent = MapUtil.emailDbToJSON(maiListService.getContent(1));
        emailGun.batchSendByHTTP(JSONContent,mailists);
    }
}
