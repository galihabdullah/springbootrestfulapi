package com.sporthubid.models.sort;

import javax.persistence.*;

@Entity
@Table(name = "v_komunitas")
public class KomunitasModel {

    @Id
    @Column(name = "id_komunitas")
    private Long idkomunitas;

    @Column(name = "nama_komunitas")
    private String namakomunitas;

    @Column(name = "nama_lokasi")
    private String kota;

    @Column(name = "tempat_kecamatan")
    private String kecamatan;

    @Column(name = "nama_kelurahan")
    private String kelurahan;

    @Column(name = "jenis_nama")
    private String jenisolahraga;

    @Column(name = "gambar_komunitas")
    private String photo;

    @Transient
    private String url;


    public Long getIdkomunitas() {
        return idkomunitas;
    }

    public void setIdkomunitas(Long idkomunitas) {
        this.idkomunitas = idkomunitas;
    }

    public String getNamakomunitas() {
        return namakomunitas;
    }

    public void setNamakomunitas(String namakomunitas) {
        this.namakomunitas = namakomunitas;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getJenisolahraga() {
        return jenisolahraga;
    }

    public void setJenisolahraga(String jenisolahraga) {
        this.jenisolahraga = jenisolahraga;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUrl() {
        return "https://api-sporthub.herokuapp.com/detailkomunitas/id/" + this.getIdkomunitas();
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
