package com.example.relations.service;

import com.example.relations.dto.Request.UserRequest;
import com.example.relations.dto.Response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> findAll();

    UserResponse save(UserRequest userRequest);

    UserResponse findById(Long id);

    UserResponse update(Long id, UserRequest userRequest);

    void delete(Long id);
}
