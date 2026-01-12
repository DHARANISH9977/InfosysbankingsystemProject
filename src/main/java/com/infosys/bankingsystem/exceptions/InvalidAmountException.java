package com.infosys.bankingsystem.exceptions;

import jakarta.persistence.criteria.CriteriaBuilder;

public class InvalidAmountException  extends Exception{

    public InvalidAmountException(String msg)
    {
        super(msg);
    }
}
