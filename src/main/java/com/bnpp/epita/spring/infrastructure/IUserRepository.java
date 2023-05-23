package com.bnpp.epita.spring.infrastructure;

import com.bnpp.epita.spring.domaine.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
}
