package dev.mrtz.airport.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.mrtz.airport.dto.VueloDTO;
import dev.mrtz.airport.exception.NotFoundException;
import dev.mrtz.airport.mapper.Mapper;
import dev.mrtz.airport.model.Ruta;
import dev.mrtz.airport.model.Vuelo;
import dev.mrtz.airport.repository.RutaRepository;
import dev.mrtz.airport.repository.VueloRepository;

@Service
public class VueloService implements IVueloService {
  private VueloRepository vueloRepo;
  private RutaRepository rutaRepo;

  @Override
  public List<VueloDTO> getVuelos() {
    return vueloRepo.findAll().stream().map(Mapper::toDTO).toList();
  }

  @Override
  public VueloDTO createVuelo(VueloDTO dto) {
    Ruta ruta = rutaRepo.findById(dto.getIdRuta()).orElse(null);

    if (ruta == null)
      throw new NotFoundException("Ruta no encontrada");

    Vuelo vuelo = Vuelo.builder()
        .ruta(ruta)
        .fechaSalida(dto.getFechaSalida())
        .asientosTotales(dto.getAsientosTotales())
        .asientosDisponibles(dto.getAsientosDisponibles()).build();

    vueloRepo.save(vuelo);
    return Mapper.toDTO(vuelo);
  }

  @Override
  public VueloDTO updateVuelo(Long id, VueloDTO dto) {
    Vuelo vuelo = vueloRepo.findById(id).orElse(null);
    if (vuelo == null)
      throw new NotFoundException("Vuelo no encontrado");

    Ruta ruta = rutaRepo.findById(dto.getIdRuta()).orElse(null);

    if (ruta == null)
      throw new NotFoundException("Ruta no encontrada");

    if (dto.getFechaSalida() != null)
      vuelo.setFechaSalida(dto.getFechaSalida());

    vuelo.setRuta(ruta);
    vuelo.setAsientosTotales(dto.getAsientosTotales());
    vuelo.setAsientosDisponibles(dto.getAsientosDisponibles());
    vueloRepo.save(vuelo);

    return Mapper.toDTO(vuelo);
  }

  @Override
  public void deleteVuelo(Long id) {
    Vuelo vuelo = vueloRepo.findById(id).orElse(null);

    if (vuelo == null)
      throw new NotFoundException("Vuelo no encontrado");
    vueloRepo.delete(vuelo);
  }

}
