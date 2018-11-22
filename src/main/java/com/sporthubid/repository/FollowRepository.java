package com.sporthubid.repository;

import com.sporthubid.models.FollowKomunitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;


@RestResource (exported = false)
public interface FollowRepository extends JpaRepository<FollowKomunitas, Integer> {
}
