package com.infosys.bankingsystem.Service;
import com.infosys.bankingsystem.Repository.AccountR;
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
    @Autowired
    AccountR accr;
    // FROM THE LOW BALANCE ALERT
    public void balancelow(String emailto,double balance) throws MessagingException {
        MimeMessage message=msend.createMimeMessage();
        MimeMessageHelper helpher=new MimeMessageHelper(message,true);

        helpher.setFrom("dharanishvijaykumar181@gmail.com");
        helpher.setTo(emailto);
        helpher.setSubject("The bank balance was less than 10000");
        helpher.setText("The bank balance was less than 1000"+"the current balnce was"+balance);
        msend.send(message);
        System.out.println("the email was send to "+emailto);
    }
    // FOR DEPOSIT AND WITHDRAW EMAIL
    public void transferamt(String check,double amt,int accno,double bal) throws MessagingException {

        String emailto= accr.findbyemail(accno);
        MimeMessage message=msend.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(message,true);
        helper.setFrom("dharanishvijaykumar181@gmail.com");
        helper.setTo(emailto);
        helper.setSubject("Banking application email");
        helper.setText("From the account "+accno+ "amount of $" +amt +"was "+check+ "current balance was "+bal);
        msend.send(message);
        System.out.print("From the account "+accno+ "amount of $" +amt +"was "+check+ "current balance was "+bal);

    }
    //FOR LOGIN OTP EMAIL
    public void otpsend(String emailto,int otp) throws MessagingException {
        MimeMessage msg=msend.createMimeMessage();
        MimeMessageHelper hel=new MimeMessageHelper(msg,true);

        hel.setFrom("dharanishvijaykumar181@gmail.com");
        hel.setTo(emailto);
        hel.setText("the banking otp to login"+ otp);
        hel.setSubject("otp");
        msend.send(msg);
        System.out.print("otp send"+otp);
    }


}
