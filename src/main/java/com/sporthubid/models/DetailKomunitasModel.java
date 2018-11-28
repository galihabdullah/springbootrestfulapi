package com.sporthubid.models;


import com.fasterxml.jackson.annotation.*;
import com.sporthubid.models.sort.JenisOlahragaModel;
import com.sporthubid.models.sort.KecamatanModel;
import com.sporthubid.models.sort.KelurahanModel;
import com.sporthubid.models.sort.LokasiModel;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_komunitas")
@EntityListeners(AuditingEntityListener.class)
public class DetailKomunitasModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_komunitas")
    private Long id;

    @Column(name = "id_user")
    private Long iduser;

    @Column(name = "id_lokasi")
    private Long idkota;

    @Column(name = "id_kecamatan")
    private Long idkecamatan;

    @Column(name = "id_kelurahan")
    private Long idkelurahan;

    @Column(name = "id_jenis")
    private Long idjenisolahraga;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_lokasi", insertable = false, updatable = false)
    @JsonIgnore
    private LokasiModel lokasiModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kecamatan", insertable = false, updatable = false)
    @JsonIgnore
    private KecamatanModel kecamatanModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kelurahan", insertable = false, updatable = false)
    @JsonIgnore
    private KelurahanModel kelurahanModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jenis", insertable = false, updatable = false)
    @JsonIgnore
    private JenisOlahragaModel jenisOlahragaModel;


    @Column(name = "nama_komunitas")
    private String namakomunitas;

    @Column(name = "telepon_komunitas")
    private String telepon;

    @Column(name = "alamat_komunitas")
    private String alamat;

    @Column(name = "gambar_komunitas")
    private String gambar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
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


    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public Long getIdkota() {
        return idkota;
    }

    public void setIdkota(Long idkota) {
        this.idkota = idkota;
    }

    public Long getIdkecamatan() {
        return idkecamatan;
    }

    public void setIdkecamatan(Long idkecamatan) {
        this.idkecamatan = idkecamatan;
    }

    public Long getIdkelurahan() {
        return idkelurahan;
    }

    public void setIdkelurahan(Long idkelurahan) {
        this.idkelurahan = idkelurahan;
    }

    public Long getIdjenisolahraga() {
        return idjenisolahraga;
    }

    public void setIdjenisolahraga(Long idjenisolahraga) {
        this.idjenisolahraga = idjenisolahraga;
    }

    public LokasiModel getLokasiModel() {
        return lokasiModel;
    }

    public void setLokasiModel(LokasiModel lokasiModel) {
        this.lokasiModel = lokasiModel;
    }

    public KecamatanModel getKecamatanModel() {
        return kecamatanModel;
    }

    public void setKecamatanModel(KecamatanModel kecamatanModel) {
        this.kecamatanModel = kecamatanModel;
    }

    public KelurahanModel getKelurahanModel() {
        return kelurahanModel;
    }

    public void setKelurahanModel(KelurahanModel kelurahanModel) {
        this.kelurahanModel = kelurahanModel;
    }

    public JenisOlahragaModel getJenisOlahragaModel() {
        return jenisOlahragaModel;
    }

    public void setJenisOlahragaModel(JenisOlahragaModel jenisOlahragaModel) {
        this.jenisOlahragaModel = jenisOlahragaModel;
    }

    @JsonGetter("jenisolahraga")
    public String getJenis(){
        if(jenisOlahragaModel != null){
            return jenisOlahragaModel.getJenisolahrga();
        }
        return null;

    }

    @JsonSetter(nulls = Nulls.AS_EMPTY)
    public void setJenis(JenisOlahragaModel jenisolahraga){
        if(jenisolahraga != null){
            this.jenisOlahragaModel = jenisolahraga;
        }
    }
    @JsonGetter("kota")
    public String geKotaJson(){
        if(lokasiModel != null){
            return lokasiModel.getNamakota();
        }
        return null;

    }

    @JsonSetter(nulls = Nulls.AS_EMPTY)
    public void setKotaJson(LokasiModel lokasiModel){
        if(lokasiModel != null){
            this.lokasiModel = lokasiModel;
        }
    }

    @JsonGetter("kecamatan")
    public String geKecamatanJson(){
        if(kecamatanModel != null){
            return kecamatanModel.getNamakecamatan();
        }
        return null;

    }

    @JsonSetter(nulls = Nulls.AS_EMPTY)
    public void setKecamatanJson(KecamatanModel kecamatanModel){
        if(kecamatanModel != null){
            this.kecamatanModel = kecamatanModel;
        }
    }
    @JsonGetter("kelurahan")
    public String geKelarahanJson(){
        if(kelurahanModel != null){
            return kelurahanModel.getNamakelurahan();
        }
        return null;

    }

    @JsonSetter(nulls = Nulls.AS_EMPTY)
    public void setKelurahanJson(KelurahanModel kelurahanModel){
        if(kelurahanModel != null){
            this.kelurahanModel = kelurahanModel;

        }
    }

}
