package com.example.relations.service.serviceImpl;

import com.example.relations.domain.User;
import com.example.relations.dto.Request.UserRequest;
import com.example.relations.dto.Response.UserResponse;
import com.example.relations.repository.UserRepository;
import com.example.relations.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<UserResponse> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse save(UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        User save = userRepository.save(user);
        return modelMapper.map(save, UserResponse.class);
    }

    @Override
    public UserResponse findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("User not found by id-%s", id)
        ));
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public UserResponse update(Long id, UserRequest userRequest) {
        userRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("User not found for updating by id -%s", id)));
        User responseUser = modelMapper.map(userRequest, User.class);
        responseUser.setUserId(id);
        return modelMapper.map(userRepository.save(responseUser), UserResponse.class);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("User not found by Id-%s", id)
        ));
        userRepository.delete(user);
    }

}
