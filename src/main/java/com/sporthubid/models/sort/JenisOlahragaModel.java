package com.sporthubid.models.sort;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mt_jenisolahraga")
public class JenisOlahragaModel implements Serializable {

    @Id
    @Column(name = "id_jenis")
    private Long id;

    @Column(name = "jenis_nama")
    private String jenisolahrga;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJenisolahrga() {
        return jenisolahrga;
    }

    public void setJenisolahrga(String jenisolahrga) {
        this.jenisolahrga = jenisolahrga;
    }

}
