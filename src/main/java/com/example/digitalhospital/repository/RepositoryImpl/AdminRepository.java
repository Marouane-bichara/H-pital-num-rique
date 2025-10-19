package com.example.digitalhospital.repository.RepositoryImpl;

import com.example.digitalhospital.entities.Admin;
import com.example.digitalhospital.entities.Docteur;
import com.example.digitalhospital.repository.IAdminRepository;
import com.example.digitalhospital.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class AdminRepository implements IAdminRepository {


    @Override
    public Admin findById(Long id){
        EntityManager em = JPAUtil.getEntityManager();

        try{
            Admin admin = em.find(Admin.class , id);

            if(admin != null)
            {
                return admin;
            }
            return null;
        } catch (RuntimeException e) {
            throw new RuntimeException("Admin not found "+e);
        }finally {
            em.close();
        }
    }



    @Override
    public Admin save(Admin admin)
    {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = null;

        try{
            transaction = em.getTransaction();
            transaction.begin();

            em.persist(admin);

            transaction.commit();
            return admin;

        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error saving admin: " + e.getMessage(), e);
        }finally {
            em.close();
        }
    }


    @Override
    public Admin findByEmail(String email){
        EntityManager em = JPAUtil.getEntityManager();

        try{
            TypedQuery<Admin> query = em.createQuery("SELECT a FROM Admin a WHERE a.email = :email" , Admin.class);
            query.setParameter("email" , email);

            return query.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException("Error while getting an admin "+e);
        }finally {
            em.close();
        }
    }
}
