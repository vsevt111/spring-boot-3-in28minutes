package com.in28minutes.spring.security.learnspringsecurity.jwt;

import java.time.Instant;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class JwtAuthentication {
	
	private JwtEncoder jwtEncoder;
	
	
	
	public JwtAuthentication(JwtEncoder jwtEncoder) {
		this.jwtEncoder = jwtEncoder;
	}

	@PostMapping("/authenticate")
	public JwtResponse authenticate(Authentication authentication) {
		return new JwtResponse(createToken(authentication));
	}

	private String createToken(Authentication authentication) {
		// TODO Auto-generated method stub
		var jwtClaim = JwtClaimsSet.builder()
								.issuer("myself")
								.issuedAt(Instant.now())
								.expiresAt(Instant.now().plusSeconds(60*30))
								.subject(authentication.getName())
								.claim("scope", createScope(authentication))
								.build();
		return jwtEncoder.encode(JwtEncoderParameters.from(jwtClaim)).getTokenValue();
	}

	private Object createScope(Authentication authentication) {
		// TODO Auto-generated method stub
		return authentication
				.getAuthorities().stream()
				.map(a-> a.getAuthority())
				.collect(Collectors.joining(" "));
	}
	
	
}

record JwtResponse(String Token) {}
