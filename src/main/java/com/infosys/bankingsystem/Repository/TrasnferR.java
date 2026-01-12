package com.infosys.bankingsystem.Repository;

import com.infosys.bankingsystem.Entity.Tranfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrasnferR extends JpaRepository<Tranfer,Integer> {

}
