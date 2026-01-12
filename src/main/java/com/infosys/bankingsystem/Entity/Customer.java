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
    //link with account no
    @Column(unique = true)
    @Size(min=8,max=10)
    int phoneno;
    String address;
    @Size(min=5,max=6)
    int pincode;
    int createdat;
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

    public int getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(int phoneno) {
        this.phoneno = phoneno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getCreatedat() {
        return createdat;
    }

    public void setCreatedat(int createdat) {
        this.createdat = createdat;
    }

    @OneToOne(mappedBy = "cust")
    private Account acc;


}

