package com.infosys.bankingsystem.Service;

import com.infosys.bankingsystem.Entity.Customer;
import com.infosys.bankingsystem.Repository.AccountR;
import com.infosys.bankingsystem.Repository.CustomerR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infosys.bankingsystem.Entity.Account;
@Service
public class CustomerS {

    @Autowired
    CustomerR cusr;

    //findbyemail, findby accno used from account repo (i)
    @Autowired
    AccountR accr;



    public Customer showdetails(int id)
    {
        return cusr.getById(id);
    }

    public String adddetails(Customer cus)

    {
        long accno=cus.getAcc().getAccno();
        String accemail= accr.findbyemail(accno);  //(i)

        Account acc=accr.findByAccno(accno); //(i)
        if (accemail== null) {
            return "Account not found";
        }
         if(!accemail.equals(cus.getEmail()))
         {
              return "Email not matches with account";
         }
         cus.setAcc(acc);
         cusr.save(cus);
         return "suceess";

    }
    public String deletedetails(int id)
    {
        if(cusr.existsById(id)) {
            cusr.deleteById(id);
            return "The Details for the " + id + " was deleted";
        }
        return "The id "+ id+"was not exists";

    }
}
