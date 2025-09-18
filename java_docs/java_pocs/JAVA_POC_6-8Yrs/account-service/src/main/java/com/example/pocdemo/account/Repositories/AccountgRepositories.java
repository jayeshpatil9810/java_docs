package com.example.pocdemo.account.Repositories;

import com.example.pocdemo.account.Entity.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountgRepositories extends JpaRepository<AccountDetails, Long> {
    Optional<AccountDetails> findByBankAccNo(String bankAccNo);

    Optional<AccountDetails> findByEmpId(Long empId);
}
