package dev.mrtz.airport.service;

import java.util.List;

import dev.mrtz.airport.dto.ClienteDTO;

public interface IClienteService {

  List<ClienteDTO> getClientes();

  ClienteDTO createCliente(ClienteDTO dto);

  ClienteDTO updateCliente(Long id, ClienteDTO dto);

  void deleteCliente(Long id);
}
