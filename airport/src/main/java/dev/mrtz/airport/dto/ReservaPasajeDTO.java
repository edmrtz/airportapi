package dev.mrtz.airport.dto;

import java.util.Date;

import dev.mrtz.airport.enums.Estado;

public class ReservaPasajeDTO {
    private long id;

    private long idVuelo;
    private long idCliente;

    private Date fechaReserva;
    private int nroAsiento;
    private Date fechaCheckIn;
    private Estado estado;
}
