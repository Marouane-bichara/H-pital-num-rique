package com.example.digitalhospital.repository;

import com.example.digitalhospital.entities.Admin;
import com.example.digitalhospital.entities.Docteur;

public interface IAdminRepository {

    Admin findById(Long id);

    Admin save(Admin docteur);

    Admin findByEmail(String email);
}
