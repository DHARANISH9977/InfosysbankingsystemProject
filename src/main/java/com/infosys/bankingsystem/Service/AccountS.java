package com.infosys.bankingsystem.Service;
import com.infosys.bankingsystem.Entity.Account;
import com.infosys.bankingsystem.Repository.AccountR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccountS {
    @Autowired
    AccountR accr;



    public List<Account> getall()
    {
        return accr.findAll();
    }

    public Account search(int id)
    {
        return accr.findById(id).orElse(null);
    }

    public Account addacc(Account a)
    {

       Account store= accr.save(a);
       long genrtaeaccno=65201000L+store.getAccid();
       store.setAccno(genrtaeaccno);
       return accr.save(store);

    }

    public String deleteacc(int id) {
        if (accr.existsById(id)) {
            accr.deleteById(id);
            return "the account was deleted";
        }
        return "the account was not deleted";
    }

    public  Double deposit(int accno)
    {
        return accr.getbalances(accno);
    }

}


