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

import dev.mrtz.airport.dto.AeropuertoDTO;
import dev.mrtz.airport.service.AeropuertoService;

@RestController
@RequestMapping("/api/aeropuertos")
public class AeropuertoController {

  @Autowired
  public AeropuertoService aeropuertoService;

  @GetMapping
  public ResponseEntity<List<AeropuertoDTO>> getAeropuertos() {
    return ResponseEntity.ok(aeropuertoService.getAeropuertos());
  }

  @PostMapping
  public ResponseEntity<AeropuertoDTO> createAeropuerto(@RequestBody AeropuertoDTO dto) {
    AeropuertoDTO aeropuerto = aeropuertoService.createAeropuerto(dto);
    return ResponseEntity.created(URI.create("/api/aeropuertos" + aeropuerto.getId())).body(aeropuerto);
  }

  @PutMapping("/{id}")
  public ResponseEntity<AeropuertoDTO> updateAeropuerto(@RequestBody AeropuertoDTO dto, @PathVariable Long id) {
    return ResponseEntity.ok(aeropuertoService.updateAeropuerto(id, dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAeropuerto(@PathVariable Long id) {
    aeropuertoService.deleteAeropuerto(id);
    return ResponseEntity.noContent().build();
  }
}
