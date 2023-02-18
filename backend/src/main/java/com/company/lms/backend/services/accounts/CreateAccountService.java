package com.company.lms.backend.services.accounts;

import java.time.LocalDate;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.company.lms.backend.controllers.auth.dtos.SignUpRequest;
import com.company.lms.backend.exceptions.AgeNotAllowedException;
import com.company.lms.backend.models.Account;
import com.company.lms.backend.repositories.AccountsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateAccountService {

    private final AccountsRepository repository;

    private final PasswordEncoder passwordEncoder;

    public Account create(SignUpRequest request) throws AgeNotAllowedException {
        LocalDate ageLimit = LocalDate.now().minusYears(16);

        if (ageLimit.isBefore(request.getBirthDate())) {
            throw new AgeNotAllowedException();
        }

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        Account account = Account.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .birthDate(request.getBirthDate())
                .address(request.getAddress())
                .city(request.getCity())
                .state(request.getState())
                .zipCode(request.getZipCode())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .password(encodedPassword)
                .build();

        return repository.save(account);
    }
}
