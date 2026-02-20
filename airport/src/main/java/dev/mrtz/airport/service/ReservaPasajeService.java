package dev.mrtz.airport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.mrtz.airport.dto.ReservaPasajeDTO;
import dev.mrtz.airport.exception.NotFoundException;
import dev.mrtz.airport.mapper.Mapper;
import dev.mrtz.airport.model.Cliente;
import dev.mrtz.airport.model.ReservaPasaje;
import dev.mrtz.airport.model.Vuelo;
import dev.mrtz.airport.repository.ClienteRepository;
import dev.mrtz.airport.repository.ReservaPasajeRepository;
import dev.mrtz.airport.repository.VueloRepository;

@Service
public class ReservaPasajeService implements IReservaPasajeService {
  @Autowired
  private ReservaPasajeRepository reservaRepo;
  @Autowired
  private VueloRepository vueloRepo;
  @Autowired
  private ClienteRepository clienteRepo;

  @Override
  public List<ReservaPasajeDTO> getReservas() {
    return reservaRepo.findAll().stream().map(Mapper::toDTO).toList();
  }

  @Override
  public ReservaPasajeDTO createReserva(ReservaPasajeDTO dto) {
    if (dto == null)
      throw new NotFoundException("Reserva del Pasaje no valida");

    Vuelo vuelo = vueloRepo.findById(dto.getIdVuelo()).orElse(null);
    if (vuelo == null)
      throw new NotFoundException("Vuelo no encontrado");

    Cliente cliente = clienteRepo.findById(dto.getIdCliente()).orElse(null);
    if (cliente == null)
      throw new NotFoundException("Cliente no encontrado");

    ReservaPasaje reserva = ReservaPasaje.builder()
        .vuelo(vuelo)
        .cliente(cliente)
        .fechaReserva(dto.getFechaReserva())
        .nroAsiento(dto.getNroAsiento())
        .fechaCheckIn(dto.getFechaCheckIn())
        .estado(dto.getEstado())
        .build();

    reservaRepo.save(reserva);
    return Mapper.toDTO(reserva);
  }

  @Override
  public ReservaPasajeDTO updateReserva(Long id, ReservaPasajeDTO dto) {
    ReservaPasaje reserva = reservaRepo.findById(id).orElse(null);
    if (reserva == null)
      throw new NotFoundException("Reserva del Pasaje no encontrada");

    Vuelo vuelo = vueloRepo.findById(dto.getIdVuelo()).orElse(null);
    if (vuelo == null)
      throw new NotFoundException("Vuelo no encontrado");

    Cliente cliente = clienteRepo.findById(dto.getIdCliente()).orElse(null);
    if (cliente == null)
      throw new NotFoundException("Cliente no encontrado");

    if (dto.getFechaReserva() != null)
      reserva.setFechaReserva(dto.getFechaReserva());
    if (dto.getNroAsiento() != null)
      reserva.setNroAsiento(dto.getNroAsiento());

    if (dto.getFechaCheckIn() != null)
      reserva.setFechaCheckIn(dto.getFechaCheckIn());
    if (dto.getEstado() != null)
      reserva.setEstado(dto.getEstado());

    reserva.setVuelo(vuelo);
    reserva.setCliente(cliente);

    reservaRepo.save(reserva);
    return Mapper.toDTO(reserva);
  }

  @Override
  public void deleteReserva(Long id) {
    ReservaPasaje reserva = reservaRepo.findById(id).orElse(null);
    if (reserva == null)
      throw new NotFoundException("Reserva del Pasaje no encontrada");

    reservaRepo.delete(reserva);
  }

}
