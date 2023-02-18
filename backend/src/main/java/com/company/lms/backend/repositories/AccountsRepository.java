package com.company.lms.backend.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.company.lms.backend.models.Account;

public interface AccountsRepository extends CrudRepository<Account, Long> {

    Optional<Account> findByEmail(String email);

}
