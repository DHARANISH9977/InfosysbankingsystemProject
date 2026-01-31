package com.infosys.bankingsystem.Controller;

import com.infosys.bankingsystem.Service.loginS;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class loginC {

    @Autowired
    loginS ls;

    @PostMapping("/login")
    public String login(@RequestParam String gmail,@RequestParam int otp) throws MessagingException {
        return ls.login(gmail,otp);
    }
}
