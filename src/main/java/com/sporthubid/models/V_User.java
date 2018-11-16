package com.sporthubid.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "v_user")
@EntityListeners(AuditingEntityListener.class)
public class V_User implements Serializable {

    @Id
    private Long id_user;

    @Column
    private Long id_level;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Column(name="status", columnDefinition = "default 0")
    private String status;

    @Column
    private String level;

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public Long getId_level() {
        return id_level;
    }

    public void setId_level(Long id_level) {
        this.id_level = id_level;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
