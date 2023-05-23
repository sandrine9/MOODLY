package com.bnpp.epita.spring.infrastructure;

import com.bnpp.epita.spring.domaine.MoodEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMoodEntryRepository extends JpaRepository<MoodEntry,Long> {
}
