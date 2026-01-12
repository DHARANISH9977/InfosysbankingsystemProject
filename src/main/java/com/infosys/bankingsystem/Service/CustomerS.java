package com.infosys.bankingsystem.Service;

import com.infosys.bankingsystem.Entity.Customer;
import com.infosys.bankingsystem.Repository.CustomerR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerS {

    @Autowired
    CustomerR cusr;
    public Customer showdetails(int id)
    {
        return cusr.getById(id);
    }

    public Customer adddetails(Customer cus)
    {
        return cusr.save(cus);
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
