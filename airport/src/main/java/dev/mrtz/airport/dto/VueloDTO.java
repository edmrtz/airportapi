package dev.mrtz.airport.dto;

import java.util.Date;

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
public class VueloDTO {

  private Long id;
  private Long idRuta;
  private Date fechaSalida;
  private Integer asientosTotales;
  private Integer asientosDisponibles;
}
