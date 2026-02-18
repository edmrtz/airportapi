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

  private long id;
  private long idRuta;
  private Date fechaSalida;
  private int asientosTotales;
  private int asientosDisponibles;
}
