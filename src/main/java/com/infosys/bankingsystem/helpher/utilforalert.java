package com.infosys.bankingsystem.helpher;
import com.infosys.bankingsystem.Entity.Account;
import com.infosys.bankingsystem.Repository.AccountR;
import java.util.ArrayList;
import java.util.List;

import com.infosys.bankingsystem.Service.AlertGmailS;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class utilforalert {

    @Autowired
  AccountR accr;
    @Autowired
    AlertGmailS ags;

    List<String> sent=new ArrayList<>();
    @Scheduled(fixedRate =  9*60*1000)
    void check() throws MessagingException {

        List<Object[]>emailslist=accr.balancelow();
       for(Object[]all:emailslist) {
           String gmail = all[0].toString();
           double balance = Double.parseDouble(all[1].toString());
           System.out.println("gmail" + gmail + "" + balance);
           ags.balancelow(gmail, balance);

       }
    }
    public List<Account> findLowBalance() {
        List<Object[]> list = accr.balancelow();
        List<Account> result = new ArrayList<>();

        for (Object[] row : list) {
            Account a = new Account();
            a.setEmail(row[0].toString());
            a.setBalance(Double.parseDouble(row[1].toString()));
            a.setAccno(Long.parseLong(row[2].toString()));
            result.add(a);
        }

        return result;
    }

}
