package com.example.digitalhospital.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "admin")
public class Admin extends Personne {

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "photo")
    private String photo;

    @Column(name = "nationalite")
    private String nationalite;


    @Column(name = "hobby")
    private String hobby;

    public Admin() {}


    public Admin(String nom, String prenom, String email, String motDePasse, String adresse, String photo , String nationalite , String hobby) {
        super(nom, prenom, email, motDePasse);
        this.adresse = adresse;
        this.photo = photo;
        this.nationalite = nationalite;
        this.hobby = hobby;
    }


    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }


}
