package com.infosys.bankingsystem.Controller;

import com.infosys.bankingsystem.Entity.Account;
import com.infosys.bankingsystem.Service.AccountS;
import com.infosys.bankingsystem.Service.AlertGmailS;
import com.infosys.bankingsystem.helpher.utilforalert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/Account")
public class AccountC {

    @Autowired
    AccountS aservice;
    @Autowired
    AlertGmailS ags;
    @Autowired
    utilforalert ufa;

    @GetMapping("/get/{id}")
    public Account search(@PathVariable int id)
    {
        return aservice.search(id);
    }
    @GetMapping("/all")
    public List<Account> getall()
    {
        return aservice.getall();
    }
    @PostMapping("/addacc")
    public Account add(@RequestBody  Account a)
    {
        return aservice.addacc(a);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id)
    {
        return aservice.deleteacc(id);
    }
    // low balnces alert email
    @GetMapping("/lowbalance")
    public List<Account> getLowBalanceAccounts() {
        return ufa.findLowBalance();
    }

    // use to get an csv  for view account statment
    @GetMapping("/csv")
    public String csv() throws IOException {
        Path p= Path.of("BankReport.csv");
        return Files.readString(p);
    }



}
