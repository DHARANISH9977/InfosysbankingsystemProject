package com.infosys.bankingsystem.helpher;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
@Component
public class otpgenerator {

    SecureRandom sr=new SecureRandom();

    public int otpsend() {
        int otp = sr.nextInt(9000)+1000;  //RANDOM NO IN BETWWEN 9000 AND ADD THE 1000 WITH IT
        System.out.print(otp);
        return otp;
    }



}
