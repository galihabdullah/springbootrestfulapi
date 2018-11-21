package com.sporthubid.models.sort;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sporthubid.models.FasilitasModel;
import org.hibernate.annotations.Any;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Where;
import org.hibernate.annotations.WhereJoinTable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
