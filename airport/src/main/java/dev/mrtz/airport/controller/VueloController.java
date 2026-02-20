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

import dev.mrtz.airport.dto.VueloDTO;
import dev.mrtz.airport.service.VueloService;

@RestController
@RequestMapping("/api/vuelos")
public class VueloController {

  @Autowired
  public VueloService vueloService;

  @GetMapping
  public ResponseEntity<List<VueloDTO>> getVuelos() {
    return ResponseEntity.ok(vueloService.getVuelos());
  }

  @PostMapping
  public ResponseEntity<VueloDTO> createVuelo(@RequestBody VueloDTO dto) {
    VueloDTO vuelo = vueloService.createVuelo(dto);
    return ResponseEntity.created(URI.create("/api/vuelos" + vuelo.getId())).body(vuelo);
  }

  @PutMapping("/{id}")
  public ResponseEntity<VueloDTO> updateVuelo(@PathVariable Long id, @RequestBody VueloDTO dto) {
    return ResponseEntity.ok(vueloService.updateVuelo(id, dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteVuelo(@PathVariable Long id) {
    vueloService.deleteVuelo(id);
    return ResponseEntity.noContent().build();
  }
}
