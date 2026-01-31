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

    //use in customerS class for getting account no
    Account findByAccno(long accno);

    //email
    //This to use in (util for alert class) low balance alert for email)
    @Query(nativeQuery = true,
    value="select email,balance,accno from account where balance <1000")
    List<Object[]> balancelow();

    //this query was used in ({customerS class}) to add customer details verify by gmail
    @Query(nativeQuery = true,value = "select email from account where accno = ?1")
    String findbyemail(@Param("accno") long accno);

    //This was for the {(otp genrator class) to find the email in account db exists or not})

    @Query("select case when count(a) > 0 then true else false end from Account a where a.email = :email")
    Boolean findemailforotp(@Param("email") String email);


    //updates balance(transfer service{withdraw,deposit,one to one})
    @Modifying
    @Transactional
    @Query(value="UPDATE account SET balance = :bal WHERE accno = :accno", nativeQuery = true)
    void updateBalance(@Param("bal") double bal, @Param("accno") int accno);

// check balances query in tranfer
    @Query(nativeQuery = true,value = "SELECT balance FROM account WHERE accno = :accno" )
    Double checkbalance(@Param("accno") int accno);

   // @Query(nativeQuery = true,value="select balance from account where accno in(:a1,:a2) and :dummy=:dummy")
    //List<Double>transfer(@Param("a1") int a1,@Param("a2") int a2,@Param("dummy") double dummy);

   // @Query(value = "SELECT balance FROM account WHERE accno = :accno",nativeQuery = true)
    //Double getbalances(@Param("accno")int accno);




}
