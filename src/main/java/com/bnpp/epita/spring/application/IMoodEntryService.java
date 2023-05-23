package com.bnpp.epita.spring.application;

import com.bnpp.epita.spring.domaine.Activity;
import com.bnpp.epita.spring.domaine.MoodEntry;

public interface IMoodEntryService {
    public void createMood (MoodEntry moodEntry);

    public MoodEntry getMoodById (Long id);
}
