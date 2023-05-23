package com.bnpp.epita.spring.exposition;

import com.bnpp.epita.spring.application.IMoodEntryService;
import com.bnpp.epita.spring.application.IUserService;
import com.bnpp.epita.spring.converter.MoodEntryConverter;
import com.bnpp.epita.spring.converter.UserConverter;
import com.bnpp.epita.spring.domaine.MessageFileMoodly;
import com.bnpp.epita.spring.domaine.MoodEntry;
import com.bnpp.epita.spring.domaine.User;
import com.bnpp.epita.spring.dto.MoodEntryDto;
import com.bnpp.epita.spring.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/moods")
public class MoodController {
    @Autowired
    IMoodEntryService service;
    @Autowired
    MoodEntryConverter converter;

    @Autowired
    JmsTemplate jmsTemplate;

    @PostMapping
    public void createMood(@RequestBody MoodEntryDto moodEntryDto){
        MoodEntry moodEntry = converter.convertMoodEntryDtoToMoodEntryEntity(moodEntryDto);
        service.createMood(moodEntry);

        //envoi d'un message dans file MQ si creation mood ok et mood false
        if(!moodEntryDto.isMood()){
            jmsTemplate.send("EXN_HBE_moodly", new MessageFileMoodly(moodEntry.getUser()));
        }


    }

    @GetMapping("/{id}")
    public MoodEntryDto findMoodById (@PathVariable("id") Long id){
        MoodEntry moodEntry = service.getMoodById(id);
        return converter.convertMoodEntryEntityToMoodEntryDto(moodEntry);
    }
}
