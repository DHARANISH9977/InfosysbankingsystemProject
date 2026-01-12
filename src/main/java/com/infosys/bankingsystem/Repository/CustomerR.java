package com.infosys.bankingsystem.Repository;

import com.infosys.bankingsystem.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerR extends JpaRepository<Customer,Integer> {
}
