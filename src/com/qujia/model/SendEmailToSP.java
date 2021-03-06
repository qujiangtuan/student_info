package com.qujia.model;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailToSP {
          private static String id;
          private static String pwd;
          private static String toEmail;
          
          public SendEmailToSP(String id,String pwd, String toEmail) throws Exception {
                    super();
                    this.id = id;
                    this.pwd=pwd;
                    this.toEmail = toEmail;
                    //163.com
//                    String account="qujiangtuan@163.com";
//                    String password="qjt6317800";
//                    MimeMessage m=createEmail(account,password);
//                    Session session=m.getSession();
////                    session.setDebug(true);
//                    Properties config=session.getProperties();
//                    config.put("mail.transport.protocol", "smtp");
//                    config.put("mail.smtp.host", "smtp.163.com");
//                    //config.put("mail.smtp.port", "25");
//                    config.put("mail.smtp.auth", "true");
//                    config.put("mail.smtp.ssl.enable", "true");
                    
                    //gmail
                    String account="qujiangtuan741@gmail.com";
                    String password="qjt/40421777/";
                    MimeMessage m=createEmail(account,password);
                    Session session=m.getSession();
//                    session.setDebug(true);
                    Properties config=session.getProperties();
                    config.put("mail.transport.protocol", "smtp");
                    config.put("mail.smtp.host", "smtp.gmail.com");
                    //config.put("mail.smtp.port", "25");
                    config.put("mail.smtp.auth", "true");
                    config.put("mail.smtp.ssl.enable", "true");
                    
                    Transport.send(m);
          }
    public static MimeMessage createEmail(final String account,final String password)throws Exception {
        Properties config=new Properties();
        Session session=Session.getInstance(config,new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(account, password);
            }
        });
        //1 创建邮件对象
        MimeMessage m=new MimeMessage(session);
        //2 设置发件人
        Address from=new InternetAddress(account,"pknu","utf-8");
        m.setFrom(from);
        //3 设置收件人
        m.setRecipient(RecipientType.TO,new InternetAddress(toEmail));
        //4 设置超送人
        //m.setRecipient(RecipientType.CC,new InternetAddress(toEmail));
        //5 设置密送人
        //m.setRecipient(RecipientType.BCC,new InternetAddress("toEmail));
        //6 邮件的主题
        m.setSubject("Welcome to Pukyong University","utf-8");
        //7 邮件正文
        StringBuilder html=new StringBuilder();
        html.append("<html>");
        html.append("<body>");
//        html.append("<img src='https://www.baidu.com/img/bd_logo1.png'>");
        html.append("<strong>");
        html.append("<h1> Welcome to Pukyong University !  </h1>");
        html.append("<h1>");
        html.append("Your ID is  <font color='blue'>"+id+"</font> and Password is <font color='blue'>"+pwd+"</font>.");
        html.append("</h1>");
        html.append("</strong>");
        html.append("</body>");
        html.append("</html>");
        m.setContent(html.toString(), "text/html;charset=utf-8");
        //8 发送时间
        m.setSentDate(new Date());
        //9确认设置完毕
        m.saveChanges();
        return m;
    }

}
