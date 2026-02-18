package dev.mrtz.airport.service;

import java.util.List;

import dev.mrtz.airport.dto.ReservaPasajeDTO;

public interface IReservaPasajeService {

  List<ReservaPasajeDTO> getReservas();

  ReservaPasajeDTO createReserva(ReservaPasajeDTO dto);

  ReservaPasajeDTO updateReserva(Long id, ReservaPasajeDTO dto);

  void deleteReserva(Long id);
}
