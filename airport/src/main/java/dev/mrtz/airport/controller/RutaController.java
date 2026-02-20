package dev.mrtz.airport.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.mrtz.airport.dto.RutaDTO;
import dev.mrtz.airport.service.RutaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/rutas")
public class RutaController {
  @Autowired
  public RutaService rutaService;

  @GetMapping
  public ResponseEntity<List<RutaDTO>> getRutas() {
    return ResponseEntity.ok(rutaService.getRutas());
  }

  @PostMapping
  public ResponseEntity<RutaDTO> createRuta(@RequestBody RutaDTO dto) {
    RutaDTO ruta = rutaService.createRuta(dto);
    return ResponseEntity.created(URI.create("/api/rutas" + ruta.getId())).body(ruta);
  }

  @PutMapping("/{id}")
  public ResponseEntity<RutaDTO> updateRuta(@PathVariable Long id, @RequestBody RutaDTO dto) {
    return ResponseEntity.ok(rutaService.updateRuta(id, dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteRuta(@PathVariable Long id) {
    rutaService.deleteRuta(id);
    return ResponseEntity.noContent().build();
  }
}
