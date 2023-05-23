package com.bnpp.epita.spring.dto;

import com.bnpp.epita.spring.domaine.User;

import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class MoodEntryDto {
    private Long id;
    private UserDto userDto;
    private boolean mood;
    private String description;
    private LocalDate date;

    public MoodEntryDto(Long id, UserDto userDto, boolean mood, String description, LocalDate date) {
        this.id = id;
        this.userDto = userDto;
        this.mood = mood;
        this.description = description;
        this.date = date;
    }

    public MoodEntryDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public boolean isMood() {
        return mood;
    }

    public void setMood(boolean mood) {
        this.mood = mood;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
