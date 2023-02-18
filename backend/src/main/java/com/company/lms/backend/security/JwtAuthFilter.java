package com.company.lms.backend.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.micrometer.core.instrument.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

	private final JwtManager jwtUtils;

	private final UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String headerValue = request.getHeader(HttpHeaders.AUTHORIZATION);

		if (StringUtils.isBlank(headerValue)) {
			filterChain.doFilter(request, response);

			return;
		}

		String path = request.getRequestURI();

		try {
			if (!headerValue.startsWith("Bearer ")) {
				throw new AuthenticationCredentialsNotFoundException("Authorization Header not found");
			}

			String[] tokenParts = headerValue.split(" ");

			if (tokenParts.length != 2) {
				throw new InsufficientAuthenticationException("Malformed Authorization Header");
			}

			String accessToken = tokenParts[1];

			if (!jwtUtils.isValid(accessToken)) {
				throw new BadCredentialsException("Invalid Authorization Header");
			}

			String username = jwtUtils.getEmail(accessToken);
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);

			if (!userDetails.isEnabled()) {
				throw new DisabledException("User is disabled");
			}

			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
					null,
					userDetails.getAuthorities());
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authentication);

			filterChain.doFilter(request, response);
		} catch (Exception e) {
			log.error(
					"[doInternalFilter] An error occurred while trying to validate authorization at path \"{}\". Error: {}.",
					path, e.getMessage(), e);
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
		}
	}

}
