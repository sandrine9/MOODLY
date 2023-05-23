package com.bnpp.epita.spring.dto;

import com.bnpp.epita.spring.domaine.MoodEntry;
import com.bnpp.epita.spring.domaine.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class ActivityDto {
    private Long id;
    private UserDto userDto;
    private String name;
    private Integer duration;  // en minutes
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private MoodEntryDto moodEntryDto;

    public ActivityDto(Long id, UserDto userDto, String name, Integer duration, LocalDate date, MoodEntryDto moodEntryDto) {
        this.id = id;
        this.userDto = userDto;
        this.name = name;
        this.duration = duration;
        this.date = date;
        this.moodEntryDto = moodEntryDto;
    }

    public ActivityDto() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public MoodEntryDto getMoodEntryDto() {
        return moodEntryDto;
    }

    public void setMoodEntryDto(MoodEntryDto moodEntryDto) {
        this.moodEntryDto = moodEntryDto;
    }
}
