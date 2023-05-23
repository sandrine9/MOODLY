package com.bnpp.epita.spring.domaine;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne                    //pas de cascade, fetch eager ok
    private User user;
    private String name;
    private Integer duration;  // en minutes
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;   //date et heure
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private MoodEntry moodEntry;

    public Activity(User user, String name, Integer duration, LocalDate date, MoodEntry moodEntry) {
        this.user = user;
        this.name = name;
        this.duration = duration;
        this.date = date;
        this.moodEntry = moodEntry;
    }

    public Activity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public MoodEntry getMoodEntry() {
        return moodEntry;
    }

    public void setMoodEntry(MoodEntry moodEntry) {
        this.moodEntry = moodEntry;
    }
}
