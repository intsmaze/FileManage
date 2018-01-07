
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SMTPSimpleMail {

    public static void main(String[] args) throws AddressException, MessagingException {
        /* 必需的信息 */
//        String SMTP_MAIL_HOST = "smtp.163.com"; // 此邮件服务器地址，自行去所属邮件查询
//        String EMAIL_USERNAME = "15527692163@163.com";
//        String EMAIL_PASSWORD = "intsmaze586";
//        String TO_EMAIL_ADDRESS = "979222969@qq.com";
        
        //
        String SMTP_MAIL_HOST = "smtp.qq.com"; // 此邮件服务器地址，自行去所属邮件查询
        String EMAIL_USERNAME = "979222969@qq.com";
        String EMAIL_PASSWORD = "intsmaze4753586";
        String TO_EMAIL_ADDRESS = "760609405@qq.com";
        
        /* 服务器信息 */
        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_MAIL_HOST);
        props.put("mail.smtp.auth", "true");

        /* 创建Session */
        Session session = Session.getDefaultInstance(props, new SimpleAuthenticator(EMAIL_USERNAME, EMAIL_PASSWORD));

        /* 邮件信息 */
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(EMAIL_USERNAME));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(TO_EMAIL_ADDRESS));
        message.setSubject("how to use java mail to send email.(Title)(001)");
        message.setText("how to use java mail to send email.(Content)");

        // 发送
        Transport.send(message);
        System.out.println("不是特别倒霉，你可以去查收邮件了。");
    }

}