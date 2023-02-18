package com.company.lms.backend.controllers.auth;

import javax.validation.Valid;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.lms.backend.controllers.auth.dtos.AuthResponse;
import com.company.lms.backend.controllers.auth.dtos.SignInRequest;
import com.company.lms.backend.controllers.auth.dtos.SignUpRequest;
import com.company.lms.backend.exceptions.AgeNotAllowedException;
import com.company.lms.backend.models.Account;
import com.company.lms.backend.security.JwtManager;
import com.company.lms.backend.services.accounts.CreateAccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final CreateAccountService createAccountService;

    private final AuthenticationManager authenticationManager;

    private final JwtManager jwtManager;

    @PostMapping("/sign-up")
    public AuthResponse signUp(@Valid @RequestBody SignUpRequest request) throws AgeNotAllowedException {
        Account account = createAccountService.create(request);
        String token = jwtManager.createToken(account);

        return AuthResponse.builder().accessToken(token).build();
    }

    @PostMapping("/sign-in")
    public AuthResponse signIn(@Valid @RequestBody SignInRequest request) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                request.getEmail(), request.getPassword());
        Authentication authenticated = authenticationManager.authenticate(authentication);
        Account account = (Account) authenticated.getPrincipal();
        String token = jwtManager.createToken(account);

        return AuthResponse.builder().accessToken(token).build();
    }

}
