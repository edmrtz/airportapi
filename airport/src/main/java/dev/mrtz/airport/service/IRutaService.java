package dev.mrtz.airport.service;

import java.util.List;

import dev.mrtz.airport.dto.RutaDTO;

public interface IRutaService {

  List<RutaDTO> getRutas();

  RutaDTO createRuta(RutaDTO dto);

  RutaDTO updateRuta(Long id, RutaDTO dto);

  void deleteRuta(Long id);
}
