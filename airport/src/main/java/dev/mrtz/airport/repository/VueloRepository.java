package dev.mrtz.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.mrtz.airport.model.Vuelo;

public interface VueloRepository extends JpaRepository<Vuelo, Long> {

}
