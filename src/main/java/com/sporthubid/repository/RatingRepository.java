package com.sporthubid.repository;

import com.sporthubid.models.sort.RatingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<RatingModel, Long> {
    List<RatingModel> findByIdtempat(Long id);
    @Query("SELECT AVG (rating) from RatingModel where idtempat=:idtempat")
    Integer getAverageRating(@Param("idtempat") Long idtempat);
    boolean existsByIduserAndIdtempat(Long iduser, Long idtempat);
}
