package com.sporthubid.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "sorttempat")
public class SortAndFilterTempatModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(name = "cabangOlahraga")
    private String cabangOlahraga;

    @NotBlank
    private String jenisOlahraga;

    @NotBlank
    private String namaTempat;

    @NotBlank
    private String lokasi;

    private Long idTempat;

    @NotBlank
    private String pictUrl;

    @Transient
    private String url;

    public SortAndFilterTempatModel(){

    }

    public SortAndFilterTempatModel(Long id, String cabangOlahraga, String jenisOlahraga, String namaTempat, String lokasi, Long idTempat, String url, String pictUrl){
        this.id = id;
        this.cabangOlahraga = cabangOlahraga;
        this.jenisOlahraga = jenisOlahraga;
        this.namaTempat = namaTempat;
        this.lokasi = lokasi;
        this.idTempat = idTempat;
        this.url = url;
        this.pictUrl = pictUrl;

    }

    public String getPictUrl() {
        return pictUrl;
    }

    public void setPictUrl(String pictUrl) {
        this.pictUrl = pictUrl;
    }

    public String getUrl() {
        return "http://localhost:8080/detailtempat/id/" + this.getId();
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getIdTempat() {
        return idTempat;
    }

    public void setIdTempat(Long idTempat) {
        this.idTempat = idTempat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCabangOlahraga() {
        return cabangOlahraga;
    }

    public void setCabangOlahraga(String cabangOlahraga) {
        this.cabangOlahraga = cabangOlahraga;
    }

    public String getJenisOlahraga() {
        return jenisOlahraga;
    }

    public void setJenisOlahraga(String jenisOlahraga) {
        this.jenisOlahraga = jenisOlahraga;
    }

    public String getNamaTempat() {
        return namaTempat;
    }

    public void setNamaTempat(String namaTempat) {
        this.namaTempat = namaTempat;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
}
