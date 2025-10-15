package com.example.digitalhospital.repository;

import com.example.digitalhospital.entities.Departement;
import com.example.digitalhospital.entities.Docteur;

import java.util.List;

public interface IDocteurRepository {
    Docteur save(Docteur docteur);
    Docteur findById(Long id);
    List<Docteur> findAll();
    Docteur update(Docteur docteur);
    void delete(Long id);
    long count();
    Docteur findByEmail(String email);
    List<Docteur> findByDepartement(Long departementId);
    List<Docteur> findBySpecialite(String specialite);
    Docteur findByIdWithConsultations(Long id);

}
