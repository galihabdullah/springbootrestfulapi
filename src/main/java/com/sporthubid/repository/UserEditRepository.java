package com.sporthubid.repository;

import com.sporthubid.models.UserEdit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEditRepository extends JpaRepository<UserEdit, Long> {
}
