package com.example.sample.service;

import com.example.sample.model.BankAccount;

import java.util.List;


public interface BankAccountService {

    List<BankAccount> findByUserId(long userId);

}
