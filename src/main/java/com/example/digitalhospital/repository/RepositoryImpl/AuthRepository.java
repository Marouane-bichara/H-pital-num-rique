package com.example.digitalhospital.repository.RepositoryImpl;

import com.example.digitalhospital.entities.Personne;
import com.example.digitalhospital.repository.IAuthRepository;
import com.example.digitalhospital.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class AuthRepository implements IAuthRepository {


    @Override
    public Personne authPersone(String email){
        EntityManager em = JPAUtil.getEntityManager();

        try{
            TypedQuery<Personne> query = em.createQuery("SELECT p FROM Personne p WHERE p.email = :email" , Personne.class);

            query.setParameter("email" , email);

            return query.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException("Error while getting the informations" , e);
        }finally {
            em.close();
        }
    }
}
