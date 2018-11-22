package com.sporthubid.models;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_tempat")
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
    private String kapasitas;

    @NotBlank
    @Column(name = "tempat_gambar")
    private String gambar;

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

    public String getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(String kapasitas) {
        this.kapasitas = kapasitas;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
