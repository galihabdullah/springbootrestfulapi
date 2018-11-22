package com.sporthubid.models.sort;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mt_kelurahan")
public class KelurahanModel implements Serializable {

    @Id
    @Column(name = "id_kelurahan")
    private Long id;

    @Column(name = "nama_kelurahan")
    private String namakelurahan;

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

}
