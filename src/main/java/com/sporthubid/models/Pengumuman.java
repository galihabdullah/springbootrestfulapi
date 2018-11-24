package com.sporthubid.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_pengumuman")
@EntityListeners(AuditingEntityListener.class)
public class Pengumuman implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_pengumuman;

    @Column
    private Integer id_komunitas;

    @Column
    private String title;

    @Column
    private String text;

    @Column
    private Integer status;

    public Long getId_pengumuman() {
        return id_pengumuman;
    }

    public void setId_pengumuman(Long id_pengumuman) {
        this.id_pengumuman = id_pengumuman;
    }

    public Integer getId_komunitas() {
        return id_komunitas;
    }

    public void setId_komunitas(Integer id_komunitas) {
        this.id_komunitas = id_komunitas;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
