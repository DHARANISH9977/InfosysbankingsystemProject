package com.infosys.bankingsystem.Service;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class AlertGmailS {

    @Autowired
    JavaMailSender msend;
    MimeMailMessage mmm;

    public void balancelow(String emailto,double balance) throws MessagingException {
        MimeMessage message=msend.createMimeMessage();
        MimeMessageHelper helpher=new MimeMessageHelper(message,true);

        helpher.setFrom("dharanishvijayakumar181@gmail.com");
        helpher.setTo(emailto);
        helpher.setSubject("The bank balance was less than 10000");
        helpher.setText("The bank balance was less than 1000"+"the current balnce was"+balance);
        msend.send(message);
        System.out.println("the email was send to "+emailto);
    }

}
