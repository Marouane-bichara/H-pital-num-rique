package com.example.digitalhospital.repository.RepositoryImpl;

import com.example.digitalhospital.entities.Patient;
import com.example.digitalhospital.repository.IPatientRepository;
import com.example.digitalhospital.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class PatientRepositoryImpl implements IPatientRepository {


    @Override
    public Patient save(Patient patient) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();

            em.persist(patient);
            transaction.commit();

            return patient;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error saving patient: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }


    @Override
    public Optional<Patient> findById(Long id) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            Patient patient = em.find(Patient.class, id);
            return Optional.ofNullable(patient);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Patient> findAll(){
        EntityManager em = JPAUtil.getEntityManager();

        try{
            TypedQuery<Patient> query = em.createQuery("SELECT p from Patient p" , Patient.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error while getting the patients "+e);
        }finally {
            em.close();
        }
    }

    @Override
    public Patient update(Patient patient){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();

            Patient updated = em.merge(patient);
            transaction.commit();
            return updated;
        }catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error updating patient: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Long id){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = em.getTransaction();
            transaction.begin();

            Patient patient = em.find(Patient.class , id);
            if (patient != null)
            {
                em.remove(patient);
            }
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error deleting patien" + e);
        }finally {
            em.close();
        }
    }

    @Override
    public long count() {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            TypedQuery<Long> query = em.createQuery(
                    "SELECT COUNT(p) FROM Patient p",
                    Long.class
            );
            return query.getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<Patient> findByEmail(String email) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            TypedQuery<Patient> query = em.createQuery(
                    "SELECT p FROM Patient p WHERE p.email = :email",
                    Patient.class
            );
            query.setParameter("email", email);

            List<Patient> results = query.getResultList();
            return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
        } finally {
            em.close();
        }
    }

    @Override
    public List<Patient> findByNom(String nom) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            TypedQuery<Patient> query = em.createQuery(
                    "SELECT p FROM Patient p WHERE LOWER(p.nom) LIKE LOWER(:nom)",
                    Patient.class
            );
            query.setParameter("nom", "%" + nom + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }



}
