package me.dio.santander_dev_backend_2024.service.impl;

import me.dio.santander_dev_backend_2024.model.User;
import me.dio.santander_dev_backend_2024.repository.UserRepository;
import me.dio.santander_dev_backend_2024.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {


        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account Number already exists");
        }
        return userRepository.save(userToCreate);
    }
}
