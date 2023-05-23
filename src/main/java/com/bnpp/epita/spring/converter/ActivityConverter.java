package com.bnpp.epita.spring.converter;

import com.bnpp.epita.spring.domaine.Activity;
import com.bnpp.epita.spring.domaine.MoodEntry;
import com.bnpp.epita.spring.domaine.User;
import com.bnpp.epita.spring.dto.ActivityDto;
import com.bnpp.epita.spring.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActivityConverter {
    @Autowired
    UserConverter userConverter;
    @Autowired
    MoodEntryConverter moodConverter;
    public Activity convertActivityDtoToActivityEntity (ActivityDto activityDto){
        ModelMapper mapper = new ModelMapper();
        Activity activity = mapper.map(activityDto, Activity.class);
        activity.setUser(userConverter.convertUserDtoToUserEntity(activityDto.getUserDto()));
        activity.setMoodEntry(moodConverter.convertMoodEntryDtoToMoodEntryEntity(activityDto.getMoodEntryDto()));
        return activity;
    }

    public ActivityDto convertActivityEntityToActivityDto (Activity activity) {
        ModelMapper mapper = new ModelMapper();
        ActivityDto activityDto = mapper.map(activity,ActivityDto.class);
        activityDto.setUserDto(userConverter.convertUserEntityToUserDto(activity.getUser()));
        activityDto.setMoodEntryDto(moodConverter.convertMoodEntryEntityToMoodEntryDto(activity.getMoodEntry()));
        return activityDto;
    }
}
