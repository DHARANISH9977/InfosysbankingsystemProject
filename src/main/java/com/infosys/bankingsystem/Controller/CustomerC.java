package com.infosys.bankingsystem.Controller;

import com.infosys.bankingsystem.Entity.Customer;
import com.infosys.bankingsystem.Service.CustomerS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/customer")
public class CustomerC {

    @Autowired
    CustomerS cusS;
    @GetMapping("/all")
    public List<Customer> getall()
    {
        return cusS.getall();
    }
    @GetMapping("/detailc/{id}")
    public Customer showdetails(@PathVariable int id)
    {
        return cusS.showdetails(id);
    }
    @PostMapping("/addc")
    public String add(@RequestBody Customer add)
    {
        return cusS.adddetails(add);
    }
    @DeleteMapping("/deletec/{id}")
    public String  delete(@PathVariable int id)
    {
        return cusS.deletedetails(id);
    }
}
