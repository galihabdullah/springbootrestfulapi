package com.sporthubid.repository;

import com.sporthubid.models.UserEdit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserEditRepository extends JpaRepository<UserEdit, Long> {

    @Modifying
    @Query(value = "UPDATE tb_user tu SET tu.minat_or = :minat where tu.id_user = :id_user", nativeQuery = true)
    void setMinatOlahraga(@Param("minat") String minat, @Param("id_user") Long id_user);

    Optional<UserEdit> findByEmail(String email);
}
