//package com.example.relations.domain.securityDomain;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//
//@Data
//@Entity
//@RequiredArgsConstructor
//@AllArgsConstructor
//@Builder
//@Table(name = "authorities")
//
//public class Authority implements GrantedAuthority {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String authority;
//}