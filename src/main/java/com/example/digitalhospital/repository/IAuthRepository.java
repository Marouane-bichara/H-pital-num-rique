package com.example.digitalhospital.repository;

import com.example.digitalhospital.entities.Admin;
import com.example.digitalhospital.entities.Personne;

public interface IAuthRepository {

    Personne authPersone(String email);

}
