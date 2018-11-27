package com.sporthubid.models.sort;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sporthubid.models.DetailTempatModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_ratings")
public class RatingModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rating")
    private Long id;

    @Column(name = "id_tempat")
    private Long idtempat;

    @Column(name = "id_user")
    private Long iduser;

    private Long rating;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tempat", insertable = false, updatable = false)
    @JsonIgnore
    private DetailTempatModel tempat;

    public DetailTempatModel getTempat() {
        return tempat;
    }

    public void setTempat(DetailTempatModel tempat) {
        this.tempat = tempat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdtempat() {
        return idtempat;
    }

    public void setIdtempat(Long idtempat) {
        this.idtempat = idtempat;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }
}
