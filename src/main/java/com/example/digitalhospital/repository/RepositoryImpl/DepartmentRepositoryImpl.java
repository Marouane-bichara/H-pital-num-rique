package com.example.digitalhospital.repository.RepositoryImpl;

import com.example.digitalhospital.entities.Departement;
import com.example.digitalhospital.repository.IDepartementRepository;
import com.example.digitalhospital.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class DepartmentRepositoryImpl implements IDepartementRepository {

    @Override
    public Departement save(Departement patient) {
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
    public Departement findById(Long id) {

        EntityManager em = JPAUtil.getEntityManager();

        try{
            Departement departement = em.find(Departement.class, id);
            if (departement != null)
            {
                return departement;
            }
            return null;
        }catch (RuntimeException e)
        {
            throw new RuntimeException("Departement not found " +e);
        }

    }


    public List<Departement> findAll()
    {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            TypedQuery<Departement> query = em.createQuery(
                    "SELECT d FROM Departement d",
                    Departement.class
            );
            return query.getResultList();
        } finally {
            em.close();
        }
    }


    @Override
    public Departement update(Departement departement) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();

            Departement updated = em.merge(departement);

            transaction.commit();
            return updated;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error updating departement: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }


    @Override
    public void delete(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();

            Departement departement = em.find(Departement.class, id);
            if (departement != null) {
                em.remove(departement);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error deleting departement: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteEntity(Departement departement) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();

            Departement managed = em.merge(departement);
            em.remove(managed);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error deleting departement entity: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }


    @Override
    public long count() {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            TypedQuery<Long> query = em.createQuery(
                    "SELECT COUNT(d) FROM Departement d",
                    Long.class
            );
            return query.getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Departement> searchByNom(String nom) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            TypedQuery<Departement> query = em.createQuery(
                    "SELECT d FROM Departement d WHERE LOWER(d.nom) LIKE LOWER(:nom)",
                    Departement.class
            );
            query.setParameter("nom", "%" + nom + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Optional<Departement> findByNom(String nom) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            TypedQuery<Departement> query = em.createQuery(
                    "SELECT d FROM Departement d WHERE d.nom = :nom",
                    Departement.class
            );
            query.setParameter("nom", nom);

            List<Departement> results = query.getResultList();
            return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
        } finally {
            em.close();
        }
    }

    @Override
    public Departement getByIdWithDocteurs(Long id) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            TypedQuery<Departement> query = em.createQuery(
                    "SELECT d FROM Departement d LEFT JOIN FETCH d.docteurs WHERE d.idDepartement = :id",
                    Departement.class
            );
            query.setParameter("id", id);

            List<Departement> results = query.getResultList();
            return results.isEmpty() ? null : results.get(0);
        } finally {
            em.close();
        }
    }



}
