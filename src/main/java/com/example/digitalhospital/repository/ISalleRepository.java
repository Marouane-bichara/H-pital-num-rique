package com.example.digitalhospital.repository;

import com.example.digitalhospital.entities.Salle;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ISalleRepository {

    Salle save(Salle salle);
    Optional<Salle> findById(Long id);
    List<Salle> findAll();
    Salle update(Salle salle);
    void delete(Long id);
    long count();
    Optional<Salle> findByNomSalle(String nomSalle);
    List<Salle> findAvailableRooms(LocalDateTime dateTime);
    public boolean isRoomAvailable(Long salleId, LocalDateTime dateTime);
    void addOccupiedSlot(Long salleId, LocalDateTime dateTime);
    void removeOccupiedSlot(Long salleId, LocalDateTime dateTime);


}
