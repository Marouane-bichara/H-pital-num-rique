package com.example.digitalhospital.repository;

import com.example.digitalhospital.entities.Patient;

import java.util.List;
import java.util.Optional;

public interface IPatientRepository {
    Patient save(Patient patient);
    Optional<Patient> findById(Long id);
    List<Patient> findAll();
    Patient update(Patient patient);
    long count();
    void delete(Long id);
    Optional<Patient> findByEmail(String email);
    List<Patient> findByNom(String nom);
}
