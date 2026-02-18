package dev.mrtz.airport.service;

import java.util.List;

import dev.mrtz.airport.dto.VueloDTO;

public interface IVueloService {

  List<VueloDTO> getVuelos();

  VueloDTO createVuelo(VueloDTO dto);

  VueloDTO updateVuelo(Long id, VueloDTO dto);

  void deleteVuelo(Long id);
}
