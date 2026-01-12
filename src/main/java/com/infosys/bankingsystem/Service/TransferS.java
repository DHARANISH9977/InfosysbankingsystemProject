package com.infosys.bankingsystem.Service;

import com.infosys.bankingsystem.Entity.Account;
import com.infosys.bankingsystem.Entity.Tranfer;
import com.infosys.bankingsystem.Repository.AccountR;
import com.infosys.bankingsystem.Repository.TrasnferR;
import com.infosys.bankingsystem.exceptions.AccountNotFoundException;
import com.infosys.bankingsystem.exceptions.InsufficientBalanceException;
import com.infosys.bankingsystem.exceptions.InvalidAmountException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infosys.bankingsystem.helpher.CSVReportCreation;
import java.util.List;

@Service
public class TransferS {


    @Autowired
    TrasnferR tarns;

   @Autowired
    AccountR accr;

   Account acce;

   String check;

   // tis
    public void depositwithdraw(Tranfer tt,int accno) throws InvalidAmountException, AccountNotFoundException {

        Double balancesA = accr.getbalances(accno);
        double tranferamt=tt.getBalance();
        String dw=tt.getCheck();
        if(balancesA==null)
        {
            check="failed";
            CSVReportCreation .twoacount(accno,null,tranferamt,balancesA,dw,check);
            throw new AccountNotFoundException("Account was not found");
        }
        if ("deposit".equals(tt.getCheck())) {

            balancesA += tt.getBalance();
            accr.updateBalance(balancesA, accno);
            System.out.print("the accno" + balancesA);
            check="Completed";
            CSVReportCreation .twoacount(accno,null,tranferamt,balancesA,dw,check);
        }
        else if ("withdraw".equals(tt.getCheck())) {
            Double withdraw = accr.getbalances(accno);
            if(tt.getBalance()>withdraw)
            {
                throw new InvalidAmountException("amt was less than balance");
            }
            withdraw -= tt.getBalance();
            accr.updateBalance(withdraw, accno);
            System.out.println("the winthdraw" + withdraw);
            check="Completed";
            CSVReportCreation .twoacount(accno,null,tranferamt,balancesA,dw,check);
        }
        else
        {
            check="failed";
            CSVReportCreation .twoacount(accno,null,tranferamt,balancesA,dw,check);
        }
    }
    public Double checkbalance(int a1) throws AccountNotFoundException {

        if(String.valueOf(a1)==null)
        {
            throw new AccountNotFoundException("Account was not found");
        }
            return accr.checkbalance(a1);
    }
    @Transactional
    public void transfer(int a1,int a2,double amt) throws InsufficientBalanceException {
        //accr.transfer(a1,a2,amt);
        //List<Double>bal=accr.transfer(a1,a2,amt);
        double balacc1 = accr.getbalances(a1);
        double balacc2 = accr.getbalances(a2);
        if (balacc1 < amt) {
            check = "Uncomplete";
            CSVReportCreation .twoacount(a1,a2,amt,null,null,check);
            throw new InsufficientBalanceException("Cannot amount to be tranfer less then" + amt);
        } else {
            balacc1 -= amt;
            balacc2 += amt;
            check = "Complete";
            CSVReportCreation .twoacount(a1,a2,amt,balacc1,null,check);
            accr.updateBalance(balacc1, a1);
            accr.updateBalance(balacc2, a2);
        }
    }
}

