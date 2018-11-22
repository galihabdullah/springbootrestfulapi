package com.sporthubid.repository.sort;

import com.sporthubid.models.sort.KomunitasModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KomunitasRepository extends JpaRepository<KomunitasModel, Long> {
    Page<KomunitasModel> findAll(Pageable pageable);
    Page<KomunitasModel> findByKotaContainingAndJenisolahragaContainingAndKelurahanContaining(String kota, String jenisolahraga, String kelurahan, Pageable pageable);
    Page<KomunitasModel> findByKotaContainingOrJenisolahragaContainingOrKelurahanContaining(String kota, String jenisolahraga, String kelurahan, Pageable pageable);
}
