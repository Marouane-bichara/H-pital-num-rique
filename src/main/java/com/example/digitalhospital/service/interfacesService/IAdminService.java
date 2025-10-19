package com.example.digitalhospital.service.interfacesService;

import com.example.digitalhospital.entities.Admin;
import com.example.digitalhospital.entities.Docteur;

public interface IAdminService {
    Admin findById(Long id);

    Admin registerAdmin(String nom, String prenom, String email, String motDePasse,
                        String adresse, String photo , String nationalite , String hobby);


}
