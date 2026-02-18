package dev.mrtz.airport.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RutaDTO {

  private Long id;
  private Long idAeropuertoOrigen;
  private Long idAeropuertoDestino;
}
