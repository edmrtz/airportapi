package dev.mrtz.airport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.mrtz.airport.dto.AeropuertoDTO;
import dev.mrtz.airport.exception.NotFoundException;
import dev.mrtz.airport.mapper.Mapper;
import dev.mrtz.airport.model.Aeropuerto;
import dev.mrtz.airport.repository.AeropuertoRepository;

@Service
public class AeropuertoService implements IAeropuertoService {
  @Autowired
  private AeropuertoRepository repo;

  @Override
  public List<AeropuertoDTO> getAeropuertos() {
    return repo.findAll().stream().map(Mapper::toDTO).toList();
  }

  @Override
  public AeropuertoDTO createAeropuerto(AeropuertoDTO dto) {
    Aeropuerto aeropuerto = Aeropuerto.builder()
        .nombre(dto.getNombre())
        .localidad(dto.getLocalidad())
        .provincia(dto.getProvincia())
        .build();

    repo.save(aeropuerto);
    AeropuertoDTO output = Mapper.toDTO(aeropuerto);
    return output;
  }

  @Override
  public AeropuertoDTO updateAeropuerto(Long id, AeropuertoDTO dto) {
    Aeropuerto aeropuerto = repo.findById(id).orElse(null);
    if (aeropuerto == null)
      throw new NotFoundException("Aeropuerto no encontrado.");

    if (dto.getNombre() != null)
      aeropuerto.setNombre(dto.getNombre());
    if (dto.getLocalidad() != null)
      aeropuerto.setLocalidad(dto.getLocalidad());
    if (dto.getProvincia() != null)
      aeropuerto.setProvincia(dto.getProvincia());

    repo.save(aeropuerto);
    AeropuertoDTO output = Mapper.toDTO(aeropuerto);
    return output;
  }

  @Override
  public void deleteAeropuerto(Long id) {
    Aeropuerto aeropuerto = repo.findById(id).orElse(null);
    if (aeropuerto == null)
      throw new NotFoundException("Aeropuerto no encontrado.");

    repo.delete(aeropuerto);
  }

}
