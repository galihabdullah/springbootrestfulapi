package com.sporthubid.models.sort;

import com.fasterxml.jackson.annotation.*;
import com.sporthubid.models.DetailTempatModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "mt_kota")
public class LokasiModel implements Serializable {
    @Id
    @Column(name = "id_lokasi")
    private Long id;

    @Column(name = "nama_lokasi")
    private String namakota;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "kota")
    private Set<KelurahanModel> kelurahanModels = new HashSet<>();

    public Set<KelurahanModel> getKelurahanModels() {
        return kelurahanModels;
    }

    public void setKelurahanModels(Set<KelurahanModel> kelurahanModels) {
        this.kelurahanModels = kelurahanModels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamakota() {
        return namakota;
    }

    public void setNamakota(String namakota) {
        this.namakota = namakota;
    }
}
