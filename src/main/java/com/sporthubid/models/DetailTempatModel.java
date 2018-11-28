package com.sporthubid.models;


import com.fasterxml.jackson.annotation.*;
import com.sporthubid.models.sort.JenisOlahragaModel;
import com.sporthubid.models.sort.KecamatanModel;
import com.sporthubid.models.sort.KelurahanModel;
import com.sporthubid.models.sort.LokasiModel;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_tempat")
@EntityListeners(AuditingEntityListener.class)
public class DetailTempatModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tempat")
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
    @JoinColumn(name = "id_jenis", insertable = false, updatable = false, referencedColumnName = "id_jenis")
    @JsonIgnore
    private JenisOlahragaModel jenisolahraga;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_lokasi", insertable = false, updatable = false)
    @JsonIgnore
    private LokasiModel kota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kecamatan", insertable = false, updatable = false)
    @JsonIgnore
    private KecamatanModel kecamatan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kelurahan", insertable = false, updatable = false)
    @JsonIgnore
    private KelurahanModel kelurahan;

    @NotBlank
    @Column(name = "tempat_nama")
    private String namatempat;

    @Column(name = "tempat_tanggalberdiri")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalberdiri;

    @NotBlank
    @Column(name = "tempat_alamat")
    private String alamat;


    @NotBlank
    @Column(name = "tempat_deskripsi")
    private String deksripsi;

    @Column(name = "tempat_kapasitas")
    private Long kapasitas;

    @NotBlank
    @Column(name = "tempat_gambar")
    private String gambar;

    public DetailTempatModel(){

    }

    @JsonGetter("jenisolahraga")
    public String getJenis(){
        if(jenisolahraga != null){
            return jenisolahraga.getJenisolahrga();
        }
        return null;

    }

    @JsonSetter(nulls = Nulls.AS_EMPTY)
    public void setJenis(JenisOlahragaModel jenisolahraga){
        if(jenisolahraga != null){
            this.jenisolahraga = jenisolahraga;
        }
    }
    @JsonGetter("kota")
    public String geKotaJson(){
        if(kota != null){
            return kota.getNamakota();
        }
        return null;

    }

    @JsonSetter(nulls = Nulls.AS_EMPTY)
    public void setKotaJson(LokasiModel kota){
        if(kota != null){
            this.kota = kota;
        }
    }

    @JsonGetter("kecamatan")
    public String geKecamatanJson(){
        if(kecamatan != null){
            return kecamatan.getNamakecamatan();
        }
        return null;

    }

    @JsonSetter(nulls = Nulls.AS_EMPTY)
    public void setKecamatanJson(KecamatanModel kecamatan){
        if(kecamatan != null){
            this.kecamatan = kecamatan;
        }
    }
    @JsonGetter("kelurahan")
    public String geKelarahanJson(){
        if(kelurahan != null){
            return kelurahan.getNamakelurahan();
        }
        return null;

    }

    @JsonSetter(nulls = Nulls.AS_EMPTY)
    public void setKelurahanJson(KelurahanModel kelurahan){
        if(kelurahan != null){
            this.kelurahan = kelurahan;
        }
    }

    public DetailTempatModel(Long id, Long idjenisolahraga, Long idkecamatan, Long idkelurahan, Long idkota, String namatempat, Date tanggalberdiri, String deksripsi, Long kapasitas, String gambar, String alamat){
        this.id = id;
        this.idjenisolahraga = idjenisolahraga;
        this.idkecamatan = idkecamatan;
        this.idkelurahan = idkelurahan;
        this.idkota = idkota;
        this.namatempat = namatempat;
        this.alamat = alamat;
        this.deksripsi = deksripsi;
        this.tanggalberdiri = tanggalberdiri;
        this.kapasitas = kapasitas;
        this.gambar = gambar;
    }



    public LokasiModel getKota() {
        return kota;
    }

    public void setKota(LokasiModel kota) {
        this.kota = kota;
    }

    public KecamatanModel getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(KecamatanModel kecamatan) {
        this.kecamatan = kecamatan;
    }

    public KelurahanModel getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(KelurahanModel kelurahan) {
        this.kelurahan = kelurahan;
    }

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

    public JenisOlahragaModel getJenisolahraga() {
        return jenisolahraga;
    }

    public void setJenisolahraga(JenisOlahragaModel jenisolahraga) {
        this.jenisolahraga = jenisolahraga;
    }

}
