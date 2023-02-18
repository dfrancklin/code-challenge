package com.company.lms.backend.security;

import org.springframework.security.core.context.SecurityContextHolder;

import com.company.lms.backend.models.Account;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthenticationHelper {

    public static Account getAccount() {
        return (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
