package com.example.ProjetoLives.Entities;


import javax.persistence.*;

@Entity
@Table(name = "lives")
public class Live {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nomelive")
    private String nomeLive;
    @Column(name = "nomecanal")
    private String nomeCanal;
    @Column(name = "livelink")
    private String liveLink;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeLive() {
        return nomeLive;
    }

    public void setNomeLive(String nomeLive) {
        this.nomeLive = nomeLive;
    }

    public String getNomeCanal() {
        return nomeCanal;
    }

    public void setNomeCanal(String nomeCanal) {
        this.nomeCanal = nomeCanal;
    }

    public String getLiveLink() {
        return liveLink;
    }

    public void setLiveLink(String liveLink) {
        this.liveLink = liveLink;
    }

    public Live get() {
        return null;
    }
}
