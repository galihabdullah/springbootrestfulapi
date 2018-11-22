package com.sporthubid.repository;

import com.sporthubid.models.DetailKomunitasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetailKomunitasRepository extends JpaRepository<DetailKomunitasModel, Long> {
    Optional<DetailKomunitasModel> findById(Long id);
}
