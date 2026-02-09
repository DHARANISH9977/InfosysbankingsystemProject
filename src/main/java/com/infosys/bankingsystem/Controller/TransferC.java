package com.infosys.bankingsystem.Controller;

import com.infosys.bankingsystem.Entity.Tranfer;
import com.infosys.bankingsystem.Entity.Account;
import com.infosys.bankingsystem.Service.TransferS;
import com.infosys.bankingsystem.exceptions.AccountNotFoundException;
import com.infosys.bankingsystem.exceptions.InsufficientBalanceException;
import com.infosys.bankingsystem.exceptions.InvalidAmountException;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/transfer")
public class TransferC {

    @Autowired
    TransferS trans;
    @PostMapping("/depositwithdraw/{accno}")
    public ResponseEntity<?> depositwithdraw(
            @RequestBody Tranfer t,
            @PathVariable int accno) {

        try {
            trans.depositwithdraw(t, accno);
            return ResponseEntity.ok("Transaction Successful");
        }
        catch (AccountNotFoundException | InvalidAmountException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Server error: " + e.getMessage());
        }
    }
    @GetMapping("/checkbalance/{a1}")
    public Double checkbalance(@PathVariable int a1) throws AccountNotFoundException {
        return trans.checkbalance(a1);
    }
    //tranferonetoone
    @GetMapping("/transfer/{a1}/{a2}/{amt}")
    public ResponseEntity<?> transfer(@PathVariable int a1,@PathVariable int a2,@PathVariable double amt) throws InsufficientBalanceException {
        try {
            trans.transfer(a1, a2, amt);
            return ResponseEntity.ok("Transfer Succcessful");
        }
        catch(InsufficientBalanceException r)
        {
            return ResponseEntity.badRequest().body(r.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Server error" + e.getMessage());
        }

    }
}