package dev.mrtz.airport.service;

import java.util.List;

import dev.mrtz.airport.dto.ClienteDTO;
import dev.mrtz.airport.exception.NotFoundException;
import dev.mrtz.airport.mapper.Mapper;
import dev.mrtz.airport.model.Cliente;
import dev.mrtz.airport.repository.ClienteRepository;

public class ClienteService implements IClienteService {
  private ClienteRepository repo;

  @Override
  public List<ClienteDTO> getClientes() {
    return repo.findAll().stream().map(Mapper::toDTO).toList();
  }

  @Override
  public ClienteDTO createCliente(ClienteDTO dto) {
    if (dto == null)
      return null;

    Cliente cliente = Cliente.builder()
        .nombre(dto.getNombre())
        .apellido(dto.getApellido())
        .dni(dto.getDni())
        .fechaNacimiento(dto.getFechaNacimiento())
        .telefono(dto.getTelefono())
        .email(dto.getEmail()).build();

    repo.save(cliente);
    ClienteDTO output = Mapper.toDTO(cliente);
    return output;
  }

  @Override
  public ClienteDTO updateCliente(Long id, ClienteDTO dto) {
    Cliente cliente = repo.findById(id).orElse(null);
    if (cliente == null)
      throw new NotFoundException("Cliente no encontrado");

    if (dto.getNombre() != null)
      cliente.setNombre(dto.getNombre());
    if (dto.getApellido() != null)
      cliente.setApellido(dto.getApellido());
    if (dto.getDni() != null)
      cliente.setDni(dto.getDni());
    if (dto.getFechaNacimiento() != null)
      cliente.setFechaNacimiento(dto.getFechaNacimiento());
    if (dto.getTelefono() != null)
      cliente.setTelefono(dto.getTelefono());
    if (dto.getEmail() != null)
      cliente.setEmail(dto.getEmail());

    repo.save(cliente);
    ClienteDTO output = Mapper.toDTO(cliente);
    return output;
  }

  @Override
  public void deleteCliente(Long id) {
    Cliente cliente = repo.findById(id).orElse(null);
    if (cliente == null)
      throw new NotFoundException("Cliente no encontrado");

    repo.delete(cliente);
  }

}
