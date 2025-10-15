package com.example.digitalhospital.service;

import com.example.digitalhospital.entities.Departement;
import com.example.digitalhospital.entities.Docteur;
import com.example.digitalhospital.repository.IDepartementRepository;
import com.example.digitalhospital.repository.IDocteurRepository;
import com.example.digitalhospital.repository.RepositoryImpl.DepartmentRepositoryImpl;
import com.example.digitalhospital.repository.RepositoryImpl.DocteurRepositoryImpl;
import com.example.digitalhospital.service.interfacesService.IDocteurService;

import java.util.List;
import java.util.Optional;

public class DocteurService implements IDocteurService {

    private final IDocteurRepository docteurRepository;
    private final IDepartementRepository departementRepository;

    public DocteurService()
    {
        this.docteurRepository = new DocteurRepositoryImpl();
        this.departementRepository = new DepartmentRepositoryImpl();
    }

    @Override
    public Docteur registerDocteur(String nom, String prenom, String email, String motDePasse,
                                   String specialite, Long departementId)
    {

        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

        Docteur existingDocteur = docteurRepository.findByEmail(email);
        if (existingDocteur != null) {
            throw new IllegalArgumentException("Email already registered");
        }

        if (motDePasse == null || motDePasse.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters");
        }

        if (specialite == null || specialite.trim().isEmpty()) {
            throw new IllegalArgumentException("Specialite cannot be empty");
        }

        Departement departementex = departementRepository.findById(departementId);

        if(departementex == null)
        {
            throw new IllegalArgumentException("Department not found with ID: " + departementId);
        }

        Docteur docteur = new Docteur(nom, prenom, email, motDePasse, specialite, departementex);

        return docteurRepository.save(docteur);
    }

    @Override
    public Docteur authenticate(String email, String motDePasse){
        Docteur existingDocteur = docteurRepository.findByEmail(email);

        if(existingDocteur != null && existingDocteur.getMotDePasse().equals(motDePasse))
        {
            return existingDocteur;
        }
        return null;
    }

    @Override
    public Docteur getDocteurById(Long id) {
        return docteurRepository.findById(id);
    }

    @Override
    public List<Docteur> getallDocteurs()
    {
        return docteurRepository.findAll();
    }

    @Override
    public List<Docteur> getDocteursByDepartement(Long departementId){
        return docteurRepository.findByDepartement(departementId);
    }

    @Override
    public List<Docteur> getDocteursBySpecialite(String specialite){
        if(specialite == null || specialite.trim().isEmpty())
        {
            return List.of();
        }
        return docteurRepository.findBySpecialite(specialite.trim());
    }

    @Override
    public Docteur updateDocteur(Long id, String nom, String prenom, String specialite, Long departementId)
    {
        Docteur docteurex = docteurRepository.findById(id);

        if(docteurex == null)
        {
            throw new IllegalArgumentException("Doctor not found with ID: " + id);
        }

        if (nom != null && !nom.trim().isEmpty()) {
            docteurex.setNom(nom);
        }
        if (prenom != null && !prenom.trim().isEmpty()) {
            docteurex.setPrenom(prenom);
        }
        if (specialite != null && !specialite.trim().isEmpty()) {
            docteurex.setSpecialite(specialite);
        }

        if(departementId != null)
        {
            Departement departementex = departementRepository.findById(departementId);
            if(departementex == null)
            {
                throw new IllegalArgumentException("Department not found with ID: " + departementId);
            }
            docteurex.setDepartement(departementex);
        }

        return docteurRepository.update(docteurex);
    }

    @Override
    public boolean updatePassword(Long docteurId, String oldPassword, String newPassword){
        Docteur docteurex = docteurRepository.findById(docteurId);

        if (docteurex == null)
        {
            return false;
        }

        if (!docteurex.getMotDePasse().equals(oldPassword))
        {
            return false;
        }

        if (newPassword == null || newPassword.length() < 6) {
            throw new IllegalArgumentException("New password must be at least 6 characters");
        }
        docteurex.setMotDePasse(newPassword);
        docteurRepository.update(docteurex);
        return true;
    }

    @Override
    public Docteur getDocteurWithConsultations(Long id){
        return docteurRepository.findByIdWithConsultations(id);
    }

    @Override
    public void deleteDocteur(Long id) {
        Docteur docteur = docteurRepository.findById(id);
        if (docteur == null) {
            throw new IllegalArgumentException("Doctor not found with ID: " + id);
        }
        docteurRepository.delete(id);
    }

    @Override
    public long getTotalDocteurs() {
        return docteurRepository.count();
    }

//    public boolean emailExists(String email) {
//        return docteurRepository.findByEmail(email);
//    }

}
