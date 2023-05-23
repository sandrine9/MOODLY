package com.bnpp.epita.spring.application;

import com.bnpp.epita.spring.domaine.User;
import com.bnpp.epita.spring.infrastructure.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    IUserRepository repo;

    @Override
    public void createUser(User user) {
        repo.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> userOptional = repo.findById(id);
        if(userOptional.isEmpty()){
            return null;
        }
        return userOptional.get();
    }
}
