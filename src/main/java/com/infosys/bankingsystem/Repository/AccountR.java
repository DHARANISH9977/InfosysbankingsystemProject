package com.infosys.bankingsystem.Repository;
import com.infosys.bankingsystem.Entity.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountR extends JpaRepository<Account,Integer> {

    //email
    @Query(nativeQuery = true,
    value="select email,balance,accno from account where balance <1000")
    List<Object[]> balancelow();


    @Query(value = "SELECT balance FROM account WHERE accno = :accno",nativeQuery = true)
    Double getbalances(@Param("accno")int accno);

    @Modifying
    @Transactional
    @Query(value="UPDATE account SET balance = :bal WHERE accno = :accno", nativeQuery = true)
    void updateBalance(@Param("bal") double bal, @Param("accno") int accno);

    @Query(nativeQuery = true,value = "SELECT balance FROM account WHERE accno = :a1" )
    Double checkbalance(@Param("a1") int a1);

   // @Query(nativeQuery = true,value="select balance from account where accno in(:a1,:a2) and :dummy=:dummy")
    //List<Double>transfer(@Param("a1") int a1,@Param("a2") int a2,@Param("dummy") double dummy);





}
