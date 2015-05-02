package email;

import jodd.http.HttpRequest;
import jodd.mail.Email;
import jodd.mail.SendMailSession;
import jodd.mail.SmtpServer;

import java.util.HashMap;
import java.util.Map;

public class SendCloud {

    private String HTTP_URL ="http://sendcloud.sohu.com/webapi/mail.send.json";

    private String HTTP_API_USER ="YOUR_API_USER";

    private String HTTP_API_KEY = "YOUR_API_KEY";

    private String FROM = "YPUR_DOMAIN_EMAIL";

    private String SMTP_HOST = "smtpcloud.sohu.com";

    private String SMTP_USER="YOUR_USER";

    private String SMTP_PASS = "YOUR_PASS";

    public void sendBySMTP(String to, String subject, String text){
        SmtpServer smtpServer = SmtpServer.create(SMTP_HOST)
                .authenticateWith(SMTP_USER, SMTP_PASS);
        SendMailSession session = smtpServer.createSession();
        session.open();

        Email email = Email.create()
                .from(FROM)
                .to(to)
                .subject(subject)
                .addHtml(text);
        session.sendMail(email);
        session.close();
    }

    public void sendByHTTP(String to, String subject, String text){
        Map<String, Object> formData = new HashMap<String, Object>();
        formData.put("api_user", HTTP_API_USER);
        formData.put("api_key", HTTP_API_KEY);
        formData.put("from", FROM);
        formData.put("to", to);
        formData.put("subject", subject);
        formData.put("html", text);
        HttpRequest
                .post(HTTP_URL)
                .form(formData)
                .send();
    }
}

