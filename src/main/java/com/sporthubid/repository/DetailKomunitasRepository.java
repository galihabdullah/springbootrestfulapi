package com.sporthubid.repository;

import com.sporthubid.models.DetailKomunitasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetailKomunitasRepository extends JpaRepository<DetailKomunitasModel, Long> {
    Optional<DetailKomunitasModel> findById(Long id);
    List<DetailKomunitasModel> findByIduser(Long iduser);

    @Query(value = "SELECT tp.* FROM tb_komunitas tp WHERE tp.id_komunitas IN (:strikom) ORDER BY tp.id_komunitas DESC " ,nativeQuery = true)
    List<DetailKomunitasModel> getById_komunitas(@Param("strikom") List<Integer> strikom);
}
