package com.sporthubid.repository;

import com.sporthubid.models.V_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VUserRepository extends JpaRepository<V_User, Long> {
        List<V_User> findByUsernameAndPassword(String username, String password);
}
