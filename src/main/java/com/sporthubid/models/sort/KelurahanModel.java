package com.sporthubid.models.sort;

import com.fasterxml.jackson.annotation.*;
import com.sporthubid.models.DetailTempatModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "mt_kelurahan")
public class KelurahanModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_kelurahan")
    private Long id;

    @Column(name = "id_kecamatan")
    private Long idkecamatan;

    @Column(name = "id_lokasi")
    private Long idkota;

    @Column(name = "nama_kelurahan")
    private String namakelurahan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_lokasi", insertable = false, updatable = false)
    @JsonIgnore
    private LokasiModel kota;

    public LokasiModel getKota() {
        return kota;
    }

    public void setKota(LokasiModel kota) {
        this.kota = kota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamakelurahan() {
        return namakelurahan;
    }

    public void setNamakelurahan(String namakelurahan) {
        this.namakelurahan = namakelurahan;
    }

    public Long getIdkecamatan() {
        return idkecamatan;
    }

    public void setIdkecamatan(Long idkecamatan) {
        this.idkecamatan = idkecamatan;
    }

    public Long getIdkota() {
        return idkota;
    }

    public void setIdkota(Long idkota) {
        this.idkota = idkota;
    }
}
