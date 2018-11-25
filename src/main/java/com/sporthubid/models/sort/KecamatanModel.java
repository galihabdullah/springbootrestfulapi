package com.sporthubid.models.sort;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sporthubid.models.DetailTempatModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "mt_kecamatan")
public class KecamatanModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_kecamatan")
    private Long id;

    @Column(name = "id_lokasi")
    private Long idkota;

    @Column(name = "tempat_kecamatan")
    private String namakecamatan;


    public Long getIdkota() {
        return idkota;
    }

    public void setIdkota(Long idkota) {
        this.idkota = idkota;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamakecamatan() {
        return namakecamatan;
    }

    public void setNamakecamatan(String namakecamatan) {
        this.namakecamatan = namakecamatan;
    }

}
