package com.bnpp.epita.spring.exposition;

import com.bnpp.epita.spring.application.IUserService;
import com.bnpp.epita.spring.converter.UserConverter;
import com.bnpp.epita.spring.domaine.User;
import com.bnpp.epita.spring.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    IUserService service;
    @Autowired
    UserConverter converter;
    @PostMapping
    public void createUser(@RequestBody UserDto userDto){
        User user = converter.convertUserDtoToUserEntity(userDto);
        service.createUser(user);
    }

    @GetMapping("/{id}")
    public UserDto findUserById (@PathVariable("id") Long id){
        User user = service.getUserById(id);
        return converter.convertUserEntityToUserDto(user);
    }
}
