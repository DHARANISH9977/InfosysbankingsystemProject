package com.infosys.bankingsystem.Controller;

import com.infosys.bankingsystem.Entity.Tranfer;
import com.infosys.bankingsystem.Entity.Account;
import com.infosys.bankingsystem.Service.TransferS;
import com.infosys.bankingsystem.exceptions.AccountNotFoundException;
import com.infosys.bankingsystem.exceptions.InsufficientBalanceException;
import com.infosys.bankingsystem.exceptions.InvalidAmountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/transfer")
public class TransferC {

    @Autowired
    TransferS trans;

    @PostMapping("/depositwithdraw/{accno}")

    public void depositwithdraw(@RequestBody Tranfer t, @PathVariable int accno) throws InvalidAmountException, AccountNotFoundException {
        trans.depositwithdraw(t, accno);
    }
    @GetMapping("/checkbalance/{a1}")
    public Double checkbalance(@PathVariable int a1) throws AccountNotFoundException {
        return trans.checkbalance(a1);
    }
    //tranferonetoone
    @GetMapping("/transfer/{a1}/{a2}/{amt}")
    public void transfer(@PathVariable int a1,@PathVariable int a2,@PathVariable double amt) throws InsufficientBalanceException {
        trans.transfer(a1,a2,amt);

    }
}