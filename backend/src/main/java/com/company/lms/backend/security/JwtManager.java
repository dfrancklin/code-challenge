package com.company.lms.backend.security;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.company.lms.backend.models.Account;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Component
@ConfigurationProperties("jwt")
@Data
@Slf4j
public class JwtManager {

	private static final SignatureAlgorithm ALGORITHM = SignatureAlgorithm.HS512;

	private String secretKey;

	private String issuer;

	private Duration duration;

	private List<String> allowedPaths;

	public String createToken(Account account) {
		return Jwts.builder()
				.claim("role", account.getRole())
				.setSubject(account.getEmail())
				.setIssuer(issuer)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + duration.toMillis()))
				.signWith(ALGORITHM, getEncryptedKey())
				.compact();
	}

	public boolean isValid(String token) {
		try {
			Jwts.parser().setSigningKey(getEncryptedKey()).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			log.error("An error occurred while trying to validate JWT Token. Error: {}", e.getMessage(), e);
		}

		return false;
	}

	public String getEmail(String token) {
		return Jwts.parser().setSigningKey(getEncryptedKey()).parseClaimsJws(token).getBody().getSubject();
	}

	private SecretKeySpec getEncryptedKey() {
		return new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), ALGORITHM.getJcaName());
	}

}
