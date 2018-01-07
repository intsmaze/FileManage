package cn.intsmaze.core.util;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class SMTPSimpleMail {

   static String SMTP_MAIL_HOST = "smtp.qq.com"; // 此邮件服务器地址，自行去所属邮件查询
   static String EMAIL_USERNAME = "979222969@qq.com";
   static String EMAIL_PASSWORD = "intsmaze4753586";
   static HttpServletRequest request= ServletActionContext.getRequest();
  
   static  String path =request.getContextPath();
   static  String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
   
	public static void sendEmail(String email) throws AddressException, MessagingException
	{
		
		  /* 服务器信息 */
        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_MAIL_HOST);
        props.put("mail.smtp.auth", "true");
        /* 创建Session */
        Session session = Session.getDefaultInstance(props, new SimpleAuthenticator(EMAIL_USERNAME, EMAIL_PASSWORD));

        /* 邮件信息 */
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(EMAIL_USERNAME));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        
        message.setSubject("账号激活");
        message.setText("点击激活"+basePath+"useremail/useremail_useAccount.action?email="+email);
        // 发送
        Transport.send(message);
	}
	
	
	public static void sendEmailModify(String password, String email) throws AddressException, MessagingException
	{
		
		  /* 服务器信息 */
        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_MAIL_HOST);
        props.put("mail.smtp.auth", "true");
        /* 创建Session */
        Session session = Session.getDefaultInstance(props, new SimpleAuthenticator(EMAIL_USERNAME, EMAIL_PASSWORD));

        /* 邮件信息 */
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(EMAIL_USERNAME));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        
        message.setSubject("密码验证");
        message.setText("点击验证"+basePath+"useremail/useremail_useEmail.action?password="+password+"&email="+email);
        // 发送
        Transport.send(message);
	}
	public static void main(String[] args) throws IOException, AddressException, MessagingException {
		SMTPSimpleMail.sendEmail("760609405@qq.com");
	}

}