package com.bnpp.epita.spring.application;

import com.bnpp.epita.spring.domaine.Activity;
import com.bnpp.epita.spring.domaine.User;
import com.bnpp.epita.spring.infrastructure.IActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements IActivityService{

    @Autowired
    IActivityRepository repo;
    @Autowired
    IUserService userService;
    @Override
    public void createActivity(Activity activity) {
        repo.save(activity);
    }

    @Override
    public Activity getActivityById(Long id) {
        Optional<Activity> ativityOptional = repo.findById(id);
        if(ativityOptional.isEmpty()){
            return null;
        }
        return ativityOptional.get();
    }

    @Override
    public List<Activity> findActivitiesHappyByIdUser(Long id) {
        User user = userService.getUserById(id);
        return repo.findActivitiesHappyByIdUser(user);
    }

    @Override
    public List<Activity> findActivitiesSadByIdUser(Long id) {
        User user = userService.getUserById(id);
        return repo.findActivitiesSadByIdUser(user);
    }
}
