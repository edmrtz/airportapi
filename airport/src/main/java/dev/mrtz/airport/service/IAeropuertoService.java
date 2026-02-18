package dev.mrtz.airport.service;

import java.util.List;

import dev.mrtz.airport.dto.AeropuertoDTO;

public interface IAeropuertoService {

  List<AeropuertoDTO> getAeropuertos();

  AeropuertoDTO createAeropuerto(AeropuertoDTO dto);

  AeropuertoDTO updateAeropuerto(Long id, AeropuertoDTO dto);

  void deleteAeropuerto(Long id);
}
