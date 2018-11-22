package com.sporthubid.repository;

import com.sporthubid.models.DetailTempatModel;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DetailTempatRepository extends JpaRepository<DetailTempatModel, Long> {
    Optional<DetailTempatModel> findById(Long id);
}
