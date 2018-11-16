package com.sportshubid.sportshubid.repository;

import com.sportshubid.sportshubid.models.SortAndFilterTempatModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SortAndFilterTempatRepository extends JpaRepository<SortAndFilterTempatModel, Long> {
    Page<SortAndFilterTempatModel> findByLokasiContaining(String lokasi, Pageable pageable);
    Page<SortAndFilterTempatModel> findByJenisOlahragaContaining(String jenisolahraga, Pageable pageable);
    Page<SortAndFilterTempatModel> findByLokasiContainingAndJenisOlahragaContaining(String lokasi, String jenisOlahraga, Pageable pageable);
    Page<SortAndFilterTempatModel> findByLokasiContainingOrJenisOlahragaContaining(String lokasi, String jenisOlahraa, Pageable pageable);

}
