package dev.mrtz.airport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.mrtz.airport.dto.RutaDTO;
import dev.mrtz.airport.exception.NotFoundException;
import dev.mrtz.airport.exception.SameAirportException;
import dev.mrtz.airport.mapper.Mapper;
import dev.mrtz.airport.model.Aeropuerto;
import dev.mrtz.airport.model.Ruta;
import dev.mrtz.airport.repository.AeropuertoRepository;
import dev.mrtz.airport.repository.RutaRepository;

@Service
public class RutaService implements IRutaService {

  @Autowired
  private RutaRepository rutaRepo;
  @Autowired
  private AeropuertoRepository aeropuertoRepo;

  @Override
  public List<RutaDTO> getRutas() {
    return rutaRepo.findAll().stream().map(Mapper::toDTO).toList();
  }

  @Override
  public RutaDTO createRuta(RutaDTO dto) {
    if (dto == null)
      return null;

    Long origenId = dto.getIdAeropuertoOrigen();
    Long destinoId = dto.getIdAeropuertoDestino();

    if (origenId == destinoId)
      throw new SameAirportException("El Aerpuerto Origen no puede ser el mismo que el destino");

    Aeropuerto origen = aeropuertoRepo.findById(origenId).orElse(null);
    Aeropuerto destino = aeropuertoRepo.findById(destinoId).orElse(null);

    if (origen == null || destino == null)
      throw new NotFoundException("Aeropuerto no encontrado");

    Ruta ruta = Ruta.builder()
        .origen(origen)
        .destino(destino).build();

    rutaRepo.save(ruta);
    RutaDTO output = Mapper.toDTO(ruta);
    return output;
  }

  @Override
  public RutaDTO updateRuta(Long id, RutaDTO dto) {
    Ruta ruta = rutaRepo.findById(id).orElse(null);
    if (ruta == null)
      throw new NotFoundException("Ruta no encontrada");

    Aeropuerto origen = aeropuertoRepo.findById(dto.getIdAeropuertoOrigen()).orElse(null);
    Aeropuerto destino = aeropuertoRepo.findById(dto.getIdAeropuertoDestino()).orElse(null);

    if (origen == null || destino == null)
      throw new NotFoundException("Aeropuerto no encontrado");

    if (origen.getId() == destino.getId())
      throw new SameAirportException("El Aerpuerto Origen no puede ser el mismo que el destino");

    ruta.setOrigen(origen);
    ruta.setDestino(destino);

    rutaRepo.save(ruta);
    RutaDTO output = Mapper.toDTO(ruta);
    return output;
  }

  @Override
  public void deleteRuta(Long id) {
    Ruta ruta = rutaRepo.findById(id).orElse(null);
    if (ruta == null)
      throw new NotFoundException("Ruta no encontrada");

    rutaRepo.delete(ruta);
  }
}
