package com.example.digitalhospital.repository.RepositoryImpl;

import com.example.digitalhospital.entities.Docteur;
import com.example.digitalhospital.repository.IDocteurRepository;
import com.example.digitalhospital.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DocteurRepositoryImpl implements IDocteurRepository {


    @Override
    public Docteur save(Docteur docteur)
    {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = em.getTransaction();
            transaction.begin();

            em.persist(docteur);

            transaction.commit();
            return docteur;

        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error saving docteur: " + e.getMessage(), e);
        }finally {
            em.close();
        }
    }

    @Override
    public Docteur findById(Long id){
        EntityManager em = JPAUtil.getEntityManager();

        try{
            Docteur docteur = em.find(Docteur.class , id);

            if(docteur != null)
            {
                return docteur;
            }
            return null;
        } catch (RuntimeException e) {
            throw new RuntimeException("Docteur not found "+e);
        }finally {
            em.close();
        }
    }

    @Override
    public List<Docteur> findAll()
    {
        EntityManager em = JPAUtil.getEntityManager();

        try{
            TypedQuery<Docteur> query = em.createQuery("SELECT d from Docteur d" , Docteur.class);

            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error while finding all "+e);
        }finally {
            em.close();
        }
    }

    @Override
    public Docteur update(Docteur docteur){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = em.getTransaction();
            transaction.begin();

            Docteur updated = em.merge(docteur);

            transaction.commit();
            return updated;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error updating docteur: " + e.getMessage(), e);
        }finally {
            em.close();
        }
    }

    @Override
    public void delete(Long id)
    {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = em.getTransaction();
            transaction.begin();

            Docteur docteur = em.find(Docteur.class , id);
            if(docteur != null)
            {
                em.remove(docteur);
            }
            transaction.commit();
        } catch (Exception e) {

            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Docteur not found  "+e);
        }finally {
            em.close();
        }

    }


    @Override

    public long count()
    {
        EntityManager em = JPAUtil.getEntityManager();

        try{
            TypedQuery<Long> query = em.createQuery("SELECT count(d) from Docteur d" , Long.class);
            return query.getSingleResult();
        }finally {
            em.close();
        }
    }

    @Override
    public Docteur findByEmail(String email){
        EntityManager em = JPAUtil.getEntityManager();

        try{
            TypedQuery<Docteur> query = em.createQuery("SELECT d FROM Docteur d WHERE d.email = :email" , Docteur.class);
            query.setParameter("email" , email);

            return query.getSingleResult();
        }catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Error while getting an docteur "+e);
        }finally {
            em.close();
        }
    }

    @Override
    public List<Docteur> findByDepartement(Long departementId) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            TypedQuery<Docteur> query = em.createQuery(
                    "SELECT d FROM Docteur d WHERE d.departement.idDepartement = :deptId",
                    Docteur.class
            );
            query.setParameter("deptId", departementId);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Docteur> findBySpecialite(String specialite){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            TypedQuery<Docteur> query = em.createQuery("SELECT d FROM Docteur d WHERE LOWER(d.specialite) LIKE LOWER(:specialite)" , Docteur.class);
            query.setParameter("specialite", "%" + specialite + "%");

            return query.getResultList();
        }finally {
            em.close();
        }
    }

    public Docteur findByIdWithConsultations(Long id){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            TypedQuery<Docteur> query = em.createQuery("SELECT d FROM Docteur d LEFT JOIN FETCH d.consultations WHERE d.id = :id" , Docteur.class);
            query.setParameter("id" , id);
            List<Docteur> results = query.getResultList();
            return results.isEmpty() ? null : results.get(0);
        }finally {
            em.close();
        }
    }
}
