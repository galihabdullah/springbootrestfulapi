package com.sporthubid.repository;

import com.sporthubid.models.MemberJoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MjRepository extends JpaRepository<MemberJoin, Long> {

    @Query(value = "SELECT mj.* from tb_member_join mj where mj.id_user = ?1", nativeQuery = true)
    List<MemberJoin> getById_user(Integer id_user);
}
