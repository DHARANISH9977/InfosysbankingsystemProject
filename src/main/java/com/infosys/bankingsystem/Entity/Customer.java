package com.infosys.bankingsystem.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
//import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    int cusid;
   @NotBlank
    String name;
    String dob;
    @Email
    String email;
    @Column(unique = true)
    @Size(min=8,max=10)
    String phoneno;
    String address;
    @Size(min=5,max=6)
    String pincode;
    int createdat;

   // public long getAccno() {
     //   return accno;
    //}

    //public void setAccno(long accno) {
      //  this.accno = accno;
   // }

    public int getCusid() {
        return cusid;
    }

    public void setCusid(int cusid) {
        this.cusid = cusid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public int getCreatedat() {
        return createdat;
    }

    public void setCreatedat(int createdat) {
        this.createdat = createdat;
    }

    // JOIN FROM CUSTOMER TO ACCOUNT MAPPING
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="accid",referencedColumnName = "accid",nullable = false)
    public Account acc;

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }
}

