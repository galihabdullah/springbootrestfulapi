package com.sportshubid.sportshubid.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tempat")
@EntityListeners(AuditingEntityListener.class)
public class DetailTempatModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tempat")
    private Long id;

    @NotBlank
    @Column(name = "tempat_nama")
    private String namatempat;

    @NotBlank
    @Column(name = "tempat_tanggalberdiri")
    private Date tanggalberdiri;

    @NotBlank
    @Column(name = "tempat_alamat")
    private String alamat;

    @NotBlank
    @Column(name = "tempat_kelurahan")
    private String kelurahan;

    @NotBlank
    @Column(name = "tempat_kecamatan")
    private String kecamatan;

    @NotBlank
    @Column(name = "tempat_wilayah")
    private String wilayah;

    @NotBlank
    @Column(name = "tempat_deskripsi")
    private String deksripsi;

    @NotBlank
    @Column(name = "tempat_kapasitas")
    private Long kapasitas;

    @NotBlank
    @Column(name = "tempat_gambar")
    private String gambar;

    public DetailTempatModel(){

    }

    public DetailTempatModel(Long id, String namatempat, Date tanggalberdiri, String alamat, String kelurahan, String kecamatan, String wilayah, String deksripsi, Long kapasitas, String gambar){
        this.id = id;
        this.namatempat = namatempat;
        this.tanggalberdiri = tanggalberdiri;
        this.alamat = alamat;
        this.kelurahan = kelurahan;
        this.kecamatan = kecamatan;
        this.wilayah = wilayah;
        this.kapasitas = kapasitas;
        this.gambar = gambar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamatempat() {
        return namatempat;
    }

    public void setNamatempat(String namatempat) {
        this.namatempat = namatempat;
    }

    public Date getTanggalberdiri() {
        return tanggalberdiri;
    }

    public void setTanggalberdiri(Date tanggalberdiri) {
        this.tanggalberdiri = tanggalberdiri;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getWilayah() {
        return wilayah;
    }

    public void setWilayah(String wilayah) {
        this.wilayah = wilayah;
    }

    public String getDeksripsi() {
        return deksripsi;
    }

    public void setDeksripsi(String deksripsi) {
        this.deksripsi = deksripsi;
    }

    public Long getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(Long kapasitas) {
        this.kapasitas = kapasitas;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
