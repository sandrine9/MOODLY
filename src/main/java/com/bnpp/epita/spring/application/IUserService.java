package com.bnpp.epita.spring.application;

import com.bnpp.epita.spring.domaine.User;

public interface IUserService {

    public void createUser (User user);

    public User getUserById (Long id);
}
