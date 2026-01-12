package com.infosys.bankingsystem.exceptions;

public class AccountNotFoundException extends Exception{
    public AccountNotFoundException(String msg)
    {
        super(msg);
    }
}
