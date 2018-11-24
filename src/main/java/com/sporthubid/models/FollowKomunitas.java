package com.sporthubid.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_follow")
@EntityListeners(AuditingEntityListener.class)
public class FollowKomunitas implements Serializable {

    @Id
    private int id_follow;
    private int id_komunitas;
    private int id_user;

    public int getId_follow() {
        return id_follow;
    }

    public void setId_follow(int id_follow) {
        this.id_follow = id_follow;
    }

    public int getId_komunitas() {
        return id_komunitas;
    }

    public void setId_komunitas(int id_komunitas) {
        this.id_komunitas = id_komunitas;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
