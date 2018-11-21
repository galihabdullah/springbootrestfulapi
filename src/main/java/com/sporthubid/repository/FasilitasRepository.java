package com.sporthubid.repository;

import com.sporthubid.models.FasilitasModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FasilitasRepository extends JpaRepository<FasilitasModel, Long> {
    Page<FasilitasModel> findByKotaContainingAndJenisolahragaContainingAndKelurahanContaining(String kota, String jenisolahraga, String keluraha, Pageable pageable);
    Page<FasilitasModel> findByKotaContainingOrJenisolahragaContainingOrKelurahanContaining(String kota, String jenisolahraga, String keluraha, Pageable pageable);
}
