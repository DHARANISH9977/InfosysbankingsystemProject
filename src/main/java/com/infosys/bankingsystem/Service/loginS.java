package com.infosys.bankingsystem.Service;
import com.infosys.bankingsystem.Repository.AccountR;
import com.infosys.bankingsystem.helpher.otpgenerator;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginS {

    @Autowired
    AccountR accr;

    @Autowired
    otpgenerator otpg;

    @Autowired
    AlertGmailS ags;

    private static final long OTP_EXPIRY_TIME = 60 * 10000;
    int generatedOtp=0;
    long otpGeneratedTime=0;
    public String login(String gmail,int otp) throws MessagingException {
        if(accr.findemailforotp(gmail)==false) {
            return "Invalid account email";

        }
// ask if it send gmail and otp was zero from server so otp was zero
        if(otp==0) {
            generatedOtp = otpg.otpsend();
            otpGeneratedTime = System.currentTimeMillis();
            ags.otpsend(gmail, generatedOtp);
            return "otp send to gmail";
        }
        long currentTime = System.currentTimeMillis();
        if (currentTime - otpGeneratedTime > OTP_EXPIRY_TIME) {
            generatedOtp = 0;
            return "OTP expired. Please request a new OTP";
        }
           if(generatedOtp==otp) {
               generatedOtp = 0; //reset it
               return "Sucessfully login";
           }

        return "Invalid otp";
    }

}
