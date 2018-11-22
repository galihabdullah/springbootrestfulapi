package com.sporthubid.repository.sort;

import com.sporthubid.models.sort.JenisOlahragaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JenisOlahrgaRepository extends JpaRepository<JenisOlahragaModel, Long> {
}
