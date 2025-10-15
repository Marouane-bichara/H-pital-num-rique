package com.example.digitalhospital.service;

import com.example.digitalhospital.entities.Personne;
import com.example.digitalhospital.repository.IAuthRepository;
import com.example.digitalhospital.repository.RepositoryImpl.AuthRepository;
import com.example.digitalhospital.service.interfacesService.IAuthService;

public class AuthService implements IAuthService {

    private IAuthRepository authRepository;
    public AuthService()
    {
        this.authRepository = new AuthRepository();
    }


    public Personne authPersone(String email){
        Personne personne = authRepository.authPersone(email);

        return personne;
    }
}
