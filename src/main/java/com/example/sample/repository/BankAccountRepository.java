package com.example.sample.repository;

import com.example.sample.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Bank account repository
 */
@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

    // не работает
    // @Query(value = "EXEC [dbo].[getBankAccountsByUserId] [UserId];", nativeQuery = true)
    // @Query(value = "EXEC [dbo].[getBankAccountsByUserId] :UserId];", nativeQuery = true)
    // @Query(value = "EXEC [dbo].[getBankAccountsByUserId] [:UserId];", nativeQuery = true)
    // @Query(value = "EXEC [dbo].[getBankAccountsByUserId] @UserId = :UserId;", nativeQuery = true)
    // @Procedure(procedureName = "BankAccount.getBankAccountsByUserId")

    // хардкод работает
    @Query(value = "EXEC [dbo].[getBankAccountsByUserId] 12345;", nativeQuery = true)
    List<BankAccount> findByUserId(@Param("UserId") Long id);
}
