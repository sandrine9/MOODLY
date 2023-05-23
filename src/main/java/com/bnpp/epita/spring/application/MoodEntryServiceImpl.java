package com.bnpp.epita.spring.application;

import com.bnpp.epita.spring.domaine.Activity;
import com.bnpp.epita.spring.domaine.MoodEntry;
import com.bnpp.epita.spring.infrastructure.IMoodEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MoodEntryServiceImpl implements IMoodEntryService{

    @Autowired
    IMoodEntryRepository repo;
    @Override
    public void createMood(MoodEntry moodEntry) {
        repo.save(moodEntry);
    }

    @Override
    public MoodEntry getMoodById(Long id) {
        Optional<MoodEntry> moodOptional = repo.findById(id);
        if(moodOptional.isEmpty()){
            return null;
        }
        return moodOptional.get();
    }
}
