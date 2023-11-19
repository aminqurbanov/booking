//package com.example.relations.config;
//
//import com.example.relations.domain.UserRole;
//import lombok.RequiredArgsConstructor;
//import lombok.SneakyThrows;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
//
//import java.util.List;
//
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(
//        prePostEnabled = true,
//        securedEnabled = true,
//        jsr250Enabled =true
//)
//@RequiredArgsConstructor
//
//public class SecurityConfig implements ApplicationSecurityConfig {
//
//
//    @Override
//    @SneakyThrows
//    public void configure(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry
//                                  requestMatcherRegistry){
//        configurePublicOperation(requestMatcherRegistry);
//        configureUserOperation(requestMatcherRegistry);
//        configureStuffOperation(requestMatcherRegistry);
//        configureAdminOperation(requestMatcherRegistry);
//    }
//
//    @SneakyThrows
//    private void configurePublicOperation(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry
//                                                  http){
//        http.
//                requestMatchers(HttpMethod.GET,"/booking/v1").permitAll();
//    }
//
//    @SneakyThrows
//    private void configureUserOperation(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry
//                                                http){
//        http.
//                requestMatchers(HttpMethod.GET,"/booking/v1/{id}").authenticated();
//    }
//    @SneakyThrows
//    private void configureStuffOperation(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry
//                                                     http) {
//        http.
//                requestMatchers(HttpMethod.DELETE, "/booking/v1/{id}").permitAll();
//    }
//        @SneakyThrows
//        private void configureAdminOperation(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry
//        http) {
//            http.
//                    requestMatchers(HttpMethod.POST, "/booking/v1/payments/{paymentId}/users/{userId}").permitAll();
//        }
//    private String admin(){
//        return UserRole.ROLE_ADMIN.name();
//    }
//
//    private String[] adminOrStuff(){
//        return List.of(UserRole.ROLE_ADMIN.name(),UserRole.ROLE_STAFF.name()).toArray(new String[0]);
//    }
//
//    private String[] adminOrUser(){
//        return List.of(UserRole.ROLE_ADMIN.name(), UserRole.ROLE_USER.name()).toArray(new String[0]);
//    }
//
//}