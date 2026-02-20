package dev.mrtz.airport.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.mrtz.airport.dto.ReservaPasajeDTO;
import dev.mrtz.airport.service.ReservaPasajeService;

@RequestMapping("/api/reservas")
@RestController
public class ReservaPasajeController {
  @Autowired
  public ReservaPasajeService reservaPasajeService;

  @GetMapping
  public ResponseEntity<List<ReservaPasajeDTO>> getReservas() {
    return ResponseEntity.ok(reservaPasajeService.getReservas());
  }

  @PostMapping
  public ResponseEntity<ReservaPasajeDTO> createReserva(@RequestBody ReservaPasajeDTO dto) {
    ReservaPasajeDTO reserva = reservaPasajeService.createReserva(dto);
    return ResponseEntity.created(URI.create("/api/reservas" + reserva.getId())).body(reserva);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ReservaPasajeDTO> updateReserva(@PathVariable Long id, @RequestBody ReservaPasajeDTO dto) {
    return ResponseEntity.ok(reservaPasajeService.updateReserva(id, dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteReserva(@PathVariable Long id) {
    reservaPasajeService.deleteReserva(id);
    return ResponseEntity.noContent().build();
  }
}
