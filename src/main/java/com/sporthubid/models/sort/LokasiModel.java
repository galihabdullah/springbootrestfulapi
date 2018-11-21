package com.sporthubid.models.sort;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "sort",
            joinColumns = {@JoinColumn(name = "id_lokasi")},
            inverseJoinColumns = {@JoinColumn(name = "id_kelurahan")}
    )
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
