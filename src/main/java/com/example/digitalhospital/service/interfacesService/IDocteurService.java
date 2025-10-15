package com.example.digitalhospital.service.interfacesService;

import com.example.digitalhospital.entities.Docteur;

import java.util.List;
import java.util.Optional;

public interface IDocteurService {
    Docteur registerDocteur(String nom, String prenom, String email, String motDePasse, String specialite, Long departementId);
    Docteur authenticate(String email, String motDePasse);
    Docteur getDocteurById(Long id);
    List<Docteur> getallDocteurs();
    List<Docteur> getDocteursByDepartement(Long departementId);
    List<Docteur> getDocteursBySpecialite(String specialite);
    Docteur updateDocteur(Long id, String nom, String prenom, String specialite, Long departementId);
    boolean updatePassword(Long docteurId, String oldPassword, String newPassword);
    Docteur getDocteurWithConsultations(Long id);
    void deleteDocteur(Long id);
    long getTotalDocteurs();
}
