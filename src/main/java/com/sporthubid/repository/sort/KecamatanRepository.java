package com.sporthubid.repository.sort;


import com.sporthubid.models.sort.KecamatanModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KecamatanRepository extends JpaRepository<KecamatanModel, Long> {
    Page<KecamatanModel> findByIdkota(Long idkota, Pageable pageable);
}
