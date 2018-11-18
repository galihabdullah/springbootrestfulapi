package com.sporthubid.repository;

import com.sporthubid.models.DetailTempatModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailTempatRepository extends JpaRepository<DetailTempatModel, Long> {
    Page<DetailTempatModel> findById(Long id, Pageable pageable);
}