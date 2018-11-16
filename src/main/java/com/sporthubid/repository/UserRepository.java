package com.sporthubid.repository;

import com.sporthubid.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.rest.core.annotation.RestResource;


import java.util.List;

@Repository
@RestResource(exported = false) //
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);
    List<User> findByEmail(String email);
    List<User> findByUsernameAndPassword(String username, String password);
}
