//package com.example.relations.config;
//
//import io.jsonwebtoken.JwtBuilder;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Component;
//
//import java.security.Key;
//import java.time.Duration;
//import java.time.Instant;
//import java.util.Date;
//import java.util.Map;
//import java.util.Set;
//
//@Slf4j
//@Component
//@RequiredArgsConstructor
//public class JwtService {
//    private final Set<ClaimProvider> claimProvider;
//    private final Set<ClaimSetProvider> claimSetProviders;
//    private final SecurityProperties securityProperties;
//    private Key key;
//
//    public Claim parseToken(String token) {
//        return (Claim) Jwts.parser();
//    }
//
//
//    public String issueToken(Authentication authentication, Duration duration) {
//        log.info("Issue JWt token for to {} for {}", authentication.getPrincipal(), duration);
//        final JwtBuilder jwtBuilder = Jwts.builder()
//                .setSubject(authentication.getName())
//                .setIssuedAt(new Date())
//                .setExpiration(Date.from(Instant.now().plus
//                        (Duration.ofSeconds(securityProperties.getJwtProperties().getTokenValidityInSeconds()))))
//                .setHeader(Map.of("type","JWT"))
//                .signWith(SignatureAlgorithm.HS512,key);
//        addClaims(jwtBuilder,authentication);
//        addClaimSet(jwtBuilder,authentication);
//        return jwtBuilder.compact();
//
//    }
//
//    private JwtBuilder addClaims(JwtBuilder jwtBuilder,Authentication authentication){
//        claimProvider.forEach(claimsProvider ->{
//            Claim claim = claimsProvider.provide(authentication);
//            log.info("Adding claim {}",claim);
//            jwtBuilder.claim(claim.getKey(),claim.getClaim());
//        });
//        return  jwtBuilder;
//    }
//
//    private JwtBuilder addClaimSet(JwtBuilder jwtBuilder,Authentication authentication){
//        claimSetProviders.forEach(claimsProvider ->{
//            ClaimSet claimSet = claimsProvider.provide(authentication);
//            log.info("Adding claim {}",claimSet);
//            jwtBuilder.claim(claimSet.getKey(),claimSet.getClaim());
//        });
//        return  jwtBuilder;
//    }
//
//
//}