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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    @JsonGetter("komunitas")
    public DetailKomunitasModel komunitas(){
        if(komunitasModel != null){
            return komunitasModel;
        }
        return null;
    }

    @JsonSetter(nulls = Nulls.AS_EMPTY)
    public void setKomunitas(DetailKomunitasModel detailKomunitasModel){
        if(detailKomunitasModel != null){
            this.komunitasModel = detailKomunitasModel;
        }
    }


}
