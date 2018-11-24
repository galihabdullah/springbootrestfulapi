package com.sporthubid.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_member_join")
@EntityListeners(AuditingEntityListener.class)
public class MemberJoin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_mj;

    @Column
    private Integer id_user;

    @Column
    private Integer id_komunitas;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date tgl_join;

    public Long getId_mj() {
        return id_mj;
    }

    public void setId_mj(Long id_mj) {
        this.id_mj = id_mj;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Integer getId_komunitas() {
        return id_komunitas;
    }

    public void setId_komunitas(Integer id_komunitas) {
        this.id_komunitas = id_komunitas;
    }

    public Date getTgl_join() {
        return tgl_join;
    }

    public void setTgl_join(Date tgl_join) {
        this.tgl_join = tgl_join;
    }
}
