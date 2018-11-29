package com.sporthubid.repository;

import com.sporthubid.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


@RestResource (exported = false)

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query(value = "SELECT tp.* FROM tb_post tp WHERE tp.id_komunitas= ?1 ORDER BY tp.id_post DESC", nativeQuery = true)
    List<Post> findById_komunitas(Integer id_komunitas);

    @Query(value = "SELECT tp.* FROM tb_post tp WHERE tp.id_komunitas IN (:strikom) ORDER BY tp.id_post DESC " ,nativeQuery = true)
    List<Post> getById_komunitas(@Param("strikom") List<Integer> strikom);

}
