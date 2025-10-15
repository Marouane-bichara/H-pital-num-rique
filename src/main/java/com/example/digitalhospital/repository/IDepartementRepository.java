package com.example.digitalhospital.repository;

import com.example.digitalhospital.entities.Departement;

import java.util.List;
import java.util.Optional;

public interface IDepartementRepository {

    Departement save(Departement patient);

    Optional<Departement> findByNom(String nom);

    Departement findById(Long id);

    List<Departement> findAll();

    Departement update(Departement departement);

    void delete(Long id);

    void deleteEntity(Departement departement);

    long count();

    List<Departement> searchByNom(String nom);

    Departement getByIdWithDocteurs(Long id);

}
