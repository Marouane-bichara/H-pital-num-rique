package com.example.digitalhospital.service;

import com.example.digitalhospital.entities.Admin;
import com.example.digitalhospital.entities.Departement;
import com.example.digitalhospital.entities.Docteur;
import com.example.digitalhospital.repository.IAdminRepository;
import com.example.digitalhospital.repository.RepositoryImpl.AdminRepository;
import com.example.digitalhospital.service.interfacesService.IAdminService;

public class AdminService implements IAdminService {

    private IAdminRepository adminRepository;

    public AdminService()
    {
        this.adminRepository = new AdminRepository();
    }


    @Override
    public Admin findById(Long id){

            Admin admin = adminRepository.findById(id);

            return admin;

    }


    public Admin registerAdmin(String nom, String prenom, String email, String motDePasse,
                                   String adresse, String photo , String nationalite , String hobby)
    {

        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

//        Admin existingAdmin = adminRepository.findByEmail(email);
//        if (existingAdmin != null) {
//            throw new IllegalArgumentException("Email already registered");
//        }

        if (motDePasse == null || motDePasse.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters");
        }


        Admin admin = new Admin(nom, prenom, email, motDePasse, adresse , photo , nationalite , hobby);

        return adminRepository.save(admin);


    }



}
