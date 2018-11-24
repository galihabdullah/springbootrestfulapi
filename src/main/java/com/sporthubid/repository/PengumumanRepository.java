package com.sporthubid.repository;

import com.sporthubid.models.Pengumuman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PengumumanRepository extends JpaRepository<Pengumuman, Long> {

    @Query(value = "SELECT tp.* FROM tb_pengumuman tp WHERE tp.id_komunitas IN (:strikom) ORDER BY tp.id_pengumuman DESC " ,nativeQuery = true)
    List<Pengumuman> getById_komunitas(@Param("strikom") List<Integer> strikom);
}
