package com.bnpp.epita.spring.application;

import com.bnpp.epita.spring.domaine.Activity;

import java.util.List;

public interface IActivityService {

    public void createActivity (Activity activity);

    public Activity getActivityById(Long id);

    List<Activity> findActivitiesHappyByIdUser(Long id);
    List<Activity> findActivitiesSadByIdUser(Long id);
}
