package com.example.sample.repository;

import com.example.sample.model.BankAccount;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.List;


/**
 * Bank account repository
 */
@Repository
public class BankAccountRepository {

    private final EntityManager em;

    public BankAccountRepository(EntityManager em) {
        this.em = em;
    }

    /**
     * Get all bank accounts from database by user id by stored procedure call
     *
     * @param userId - target user id
     * @return - bank accounts list
     */
    public List<BankAccount> findByUserId(Long userId) {
        StoredProcedureQuery sp = em.createStoredProcedureQuery("getBankAccountsByUserId", BankAccount.class);
        sp.registerStoredProcedureParameter("UserId", Long.class, ParameterMode.IN);
        sp.setParameter("UserId", userId);

        boolean result = sp.execute();
        if (result) {
            return sp.getResultList();
        } else {
            // Handle the false for no result set returned, e.g.
            throw new RuntimeException("No result set(s) returned from the stored procedure");
        }
    }
}
