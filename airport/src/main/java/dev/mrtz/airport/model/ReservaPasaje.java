package dev.mrtz.airport.model;

import java.util.Date;

import dev.mrtz.airport.enums.Estado;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity
public class ReservaPasaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long idVuelo;
    private long idCliente;
    private Date fechaReserva;
    private int nroAsiento;
    private Date fechaCheckIn;
    private Estado estado;
}
