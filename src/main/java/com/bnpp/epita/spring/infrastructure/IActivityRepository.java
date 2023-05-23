package com.bnpp.epita.spring.infrastructure;

import com.bnpp.epita.spring.domaine.Activity;
import com.bnpp.epita.spring.domaine.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActivityRepository extends JpaRepository<Activity, Long> {

    @Query("select a from Activity a JOIN FETCH a.moodEntry m WHERE a.user=:user AND m.mood= TRUE")
    List<Activity> findActivitiesHappyByIdUser(User user);

    @Query("select a from Activity a JOIN FETCH a.moodEntry m WHERE a.user=:user AND m.mood= FALSE")
    List<Activity> findActivitiesSadByIdUser(User user);
}
