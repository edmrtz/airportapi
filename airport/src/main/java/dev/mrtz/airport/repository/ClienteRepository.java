package dev.mrtz.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.mrtz.airport.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
