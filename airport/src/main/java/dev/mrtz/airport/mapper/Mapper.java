package dev.mrtz.airport.mapper;

import dev.mrtz.airport.dto.AeropuertoDTO;
import dev.mrtz.airport.dto.ClienteDTO;
import dev.mrtz.airport.dto.ReservaPasajeDTO;
import dev.mrtz.airport.dto.RutaDTO;
import dev.mrtz.airport.dto.VueloDTO;
import dev.mrtz.airport.model.Aeropuerto;
import dev.mrtz.airport.model.Cliente;
import dev.mrtz.airport.model.ReservaPasaje;
import dev.mrtz.airport.model.Ruta;
import dev.mrtz.airport.model.Vuelo;

public class Mapper {

  public static VueloDTO toDTO(Vuelo v) {
    if (v == null)
      return null;

    Ruta ruta = v.getRuta();

    return VueloDTO.builder()
        .idRuta(ruta.getId())
        .fechaSalida(v.getFechaSalida())
        .asientosTotales(v.getAsientosTotales())
        .asientosDisponibles(v.getAsientosDisponibles()).build();
  }

  public static ClienteDTO toDTO(Cliente c) {
    if (c == null)
      return null;

    return ClienteDTO.builder()
        .nombre(c.getNombre())
        .apellido(c.getApellido())
        .dni(c.getDni())
        .fechaNacimiento(c.getFechaNacimiento())
        .telefono(c.getTelefono())
        .email(c.getEmail()).build();
  }

  public static ReservaPasajeDTO toDTO(ReservaPasaje rp) {
    if (rp == null)
      return null;

    Vuelo vuelo = rp.getVuelo();
    Cliente cliente = rp.getCliente();

    return ReservaPasajeDTO.builder()
        .idVuelo(vuelo.getId())
        .idCliente(cliente.getId())
        .fechaReserva(rp.getFechaReserva())
        .nroAsiento(rp.getNroAsiento())
        .fechaCheckIn(rp.getFechaCheckIn())
        .estado(rp.getEstado()).build();
  }

  public static RutaDTO toDTO(Ruta r) {
    if (r == null)
      return null;

    Aeropuerto origen = r.getOrigen();
    Aeropuerto destino = r.getDestino();

    return RutaDTO.builder()
        .idAeropuertoOrigen(origen.getId())
        .idAeropuertoDestino(destino.getId()).build();

  }

  public static AeropuertoDTO toDTO(Aeropuerto a) {
    if (a == null)
      return null;

    return AeropuertoDTO.builder()
        .nombre(a.getNombre())
        .localidad(a.getLocalidad())
        .provincia(a.getProvincia()).build();
  }
}
