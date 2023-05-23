package com.bnpp.epita.spring.converter;

import com.bnpp.epita.spring.domaine.User;
import com.bnpp.epita.spring.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User convertUserDtoToUserEntity (UserDto userDto){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(userDto, User.class);
    }

    public UserDto convertUserEntityToUserDto (User user) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(user,UserDto.class);
    }

}
