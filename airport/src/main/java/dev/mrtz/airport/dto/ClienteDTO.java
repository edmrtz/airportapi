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
public class ClienteDTO {
    private long id;
    private String nombre;
    private String apellido;
    private int dni;
    private Date fechaNacimiento;
    private String telefono;
    private String email;
}
