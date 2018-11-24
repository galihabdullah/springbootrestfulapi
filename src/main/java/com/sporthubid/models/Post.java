package com.sporthubid.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table (name = "tb_post")
@EntityListeners(AuditingEntityListener.class)
public class Post implements Serializable  {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id_post;
    private Integer id_komunitas;
    private Date post_tgl;
    private String post_judul;
    private String post_isi;

    public Integer getId_post() {
        return id_post;
    }

    public void setId_post(Integer id_post) {
        this.id_post = id_post;
    }

    public Integer getId_komunitas() {
        return id_komunitas;
    }

    public void setId_komunitas(Integer id_komunitas) {
        this.id_komunitas = id_komunitas;
    }

    public Date getPost_tgl() {
        return post_tgl;
    }

    public void setPost_tgl(Date post_tgl) {
        this.post_tgl = post_tgl;
    }

    public String getPost_judul() {
        return post_judul;
    }

    public void setPost_judul(String post_judul) {
        this.post_judul = post_judul;
    }

    public String getPost_isi() {
        return post_isi;
    }

    public void setPost_isi(String post_isi) {
        this.post_isi = post_isi;
    }
}
