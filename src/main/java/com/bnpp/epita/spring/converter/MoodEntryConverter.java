package com.bnpp.epita.spring.converter;

import com.bnpp.epita.spring.domaine.MoodEntry;
import com.bnpp.epita.spring.domaine.User;
import com.bnpp.epita.spring.dto.MoodEntryDto;
import com.bnpp.epita.spring.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MoodEntryConverter {
    @Autowired
    UserConverter userConverter;
    public MoodEntry convertMoodEntryDtoToMoodEntryEntity (MoodEntryDto moodEntryDto){
        ModelMapper mapper = new ModelMapper();
        MoodEntry moodEntry = mapper.map(moodEntryDto, MoodEntry.class);
        moodEntry.setUser(userConverter.convertUserDtoToUserEntity(moodEntryDto.getUserDto()));
        return moodEntry;
    }

    public MoodEntryDto convertMoodEntryEntityToMoodEntryDto (MoodEntry moodEntry) {
        ModelMapper mapper = new ModelMapper();
        MoodEntryDto moodEntryDto = mapper.map(moodEntry,MoodEntryDto.class);
        moodEntryDto.setUserDto(userConverter.convertUserEntityToUserDto(moodEntry.getUser()));
        return moodEntryDto;
    }
}
