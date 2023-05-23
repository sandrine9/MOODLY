package com.bnpp.epita.spring.exposition;

import com.bnpp.epita.spring.application.IActivityService;
import com.bnpp.epita.spring.application.IUserService;
import com.bnpp.epita.spring.converter.ActivityConverter;
import com.bnpp.epita.spring.converter.UserConverter;
import com.bnpp.epita.spring.domaine.Activity;
import com.bnpp.epita.spring.domaine.MessageFileMoodly;
import com.bnpp.epita.spring.domaine.MoodEntry;
import com.bnpp.epita.spring.domaine.User;
import com.bnpp.epita.spring.dto.ActivityDto;
import com.bnpp.epita.spring.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/activities")
public class ActivityController {

    @Autowired
    IActivityService service;
    @Autowired
    ActivityConverter converter;
    @PostMapping
    public void createActivity(@RequestBody ActivityDto activityDto){
        Activity activity = converter.convertActivityDtoToActivityEntity(activityDto);
        service.createActivity(activity);
    }

    @GetMapping("/{id}")
    public ActivityDto findActivityById (@PathVariable("id") Long id){
        Activity activity = service.getActivityById(id);
        return converter.convertActivityEntityToActivityDto(activity);

        //envoi d'un message dans file MQ si creation mood ok en même temps que activity et mood false
        //MoodEntry moodEntry = activity.getMoodEntry();
        /* à finir
        if(!moodEntryDto.isMood()){

            jmsTemplate.send("EXN_HBE_moodly", new MessageFileMoodly(moodEntry.getUser()));
        }*/
    }

    @GetMapping("/{id}/happy-activities")
    public List<ActivityDto> findActivitiesHappyByIdUser (@PathVariable("id") Long id){
        List<Activity> activities = service.findActivitiesHappyByIdUser(id);
        List<ActivityDto> activitiesDto = activities.stream()
                .map(activity -> converter.convertActivityEntityToActivityDto(activity))
                .collect(Collectors.toList());
        return activitiesDto;
    }
    @GetMapping("/{id}/sad-activities")
    public List<ActivityDto> findActivitiesSadByIdUser (@PathVariable("id") Long id){
        List<Activity> activities = service.findActivitiesSadByIdUser(id);
        List<ActivityDto> activitiesDto = activities.stream()
                .map(activity -> converter.convertActivityEntityToActivityDto(activity))
                .collect(Collectors.toList());
        return activitiesDto;
    }
}
