package com.sporthubid.models;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_follow")
@EntityListeners(AuditingEntityListener.class)
public class FollowKomunitas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_follow")
    private int idfollow;

    @Column(name = "id_komunitas")
    private int idkomunitas;

    @Column(name = "id_user")
    private int iduser;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_komunitas", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private DetailKomunitasModel komunitasModel;

    public DetailKomunitasModel getKomunitasModel() {
        return komunitasModel;
    }

    public void setKomunitasModel(DetailKomunitasModel komunitasModel) {
        this.komunitasModel = komunitasModel;
    }

    public int getIdfollow() {
        return idfollow;
    }

    public void setIdfollow(int idfollow) {
        this.idfollow = idfollow;
    }

    public int getIdkomunitas() {
        return idkomunitas;
    }

    public void setIdkomunitas(int idkomunitas) {
        this.idkomunitas = idkomunitas;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }



}
