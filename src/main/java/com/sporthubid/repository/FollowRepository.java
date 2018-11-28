package com.sporthubid.repository;

import com.sporthubid.controllers.FollowController;
import com.sporthubid.models.FollowKomunitas;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;


@RestResource (exported = false)
public interface FollowRepository extends JpaRepository<FollowKomunitas, Integer> {
    List<FollowKomunitas> findByIdkomunitas(Integer idkomunitas);
    Integer countByIdkomunitas(Integer idkomunitas);
    List<FollowKomunitas> findByIduser(Integer iduser);
    @Transactional
    Boolean deleteByIduserAndIdkomunitas(Integer iduser, Integer idkomunitas);
    @Transactional
    Integer removeByIduserAndIdkomunitas(Integer iduser, Integer idkomunitas);
    boolean existsByIdkomunitasAndIduser(Integer idkomunitas, Integer iduser);


}
