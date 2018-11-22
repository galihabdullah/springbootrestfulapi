package com.sporthubid.models;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_user")
@EntityListeners(AuditingEntityListener.class)
public class UserEdit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_user;

    @Column
    private String f_nama;

    @Column
    private String l_nama;

    @Column
    private String foto;

    @Column
    private String alamat;

    @Column
    private String tmp_lahir;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tgl_lahir;

    @Column
    private String jenis_kelamin;

    @Column
    private String email;

    @Column
    private String no_hp;

    @Column
    private String minat_or;

    @Column
    private String komunitas;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updated_at;

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getF_nama() {
        return f_nama;
    }

    public void setF_nama(String f_nama) {
        this.f_nama = f_nama;
    }

    public String getL_nama() {
        return l_nama;
    }

    public void setL_nama(String l_nama) {
        this.l_nama = l_nama;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTmp_lahir() {
        return tmp_lahir;
    }

    public void setTmp_lahir(String tmp_lahir) {
        this.tmp_lahir = tmp_lahir;
    }

    public Date getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(Date tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getMinat_or() {
        return minat_or;
    }

    public void setMinat_or(String minat_or) {
        this.minat_or = minat_or;
    }

    public String getKomunitas() {
        return komunitas;
    }

    public void setKomunitas(String komunitas) {
        this.komunitas = komunitas;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
