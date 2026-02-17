@startuml
!theme toy
class Cliente {
+ id: Long
+ nombre: String
+ apellido: String
+ dni: int
+ f_nac: LocalDate
+ telefono: int
+ email: String
}

class Aeropuerto {
+ id: Long
+ nombre: String
+ localidad: String
+ provincia: String
}

class Ruta {
+ id: Long
+ idAeropuertoOrigen: Long
+ idAeropuertoDestino: Long
}

class Vuelo {
+ id: Long
+ idRuta: Long
+ f_salida: LocalDate
+ hora_salida: Time
+ asientosTotales: int
+ asientosDisponibles: int
}

class ReservaPasaje {
+ id: Long
+ idVuelo: Long
+ idCliente: Long
+ f_reserva: LocalDate
+ nroAsiento: int
+ f_checkIn: LocalDate
+ estado: Enum
}
@enduml