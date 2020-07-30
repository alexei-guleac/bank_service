package com.example.sample.service.implementations;

import com.example.sample.model.BankAccount;
import com.example.sample.repository.BankAccountRepository;
import com.example.sample.service.BankAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Bank account Service class for database repository
 * Contains method for
 * - getting all bank accounts by user id,
 */
@Service
@Slf4j
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;


    @Autowired
    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    /**
     * Get all bank accounts from database by user id
     *
     * @param userId - target user id
     * @return - bank accounts list
     */
    @Override
    public List<BankAccount> findByUserId(long userId) {
        log.debug("get bank accounts list executed...");
        return bankAccountRepository.findByUserId(userId);
    }
}
