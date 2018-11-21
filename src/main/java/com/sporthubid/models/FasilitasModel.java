package com.sporthubid.models;

import com.fasterxml.jackson.core.SerializableString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "v_fasilitas")
public class FasilitasModel implements Serializable {

    @Id
    @Column(name = "id_tempat")
    private Long IdTempat;

    @Column(name = "tempat_nama")
    private String NamaTempat;

    @Column(name = "nama_lokasi")
    private String kota;

    @Column(name = "nama_kelurahan")
    private String kelurahan;

    @Column(name = "jenis_nama")
    private String jenisolahraga;

    @Column(name = "tempat_deskripsi")
    private String deskripsi;

    @Column(name = "tempat_kapasitas")
    private Long kapasitas;

    @Column(name = "tempat_gambar")
    private String urlgambar;

    @Transient
    private String url;

    public FasilitasModel(){

    }

    public FasilitasModel(Long idTempat, String namaTempat, String kelurahan, String deskripsi, Long kapasitas, String urlgambar, String url, String kota, String jenisolahraga ){
        this.IdTempat = idTempat;
        this.NamaTempat = namaTempat;
        this.kelurahan = kelurahan;
        this.deskripsi = deskripsi;
        this.kapasitas = kapasitas;
        this.urlgambar = urlgambar;
        this.url = url;
        this.kota = kota;
        this.jenisolahraga = jenisolahraga;
    }

    public String getJenisolahraga() {
        return jenisolahraga;
    }

    public void setJenisolahraga(String jenisolahraga) {
        this.jenisolahraga = jenisolahraga;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public Long getIdTempat() {
        return IdTempat;
    }

    public void setIdTempat(Long idTempat) {
        IdTempat = idTempat;
    }

    public String getNamaTempat() {
        return NamaTempat;
    }

    public void setNamaTempat(String namaTempat) {
        NamaTempat = namaTempat;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Long getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(Long kapasitas) {
        this.kapasitas = kapasitas;
    }

    public String getUrlgambar() {
        return urlgambar;
    }

    public void setUrlgambar(String urlgambar) {
        this.urlgambar = urlgambar;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getUrl() {
        return "https://api-sporthub.herokuapp.com/detailtempat/id/" + this.getIdTempat();
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
