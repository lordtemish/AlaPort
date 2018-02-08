package com.dynamica.alaport;

import java.util.Properties;

/*import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;*/

public class MailController {
  /*  String login;
    String pass;
    public MailController(){
        login="lordtemich@gmail.com";
        pass="sukaloida";
    }
    public String sendMessage(String to, String sub,String txt){
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(login, pass);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(login));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(sub);
            message.setText(txt);

            Transport.send(message);

            return "Sent";
        } catch (MessagingException e) {
            return e.getMessage();
        }
    }*/
}
