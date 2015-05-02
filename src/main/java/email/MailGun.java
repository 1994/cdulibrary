package email;

import jodd.http.HttpRequest;
import jodd.mail.Email;
import jodd.mail.SendMailSession;
import jodd.mail.SmtpServer;

import java.util.HashMap;
import java.util.Map;


public class MailGun {

    private String SMTP_HOST = "smtp.mailgun.org";

    private String SMTP_USER="YOUR_USER";

    private String SMTP_PASS = "YOUR_PASSWORD";

    private String HTTP_URL="https://api.mailgun.net/v3/YOUR_DOMAIN/messages";

    private String HTTP_API="YOUR_API";


    /**
     * 使用SMTP触发发送
     * @param from 发件人
     * @param to 收件人
     * @param subject 主题
     * @param text 内容
     */
    public void sendBySMTP(String from,String to,String subject,String text){
        SmtpServer smtpServer = SmtpServer.create(SMTP_HOST)
                .authenticateWith(SMTP_USER, SMTP_PASS);
        SendMailSession session = smtpServer.createSession();
        session.open();

        Email email = Email.create()
                .from(from)
                .to(to)
                .subject(subject)
                .addHtml(text);
        session.sendMail(email);
        session.close();
    }

    /**
     * 使用HTTP方式发送
     * @param from 发件人
     * @param to 收件人
     * @param subject 主题
     * @param text 内容
     */
    public void sendByHTTP(String from,String to,String subject,String text){
        Map<String, Object> formData = new HashMap<String, Object>();
        formData.put("from", from);
        formData.put("to", to);
        formData.put("subject", subject);
        formData.put("text", text);
        HttpRequest
                .post(HTTP_URL)
                .basicAuthentication("api",HTTP_API)
                .form(formData).send();
    }
}
