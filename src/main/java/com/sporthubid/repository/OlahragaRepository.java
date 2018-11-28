package com.sporthubid.repository;

import com.sporthubid.models.sort.JenisOlahragaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OlahragaRepository extends JpaRepository <JenisOlahragaModel, Long> {

    @Query(value = "SELECT tp.* FROM mt_jenisolahraga tp WHERE tp.id_jenis IN (:id_or)" ,nativeQuery = true)
    List<JenisOlahragaModel> getById_komunitas(@Param("id_or") String[] id_or);
}
