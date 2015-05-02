package service;

import dao.MailDAO;
import entity.EmailDbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by reeco_000 on 2015/4/26.
 */
@Service
public class MaiListService {
    /**
     * 邮件列表
     */

    private MailDAO mailDAO;

    @Autowired
    public void setMailDAO(MailDAO mailDAO) {
        this.mailDAO = mailDAO;
    }

    public Map<String,Map<String,String>> getThree(){
        List<String> mails = mailDAO.getAllMail(1);
        Map<String,Map<String,String>> result = new HashMap<String, Map<String, String>>();
        for(String email:mails){
            result.put(email,mailDAO.getContent(1,email));
        }
        return result;
    }

    public Map<String,Map<String,String>> getZero(){
        List<String> mails = mailDAO.getAllMail(0);
        Map<String,Map<String,String>> result = new HashMap<String, Map<String, String>>();
        for(String email:mails){
            result.put(email,mailDAO.getContent(0,email));
        }
        return result;
    }

    public List<String> getMaiListThree(){
        return mailDAO.getAllMail(1);
    }


    //从这里开始为新加的方法
    public List<String> getMail(Integer type){
        return mailDAO.getMailist(type);
    }

    public List<EmailDbContent> getContent(Integer type){
        List<EmailDbContent> results = new ArrayList<EmailDbContent>();
        List<String> mails = mailDAO.getMailist(type);
        for(String mail:mails){
           results.add(mailDAO.getMail(type,mail));
        }
        return results;
    }
}
