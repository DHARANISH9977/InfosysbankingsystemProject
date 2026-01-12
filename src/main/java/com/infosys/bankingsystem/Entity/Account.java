package com.infosys.bankingsystem.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Account {
@Id
@GeneratedValue
    int accid;
// link from customer
@Column(unique = true, nullable = false)
long accno;
    String accounttype;
    //@NotBlank
    String ifsccode="IOBA0000365";
    String bankname="TAMILNADU BANK";
    String bankaddress="TMB MAIN BRANCH ADAYAR CHENNAI ";
   @NotNull
    double balance;
    String status;


    public int getAccid() {
        return accid;
    }

    public void setAccid(int accid) {
        this.accid = accid;
    }
    public long getAccno() {
        return accno;
    }

    public void setAccno(long accno) {
        this.accno = accno;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public String getIfsccode() {
        return ifsccode;
    }

    public void setIfsccode(String ifsccode) {
        this.ifsccode = ifsccode;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBankaddress() {
        return bankaddress;
    }

    public void setBankaddress(String bankaddress) {
        this.bankaddress = bankaddress;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    //dummy email
    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @OneToOne()
    @JoinColumn(name = "customer_id")
    Customer cust;
}

