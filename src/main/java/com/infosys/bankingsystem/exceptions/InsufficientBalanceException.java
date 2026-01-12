package com.infosys.bankingsystem.exceptions;

public class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String msg)
    {
        super(msg);
    }
}
