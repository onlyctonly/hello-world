package com.bashfan.javamaildemo;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class JavaMailSendTest {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.setProperty("mail.debug", "true");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.host", "smtp.exmail.qq.com");
        properties.setProperty("mail.transport.protocol", "smtp");

        Session session = Session.getDefaultInstance(properties);

        Message message = new MimeMessage(session);
        try {
            message.setSubject("this is from java");
            message.setText("from xiangyu");
            message.setFrom(new InternetAddress("info@cgw.gr"));
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        Transport transport = session.getTransport();
        transport.connect("info@cgw.gr","password");
        transport.sendMessage(message,new Address[] {new InternetAddress("onlyctonly@gmail.com")});
        transport.close();
    }
}
