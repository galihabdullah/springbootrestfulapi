package com.sporthubid.repository;

import com.sporthubid.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);
    List<User> findByEmail(String email);
    List<User> findByUsernameAndPassword(String username, String password);
    Optional<User> findByEmailAndResettoken(String email, String resettoken);
}
