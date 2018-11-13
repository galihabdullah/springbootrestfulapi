package com.sporthubid.models;



import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_user")
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_user;

    @Column
    private Long id_level;

    @Column
    private String f_nama;

    @Column
    private String l_nama;

    @Column
    private String alamat;

    @Column
    private String tmp_lahir;

    @Column
    private Date tgl_lahir;

    @Column
    private String jenis_kelamin;

    @Column
    private String email;

    @Column
    private String no_hp;

    @Column
    private String minat_or;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Column(name="status", columnDefinition = "default 0")
    private String status;

    @Column(name="flag_hapus", columnDefinition = "default 0")
    private String flag_hapus;

    @Column
    private Date created_at;

    @Column
    private Date updated_at;

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public Long getId_level() {
        return id_level;
    }

    public void setId_level(Long id_level) {
        this.id_level = id_level;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFlag_hapus() {
        return flag_hapus;
    }

    public void setFlag_hapus(String flag_hapus) {
        this.flag_hapus = flag_hapus;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
