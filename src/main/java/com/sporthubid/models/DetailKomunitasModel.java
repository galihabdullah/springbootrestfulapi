package com.sporthubid.models;


import javax.persistence.*;

@Entity
@Table(name = "tb_komunitas")
public class DetailKomunitasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_komunitas")
    private Long id;

    @Column(name = "nama_komunitas")
    private String namakomunitas;

    @Column(name = "telepon_komunitas")
    private String telepon;

    @Column(name = "alamat_komunitas")
    private String alamat;

    @Column(name = "kelurahan_komunitas")
    private String kelurahan;

    @Column(name = "kecamatan_komunitas")
    private String kecamatan;

    @Column(name = "kota_komunitas")
    private String kota;

    @Column(name = "gambar_komunitas")
    private String gambar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamakomunitas() {
        return namakomunitas;
    }

    public void setNamakomunitas(String namakomunitas) {
        this.namakomunitas = namakomunitas;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
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

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
