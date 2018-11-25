package com.sporthubid.repository.sort;

import com.sporthubid.models.sort.KelurahanModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KelurahanRepository extends JpaRepository<KelurahanModel, Long> {
    Page<KelurahanModel> findByIdkotaAndIdkecamatan(Long idkota, Long idkecamatan, Pageable pageable);
}
