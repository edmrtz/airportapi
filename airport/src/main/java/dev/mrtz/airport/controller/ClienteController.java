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

import dev.mrtz.airport.dto.ClienteDTO;
import dev.mrtz.airport.service.ClienteService;

@RequestMapping("/api/clientes")
@RestController
public class ClienteController {
  @Autowired
  public ClienteService clienteService;

  @GetMapping
  public ResponseEntity<List<ClienteDTO>> getClientes() {
    return ResponseEntity.ok(clienteService.getClientes());

  }

  @PostMapping
  public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO dto) {
    ClienteDTO cliente = clienteService.createCliente(dto);
    return ResponseEntity.created(URI.create("/api/clientes/" + cliente.getId())).body(cliente);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Long id, @RequestBody ClienteDTO dto) {
    return ResponseEntity.ok(clienteService.updateCliente(id, dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
    clienteService.deleteCliente(id);
    return ResponseEntity.noContent().build();
  }
}
