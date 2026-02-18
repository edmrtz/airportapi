package dev.mrtz.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.mrtz.airport.model.Aeropuerto;

public interface AeropuertoRepository extends JpaRepository<Aeropuerto, Long> {
}
