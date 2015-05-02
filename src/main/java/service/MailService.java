package service;

import email.EmailGun;
import email.EmailSendCloud;
import entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.MapUtil;
import util.TemplateFactory;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by reeco_000 on 2015/5/1.
 */
@Service
public class MailService {

    private EmailGun emailGun;

    private EmailSendCloud emailSendCloud;

    @Autowired
    public void setEmailGun(EmailGun emailGun) {
        this.emailGun = emailGun;
    }

    @Autowired
    public void setEmailSendCloud(EmailSendCloud emailSendCloud) {
        this.emailSendCloud = emailSendCloud;
    }

    public void sendTestMailByGun(List<Book> books, String email){
        String mailContent = TemplateFactory.createTest(MapUtil.bookToMap(books));
        emailGun.sendByHTTP(email,mailContent);
    }

    public void sendTestMailBySendCloud(List<Book> books, String email){
        String mailContent = TemplateFactory.createTest(MapUtil.bookToMap(books));
        emailSendCloud.send(email,mailContent);
    }

    public void sendTestMail(List<Book> books, String email){
        if(checkEmail(email)){
            sendTestMailBySendCloud(books,email);
        }else{
            sendTestMailByGun(books,email);
        }
    }

    /**
     * 检查是否是QQ邮箱
     * @return 是返回true
     */
    public Boolean checkEmail(String email){
        String regexO = "^[A-Za-z0-9_-]+@qq\\.com$";
        String regexT = "^[A-Za-z0-9_-]+@vip.qq\\.com$";
        return  Pattern.compile(regexO).matcher(email).matches()||Pattern.compile(regexT).matcher(email).matches();
    }

}
