package com.example.digitalhospital.service.interfacesService;

import com.example.digitalhospital.entities.Personne;

public interface IAuthService {
     Personne authPersone(String email);
}
