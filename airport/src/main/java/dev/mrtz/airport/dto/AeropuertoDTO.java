package dev.mrtz.airport.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AeropuertoDTO {
  private Long id;
  private String nombre;
  private String localidad;
  private String provincia;
}
