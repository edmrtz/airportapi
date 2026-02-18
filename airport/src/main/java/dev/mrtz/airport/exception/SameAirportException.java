package dev.mrtz.airport.exception;

public class SameAirportException extends RuntimeException {
  public SameAirportException(String msg) {
    super(msg);
  }
}
